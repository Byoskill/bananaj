/**
 * @author alexanderweiss
 * @date 30.11.2015
 */
package com.github.alexanderwe.bananaj.model.automation;

import com.github.alexanderwe.bananaj.model.MailchimpObject;
import com.github.alexanderwe.bananaj.model.list.MailChimpList;
import org.json.JSONObject;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * Class for representing an automation.
 *
 * @author alexanderweiss
 */
public class Automation extends MailchimpObject {

	/** The create time. */
	private LocalDateTime create_time;
	
	/** The start time. */
	private LocalDateTime start_time;
	
	/** The status. */
	private AutomationStatus status;
	
	/** The emails sent. */
	private int emails_sent;
	
	/** The mail chimp list. */
	private MailChimpList mailChimpList;
		
	/**
	 * Instantiates a new automation.
	 *
	 * @param id the id
	 * @param create_time the create time
	 * @param start_time the start time
	 * @param status the status
	 * @param emails_sent the emails sent
	 * @param mailChimpList the mail chimp list
	 * @param jsonRepresentation the json representation
	 */
	public Automation(String id, LocalDateTime create_time, LocalDateTime start_time, AutomationStatus status, int emails_sent, MailChimpList mailChimpList, JSONObject jsonRepresentation) {
		super(id,jsonRepresentation);
		this.create_time = create_time;
		this.start_time = start_time;
		this.status = status;
		this.emails_sent = emails_sent;
		this.mailChimpList = mailChimpList;
		
	}

	/**
	 * Gets the creates the time.
	 *
	 * @return the create_time
	 */
	public LocalDateTime getCreate_time() {
		return create_time;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start_time
	 */
	public LocalDateTime getStart_time() {
		return start_time;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public AutomationStatus getStatus() {
		return status;
	}

	/**
	 * Gets the emails sent.
	 *
	 * @return the emails_sent
	 */
	public int getEmails_sent() {
		return emails_sent;
	}

	/**
	 * Gets the mail chimp list.
	 *
	 * @return the mailChimpList
	 */
	public MailChimpList getMailChimpList() {
		return mailChimpList;
	}

}
