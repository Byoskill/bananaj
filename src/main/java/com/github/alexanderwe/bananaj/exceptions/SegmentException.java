package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 27.12.16.
 */
public class SegmentException extends Exception {

    /**
     * Instantiates a new segment exception.
     */
    public SegmentException() {
        super("A member can only be added to a static segment.");
    }

    /**
     * Instantiates a new segment exception.
     *
     * @param message the message
     */
    public SegmentException(String message) {
        super(message);
    }

    /**
     * Instantiates a new segment exception.
     *
     * @param cause the cause
     */
    public SegmentException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new segment exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public SegmentException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new segment exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public SegmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
