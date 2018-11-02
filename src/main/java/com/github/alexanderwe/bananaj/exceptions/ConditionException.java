package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 02.01.17.
 */
public class ConditionException extends Exception {

    /**
     * Instantiates a new condition exception.
     */
    public ConditionException()  {
        super("Invalid condition");
    }

    /**
     * Instantiates a new condition exception.
     *
     * @param message the message
     */
    public ConditionException(String message) {
        super(message);
    }

    /**
     * Instantiates a new condition exception.
     *
     * @param cause the cause
     */
    public ConditionException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new condition exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public ConditionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new condition exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ConditionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
