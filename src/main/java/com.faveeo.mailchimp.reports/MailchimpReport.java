package com.faveeo.mailchimp.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailchimpReport {
    public String id;
    public String campaign_title;
    public String list_id;
    public DateTime send_time;
    public MailchimpReportOpens opens;
    public MailchimpReportClicks clicks;
    public MailchimpReportIndustryStats industry_stats;
    public String subject_line;
    public String preview_text;
}
