/**
 * @author alexanderweiss
 * @date 19.11.2015
 */
package com.github.alexanderwe.bananaj.model.report;

import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.model.campaign.Bounce;
import org.json.JSONObject;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * Object for representing a report of a campaign.
 *
 * @author alexanderweiss
 */
public class Report extends MailchimpObject{

	/** The campaign title. */
	private String campaign_title;
	
	/** The emails sent total. */
	private int emails_sent_total;
	
	/** The abuse report. */
	private int abuse_report;
	
	/** The unsubscribe total. */
	private int unsubscribe_total;
	
	/** The time sent. */
	private LocalDateTime time_sent;
	
	/** The bounces. */
	private Bounce bounces;
	
	/** The forwards. */
	private Forward forwards;
	
	/** The opens. */
	private Open opens;
	
	/** The clicks. */
	private Click clicks;
	
	/** The facebook likes. */
	private FacebookLikes facebook_likes;
	
	/** The industry stats. */
	private IndustryStats industry_stats;
	
	/** The report list stats. */
	private ReportListStats report_list_stats;
	
	
	/**
	 * Instantiates a new report.
	 *
	 * @param campaignID the campaign ID
	 * @param campaign_title the campaign title
	 * @param emails_sent_total the emails sent total
	 * @param abuse_report the abuse report
	 * @param unsubscribe_total the unsubscribe total
	 * @param time_sent the time sent
	 * @param bounces the bounces
	 * @param forwards the forwards
	 * @param clicks the clicks
	 * @param opens the opens
	 * @param facebook_likes the facebook likes
	 * @param industry_stats the industry stats
	 * @param report_list_stats the report list stats
	 * @param jsonRepresentation the json representation
	 */
	public Report(String campaignID,String campaign_title, int emails_sent_total, int abuse_report, int unsubscribe_total, LocalDateTime time_sent, Bounce bounces, Forward forwards,Click clicks,Open opens,FacebookLikes facebook_likes,IndustryStats industry_stats,ReportListStats report_list_stats,JSONObject jsonRepresentation) {
		super(campaignID,jsonRepresentation);
		this.campaign_title = campaign_title;
		this.emails_sent_total = emails_sent_total;
		this.abuse_report = abuse_report;
		this.unsubscribe_total = unsubscribe_total;
		this.time_sent = time_sent;
		this.bounces = bounces;
		this.forwards = forwards;
		this.clicks = clicks;
		this.opens = opens;
		this.facebook_likes = facebook_likes;
		this.industry_stats = industry_stats;
		this.report_list_stats = report_list_stats;
	}


	/**
	 * Gets the emails send total.
	 *
	 * @return the emails_send
	 */
	public int getEmails_send_total() {
		return emails_sent_total;
	}

	/**
	 * Gets the campaign title.
	 *
	 * @return the campaign_title
	 */
	public String getCampaign_title() {
		return campaign_title;
	}

	/**
	 * Gets the abuse report.
	 *
	 * @return the abuse_report
	 */
	public int getAbuse_report() {
		return abuse_report;
	}

	/**
	 * Gets the unsubscribe total.
	 *
	 * @return the unsubscribe_total
	 */
	public int getUnsubscribe_total() {
		return unsubscribe_total;
	}

	/**
	 * Gets the time sent.
	 *
	 * @return the time_sent
	 */
	public LocalDateTime getTime_sent() {
		return time_sent;
	}

	/**
	 * Gets the bounces.
	 *
	 * @return the bounces
	 */
	public Bounce getBounces() {
		return bounces;
	}

	/**
	 * Gets the forwards.
	 *
	 * @return the forwards
	 */
	public Forward getForwards() {
		return forwards;
	}

	/**
	 * Gets the clicks.
	 *
	 * @return the clicks
	 */
	public Click getClicks() {
		return clicks;
	}

	/**
	 * Gets the opens.
	 *
	 * @return the opens
	 */
	public Open getOpens() {
		return opens;
	}

	/**
	 * Gets the facebook likes.
	 *
	 * @return the facebook_likes
	 */
	public FacebookLikes getFacebook_likes() {
		return facebook_likes;
	}

	/**
	 * Gets the industry stats.
	 *
	 * @return the industry_stats
	 */
	public IndustryStats getIndustry_stats() {
		return industry_stats;
	}

	/**
	 * Gets the report list stats.
	 *
	 * @return the report_list_stats
	 */
	public ReportListStats getReport_list_stats() {
		return report_list_stats;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Report of campaign: " + this.getId() +" " +this.getCampaign_title() + System.lineSeparator() +
				"Total emails sent: " + this.getEmails_send_total() + System.lineSeparator() +
				"Total abuse reports: " + this.getAbuse_report() +  System.lineSeparator() +
				"Total unsubscribed: " + this.getUnsubscribe_total() + System.lineSeparator() +
				"Time sent: " + this.getTime_sent() + System.lineSeparator() +
				"Bounces: " + System.lineSeparator() +
				"    Soft bounces: " + this.getBounces().getSoft_bounces() + System.lineSeparator() +
				"    Hard bounces: " +  this.getBounces().getHard_bounces() + System.lineSeparator() +
				"    Syntax error bounces: " + this.getBounces().getSyntax_error_bounces() + System.lineSeparator() +
				"Forwards: " + System.lineSeparator() +
				"    Forward count: " + this.getForwards().getCount() + System.lineSeparator() +
				"    Forward open: " + this.getForwards().getForwards_open() + System.lineSeparator() +
				"Clicks: " + System.lineSeparator() +
				"    Clicks total: " + this.getClicks().getClicks_total() + System.lineSeparator() +
				"    Unique clicks: " + this.getClicks().getUnique_clicks() + System.lineSeparator() +
				"    Unique subscriber links: " + this.getClicks().getUnique_subscriber_clicks() + System.lineSeparator() +
				"    Click rate: " + this.getClicks().getClick_rate() + System.lineSeparator() +
				"    Last click: " + this.getClicks().getLast_click();
	}

}
