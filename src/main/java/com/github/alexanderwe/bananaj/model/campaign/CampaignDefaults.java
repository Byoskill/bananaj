/**
 * @author alexanderweiss
 * @date 05.12.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;


/**
 * The Class CampaignDefaults.
 */
public class CampaignDefaults {

	
	/** The from name. */
	private String from_name;
	
	/** The from email. */
	private String from_email;
	
	/** The subject. */
	private String subject;
	
	/** The language. */
	private String language;
	
	/**
	 * Instantiates a new campaign defaults.
	 *
	 * @param from_name the from name
	 * @param from_email the from email
	 * @param subject the subject
	 * @param language the language
	 */
	public CampaignDefaults(String from_name, String from_email, String subject, String language) {
		this.from_name = from_name;
		this.from_email = from_email;
		this.subject = subject;
		this.language = language;
	}

	/**
	 * Gets the from name.
	 *
	 * @return the from_name
	 */
	public String getFrom_name() {
		return from_name;
	}

	/**
	 * Gets the from email.
	 *
	 * @return the from_email
	 */
	public String getFrom_email() {
		return from_email;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

}
