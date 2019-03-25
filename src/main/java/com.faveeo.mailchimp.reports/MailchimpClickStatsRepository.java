package com.faveeo.mailchimp.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@JsonIgnoreProperties
public class MailchimpClickStatsRepository {
    private static final int COUNT = 100;

    private static final Logger log = LoggerFactory.getLogger(MailchimpClickStatsRepository.class);
    private List<MailchimpReport> mailChimpCampaignReports = Collections.synchronizedList(new ArrayList<>());
    private Set<String> treatedReports = Collections.synchronizedSet(new HashSet<>());
    private List<MailchimpClickDetail> clickDetailsRepository = new ArrayList<>();

    public static MailchimpClickStatsRepository loadRepository() throws IOException {
        final File file = getScoreRepositoryFile();
        if (!file.exists()) return new MailchimpClickStatsRepository();
        final ObjectMapper objectMapper = initObjectMapper();
        return objectMapper.readValue(file, MailchimpClickStatsRepository.class);
    }

    private static File getScoreRepositoryFile() {
        return new File("scoreRepository.json");
    }

    public static ObjectMapper initObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());
        final SimpleModule simpleModule = new SimpleModule();
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

    public static MailchimpClickStatsRepository loadRepository(File repositoryFile) throws IOException {
        final ObjectMapper objectMapper = initObjectMapper();
        return objectMapper.readValue(repositoryFile, MailchimpClickStatsRepository.class);
    }

    public Set<String> getTreatedReports() {
        return treatedReports;
    }

    public void setTreatedReports(final Set<String> treatedReports) {
        this.treatedReports = treatedReports;
    }

    public List<MailchimpReport> getMailChimpCampaignReports() {
        return mailChimpCampaignReports;
    }

    public void setMailChimpCampaignReports(final List<MailchimpReport> mailChimpCampaignReports) {
        this.mailChimpCampaignReports = mailChimpCampaignReports;
    }

    public List<MailchimpClickDetail> getClickDetailsRepository() {
        return clickDetailsRepository;
    }

    public void setClickDetailsRepository(final List<MailchimpClickDetail> clickDetailsRepository) {
        this.clickDetailsRepository = clickDetailsRepository;
    }

    public void loadStats(MailchimpReportClient mailchimpReportClient) throws IOException {
        final ObjectMapper objectMapper = initObjectMapper();
        if (mailChimpCampaignReports.isEmpty()) {
            int offset = 0;
            int res = 0;
            do {
                res = fetchReports(mailchimpReportClient, offset);
                offset += res;
            } while (res == COUNT);
        }
        log.info("Found {} reports", mailChimpCampaignReports.size());
        scoreRepository(objectMapper);
        log.info("Fetching clicks");

        final List<MailchimpReport> mailchimpReports = mailChimpCampaignReports
                .stream()
                .filter(report -> !treatedReports.contains(report.id))
                .collect(Collectors.toList());


        AtomicInteger treated = new AtomicInteger(mailchimpReports.size() - treatedReports.size());
        mailchimpReports.forEach(report -> {
            try {
                log.info("Campaign -> {}", report.campaign_title);
                this.fetchReportClick(mailchimpReportClient, report);
                treatedReports.add(report.id);
                scoreRepository(objectMapper);
            } catch (IOException e) {
                log.error("Cannot fetch all the clicks", e);
            } finally {
                treated.decrementAndGet();
                log.info("Remaining : {}", treated.get());

            }
        });

        scoreRepository(objectMapper);

    }

    private int fetchReports(final MailchimpReportClient mailchimpReportClient, final int offset) throws IOException {
        final JsonNode body = mailchimpReportClient.getReports(COUNT, offset).execute().body();

        log.info("Loading the list of reports");
        final JsonNode reportsNode = Objects.requireNonNull(body).get("reports");

        int res = 0;
        for (JsonNode jsonNode : reportsNode) {
            res++;

            final MailchimpReport mailchimpReport = new MailchimpReport();
            mailchimpReport.id = jsonNode.get("id").asText();
            mailchimpReport.campaign_title = jsonNode.get("campaign_title").asText();
            mailchimpReport.list_id = jsonNode.get("list_id").asText();
            mailchimpReport.send_time = new DateTime(jsonNode.get("send_time").asText());
            log.info("Report {}", mailchimpReport);

            mailChimpCampaignReports.add(mailchimpReport);


        }
        log.info("Read {} reports", res);
        return res;
    }

    private void scoreRepository(final ObjectMapper objectMapper) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(getScoreRepositoryFile(), this);
    }

    private void fetchReportClick(final MailchimpReportClient mailchimpReportClient, final MailchimpReport report) throws IOException {

        int offset = 0;

        int count;
        do {
            count = 0;
            final JsonNode reportNode = mailchimpReportClient.getClickDetailsReportCampaign(report.id, COUNT, offset).execute().body();
            JsonNode jsonNode = Objects.requireNonNull(reportNode).get("urls_clicked");
            for (final JsonNode jsonClickDetail : jsonNode) {
                final MailchimpClickDetail mailchimpClickDetail = new MailchimpClickDetail();
                mailchimpClickDetail.url = jsonClickDetail.get("url").textValue();
                mailchimpClickDetail.click_percentage = jsonClickDetail.get("click_percentage").intValue();
                mailchimpClickDetail.total_clicks = jsonClickDetail.get("total_clicks").intValue();
                mailchimpClickDetail.unique_clicks = jsonClickDetail.get("unique_clicks").intValue();
                mailchimpClickDetail.unique_click_percentage = jsonClickDetail.get("unique_click_percentage").intValue();
                mailchimpClickDetail.listID = report.list_id;
                mailchimpClickDetail.campaignName = report.id;

                this.clickDetailsRepository.add(mailchimpClickDetail);
                count++;
            }
            offset += COUNT;
        } while (count > 0);

        log.info("Imported clicks {}", this.clickDetailsRepository.size());

    }

    public List<MailchimpClickDetail> mergeAndReturnClickDetails(String listeID) {

        final Map<String, List<MailchimpClickDetail>> stringListMap = clickDetailsRepository.stream()
                .filter(cd -> cd.listID.equals(listeID))
                .collect(Collectors.groupingBy(cdetail -> cdetail.url));
        List<MailchimpClickDetail> aggregatedStats = new ArrayList<>(clickDetailsRepository.size());
        stringListMap.forEach((key, value) -> {
            final MailchimpClickDetail mailchimpClickDetail = value.get(0);
            mailchimpClickDetail.total_clicks = value.stream().mapToInt(cd -> cd.total_clicks).sum();
            mailchimpClickDetail.unique_clicks = value.stream().mapToInt(cd -> cd.unique_clicks).sum();
            mailchimpClickDetail.unique_click_percentage =
                    (int) Math.round(value.stream().mapToDouble(cd -> cd.unique_click_percentage).average().getAsDouble());
            mailchimpClickDetail.click_percentage = (int) Math.round(value.stream().mapToDouble(cd -> cd.click_percentage).average().getAsDouble());
            aggregatedStats.add(mailchimpClickDetail);
        });

        return aggregatedStats;
    }
}
