/**
 * @author alexanderweiss
 * @date 30.11.2015
 */
package com.github.alexanderwe.bananaj.model.automation;

// TODO: Auto-generated Javadoc
/**
 * The Enum AutomationStatus.
 */
public enum AutomationStatus {

	/** The save. */
	SAVE("save"),/** The paused. */
PAUSED("paused"),/** The sending. */
SENDING("sending");

	
	/** The string representation. */
	private String stringRepresentation;
	
	/**
	 * Instantiates a new automation status.
	 *
	 * @param stringRepresentation the string representation
	 */
	AutomationStatus(String stringRepresentation){
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
	private void setStringRepresentation(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}
}


