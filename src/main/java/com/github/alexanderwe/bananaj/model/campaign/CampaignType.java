/**
 * @author alexanderweiss
 * @date 20.11.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

// TODO: Auto-generated Javadoc
/**
 * Enum for representing different campaign types.
 */
public enum CampaignType {

	/** The regular. */
	REGULAR("regular"), /** The plaintext. */
 PLAINTEXT("plaintext"), /** The absplit. */
 ABSPLIT("absplit"), /** The rss. */
 RSS("rss"), /** The automation. */
 AUTOMATION("automation"), /** The variate. */
 VARIATE("variate"), /** The auto. */
 AUTO("auto");
	
	/** The string representation. */
	private String stringRepresentation;
	
	/**
	 * Instantiates a new campaign type.
	 *
	 * @param stringRepresentation the string representation
	 */
	CampaignType(String stringRepresentation ){
		setStringRepresentation(stringRepresentation);
	}

	/**
	 * Gets the string representation.
	 *
	 * @return the stringRepresentation
	 */
	public String getStringRepresentation() {
		return stringRepresentation;
	}

	/**
	 * Sets the string representation.
	 *
	 * @param stringRepresentation the stringRepresentation to set
	 */
	public void setStringRepresentation(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}
	
}
