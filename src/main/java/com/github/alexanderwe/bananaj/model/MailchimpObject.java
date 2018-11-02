/**
 * @author alexanderweiss
 * @date 19.11.2015
 */
package com.github.alexanderwe.bananaj.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Super class for all objects retrieved from mailchimp.
 *
 * @author alexanderweiss
 */
public class MailchimpObject{

	/** The id. */
	private String id;
	
	/** The json representation. */
	private JSONObject jsonRepresentation;
	
	/**
	 * Instantiates a new mailchimp object.
	 *
	 * @param id the id
	 * @param jsonResponse the json response
	 */
	public MailchimpObject(String id, JSONObject jsonResponse){
		this.id = id;
		this.jsonRepresentation = jsonResponse;
	}

	/**
	 * Instantiates a new mailchimp object.
	 */
	public MailchimpObject () {

	}

	/**
	 * Gets the id.
	 *
	 * @return the id of this mailchimp object (m5 hash value)
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the JSON representation.
	 *
	 * @return the jsonRepresentation
	 */
	public JSONObject getJSONRepresentation() {
		return jsonRepresentation;
	}

	/**
	 * Sets the JSON representation.
	 *
	 * @param jsonRepresentation the jsonRepresentation to set
	 * @throws JSONException the JSON exception
	 */
	public void setJSONRepresentation(JSONObject jsonRepresentation) {
		this.jsonRepresentation = jsonRepresentation;
	}
}
