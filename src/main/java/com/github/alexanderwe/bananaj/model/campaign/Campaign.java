/**
 * @author alexanderweiss
 * @date 19.11.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import com.github.alexanderwe.bananaj.exceptions.CampaignSettingsException;
import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.model.list.MailChimpList;
import com.github.alexanderwe.bananaj.model.report.Click;
import com.github.alexanderwe.bananaj.model.report.FacebookLikes;
import com.github.alexanderwe.bananaj.model.report.Forward;
import com.github.alexanderwe.bananaj.model.report.IndustryStats;
import com.github.alexanderwe.bananaj.model.report.Open;
import com.github.alexanderwe.bananaj.model.report.Report;
import com.github.alexanderwe.bananaj.model.report.ReportListStats;
import com.github.alexanderwe.bananaj.utils.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class for representing a mailchimp campaign.
 *
 * @author alexanderweiss
 */
public class Campaign extends MailchimpObject {

	/** The connection. */
	private MailChimpConnection connection;
	
	/** The mail chimp list. */
	private MailChimpList mailChimpList;
	
	/** The content. */
	private CampaignContent content;
	
	/** The reportendpoint. */
	private String REPORTENDPOINT;
	
	/** The campaign type. */
	private CampaignType campaign_type;
	
	/** The campaign status. */
	private CampaignStatus campaign_status;
	
	/** The campaign settings. */
	private CampaignSettings campaignSettings;

	private static final Logger LOGGER = LoggerFactory.getLogger(Campaign.class);
	
	
	/**
	 * Instantiates a new campaign.
	 *
	 * @param id the id
	 * @param mailChimpList the mail chimp list
	 * @param campaign_type the campaign type
	 * @param campaign_status the campaign status
	 * @param campaignSettings the campaign settings
	 * @param connection the connection
	 * @param jsonRepresentation the json representation
	 */
	public Campaign(String id, MailChimpList mailChimpList, CampaignType campaign_type, CampaignStatus campaign_status, CampaignSettings campaignSettings, MailChimpConnection connection, JSONObject jsonRepresentation) {
		super(id,jsonRepresentation);
		this.connection = connection;
		this.mailChimpList = mailChimpList;
		this.REPORTENDPOINT = "https://"+this.connection.getServer()+".api.mailchimp.com/3.0/reports/"+this.getId();
		this.campaign_type = campaign_type;
		this.campaign_status = campaign_status;
		this.campaignSettings = campaignSettings;
		try {
			setContent();
		} catch (Exception e) {
			LOGGER.error("Could not create unmarshall the campaign object", e);
		}
	}
	
	/**
	 * Instantiates a new campaign.
	 *
	 * @param connection the connection
	 * @param campaign the campaign
	 * @throws Exception the exception
	 */
	public Campaign(MailChimpConnection connection, JSONObject campaign) throws Exception {
		super(campaign.getString("id"), campaign);
		this.connection = connection;
		
		JSONObject recipients = campaign.getJSONObject("recipients");
		JSONObject campaignSettings = campaign.getJSONObject("settings");
		String campaignType = campaign.getString("type");
		String campaignStatus = campaign.getString("status");
		CampaignSettings settings = new CampaignSettings(connection, this.getId(), campaignSettings);
		
		if (recipients.has("list_id")) {
			this.mailChimpList = connection.getList(recipients.getString("list_id"));
		}
		this.REPORTENDPOINT = "https://"+this.connection.getServer()+".api.mailchimp.com/3.0/reports/"+this.getId();
		this.campaign_type = CampaignType.valueOf(campaignType.toUpperCase());
		this.campaign_status = CampaignStatus.valueOf(campaignStatus.toUpperCase());
		this.campaignSettings = settings;
		try {
			setContent();
		} catch (Exception e) {
            LOGGER.error("Could not create unmarshall the campaign object", e);
		}
	}

	/**
	 * Replace the campaign settings with a new one.
	 *
	 * @param campaignSettings the campaign settings
	 * @throws CampaignSettingsException the campaign settings exception
	 * @throws Exception the exception
	 */
	public void overwriteSettings (CampaignSettings campaignSettings) throws CampaignSettingsException, Exception {
		campaignSettings.setCampaignId(this.getId());
		campaignSettings.setConnection(this.getConnection());

		JSONObject updatedCampaign = new JSONObject();
		JSONObject updatedSettings = new JSONObject();
		updatedSettings.put("from_name", campaignSettings.getTitle());
		updatedSettings.put("subject_line", campaignSettings.getSubject_line());
		updatedSettings.put("title", campaignSettings.getTitle());
		updatedSettings.put("reply_to", campaignSettings.getReply_to());
		updatedCampaign.put("settings", updatedSettings);
		this.getConnection().do_Patch(new URL(this.getConnection().getCampaignendpoint()+"/"+this.getId()),updatedCampaign.toString(),this.getConnection().getApikey());
		this.campaignSettings = campaignSettings;
	}

	/**
	 * Send the campaign to the mailChimpList members.
	 *
	 * @throws Exception the exception
	 */
	public void send() throws Exception{
		getConnection().do_Post(new URL(connection.getCampaignendpoint()+"/"+this.getId()+"/actions/send"),connection.getApikey());
	}
	
