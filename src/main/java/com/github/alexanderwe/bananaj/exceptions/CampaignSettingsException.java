package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 02.01.17.
 */

public class CampaignSettingsException extends Exception {

    /**
     * Instantiates a new campaign settings exception.
     */
    public CampaignSettingsException()  {
        super("Invalid email address.");
    }

    /**
     * Instantiates a new campaign settings exception.
     *
     * @param message the message
     */
    public CampaignSettingsException(String message) {
        super(message);
    }

    /**
     * Instantiates a new campaign settings exception.
     *
     * @param cause the cause
     */
    public CampaignSettingsException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new campaign settings exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public CampaignSettingsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new campaign settings exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public CampaignSettingsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
