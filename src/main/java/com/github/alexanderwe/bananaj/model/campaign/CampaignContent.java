/**
 * @author alexanderweiss
 * @date 12.12.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

import org.json.JSONObject;

import java.net.URL;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignContent.
 */
public class CampaignContent {

	/** The campaign. */
	private Campaign campaign;
	
	/** The plain text. */
	private String plain_text;
	
	/** The html. */
	private String html;
	
	/**
	 * Instantiates a new campaign content.
	 *
	 * @param plain_text the plain text
	 * @param html the html
	 * @param campaign the campaign
	 */
	protected CampaignContent(String plain_text, String html, Campaign campaign) {
		this.campaign = campaign;
		this.plain_text = plain_text;
		this.html = html;
	}



	/**
	 * Gets the plain text.
	 *
	 * @return the plain_text
	 */
	public String getPlain_text() {
		return plain_text;
	}

	/**
	 * Gets the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Gets the campaign.
	 *
	 * @return the campaign this content belongs to
	 */
	public Campaign getCampaign() {
		return campaign;
	}

}