	/**
	 * Send the campaign to the mailChimpList members.
	 *
	 * @param emails the emails
	 * @param type the type
	 * @throws Exception the exception
	 */
	public void sendTestEmail(String[] emails, CampaignSendType type) throws Exception {
		JSONObject data = new JSONObject();
		JSONArray testEmails = new JSONArray();
		for (String email : emails) {
			testEmails.put(email);
		}
		data.put("test_emails", testEmails);
		data.put("send_type", type.toString());
		getConnection().do_Post(new URL(connection.getCampaignendpoint()+"/"+this.getId()+"/actions/test"), data.toString(), connection.getApikey());
	}
	
	/**
	 * Stops the sending of your campaign
	 * (!Only included in mailchimp pro).
	 *
	 * @throws Exception the exception
	 */
	public void cancelSend() throws Exception{
		getConnection().do_Post(new URL(connection.getCampaignendpoint()+"/"+this.getId()+"/actions/cancel-send"),connection.getApikey());
	}

	/**
	 * Get the report of this campaign.
	 *
	 * @return the report
	 * @throws Exception the exception
	 */
	public Report getReport() throws Exception{

		final JSONObject report = new JSONObject(connection.do_Get(new URL(getREPORTENDPOINT()),connection.getApikey()));
		final JSONObject bounces = report.getJSONObject("bounces");
		final JSONObject forwards = report.getJSONObject("forwards");
		final JSONObject opens = report.getJSONObject("opens");
		final JSONObject clicks = report.getJSONObject("clicks");
		final JSONObject facebook_likes = report.getJSONObject("facebook_likes");
		final JSONObject industry_stats = report.getJSONObject("industry_stats");
		final JSONObject report_list_stats = report.getJSONObject("list_stats");


		Bounce bouncesObject = new Bounce(bounces.getInt("hard_bounces"),bounces.getInt("soft_bounces"),bounces.getInt("syntax_errors"));
		Forward forwardsObject = new Forward(forwards.getInt("forwards_count"), forwards.getInt("forwards_opens"));
		Click clicksObject = new Click(clicks.getInt("clicks_total"),clicks.getInt("unique_clicks"),clicks.getInt("unique_subscriber_clicks"),clicks.getDouble("click_rate"), DateConverter.getInstance().createDateFromISO8601(clicks.getString("last_click")));
		Open opensObject = new Open(opens.getInt("opens_total"),opens.getInt("unique_opens"), opens.getDouble("open_rate"), opens.getString("last_open"));
		FacebookLikes facebookObject = new FacebookLikes(facebook_likes.getInt("recipient_likes"),facebook_likes.getInt("unique_likes"),facebook_likes.getInt("facebook_likes"));
		IndustryStats industryStatsObject = new IndustryStats(industry_stats.getString("type"), industry_stats.getDouble("open_rate"),industry_stats.getDouble("click_rate"),industry_stats.getDouble("bounce_rate"),industry_stats.getDouble("unopen_rate"),industry_stats.getDouble("unsub_rate"), industry_stats.getDouble("abuse_rate"));
		ReportListStats reportListStatsObject = new ReportListStats(report_list_stats.getDouble("sub_rate"), report_list_stats.getDouble("unsub_rate"), report_list_stats.getDouble("open_rate"), report_list_stats.getDouble("click_rate"));


		return new Report(report.getString("id"), report.getString("campaign_title"),report.getInt("emails_sent"),report.getInt("abuse_reports"), report.getInt("unsubscribed"),DateConverter.getInstance().createDateFromISO8601(report.getString("send_time")),bouncesObject,forwardsObject,clicksObject,opensObject,facebookObject,industryStatsObject,reportListStatsObject,report);
	}

	/**
	 * Gets the connection.
	 *
	 * @return the com.github.alexanderwe.bananaj.connection
	 */
	public MailChimpConnection getConnection() {
		return connection;
	}

	/**
	 * Gets the reportendpoint.
	 *
	 * @return the REPORTSENDPOINT
	 */
	public String getREPORTENDPOINT() {
		return REPORTENDPOINT;
	}

	/**
	 * Gets the campaign type.
	 *
	 * @return the campaign_type
	 */
	public CampaignType getCampaign_type() {
		return campaign_type;
	}

	/**
	 * Gets the campaign status.
	 *
	 * @return the campaign_status
	 */
	public CampaignStatus getCampaign_status() {
		return campaign_status;
	}

	/**
	 * Gets the mail chimp list.
	 *
	 * @return the mailChimpList
	 */
	public MailChimpList getMailChimpList() {
		return mailChimpList;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public CampaignContent getContent() {
		return content;
	}

	/**
	 * Set the content of this campaign.
	 *
	 * @throws Exception the exception
	 */
	private void setContent() throws Exception{
		JSONObject jsonContentFromCall = new JSONObject(getConnection().do_Get(new URL(connection.getCampaignendpoint()+"/"+this.getId()+"/content"),connection.getApikey()));
		this.content = new CampaignContent(
				jsonContentFromCall.has("plain_text") ? jsonContentFromCall.getString("plain_text") : null, 
				jsonContentFromCall.has("html") ? jsonContentFromCall.getString("html") : null, 
				this) ;
	}

	/**
	 * Gets the campaign settings.
	 *
	 * @return the campaign settings
	 */
	public CampaignSettings getCampaignSettings() {
		return campaignSettings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "ID: " + this.getId() + System.lineSeparator() +
				"Title: " +this.getCampaignSettings().getTitle() + System.lineSeparator() +
				"Type of campaign: " + this.getCampaign_type().getStringRepresentation() +  System.lineSeparator() +
				"Status of campaign: " + this.getCampaign_status().getStringRepresentation() + System.lineSeparator();
	}


}
