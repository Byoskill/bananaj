/**
 * @author alexanderweiss
 * @date 20.11.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

// TODO: Auto-generated Javadoc
/**
 * The Enum CampaignStatus.
 */
public enum CampaignStatus {

    /** The save. */
    SAVE("save"),
    /** The paused. */
    PAUSED("paused"),
    /** The schedule. */
    SCHEDULE("schedule"),
    /** The sending. */
    SENDING("sending"),
    /** The sent. */
    SENT("sent");

    /** The string representation. */
    private String stringRepresentation;

    /**
     * Instantiates a new campaign status.
     *
     * @param stringRepresentation the string representation
     */
    CampaignStatus(String stringRepresentation) {
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
