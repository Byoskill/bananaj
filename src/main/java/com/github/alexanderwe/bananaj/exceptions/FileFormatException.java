package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 11.02.16.
 */
public class FileFormatException extends Exception {

    /**
     * Instantiates a new file format exception.
     */
    public FileFormatException() {
        super("Invalid file format. Only use: .xls, .xlxs, .csv or .txt");
    }

    /**
     * Instantiates a new file format exception.
     *
     * @param message the message
     */
    public FileFormatException(String message) {
        super(message);
    }

    /**
     * Instantiates a new file format exception.
     *
     * @param cause the cause
     */
    public FileFormatException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new file format exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new file format exception.
     *
     * @param message the message
     * @param cause the cause
     * @param enableSuppression the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public FileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
