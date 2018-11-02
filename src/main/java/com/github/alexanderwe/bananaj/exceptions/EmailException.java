/**
 * @author alexanderweiss
 * @date 05.12.2015
 */
package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailException.
 */
public class EmailException extends Exception {

	/**
	 * Instantiates a new email exception.
	 */
	public EmailException()  {
		super("Invalid email address.");
	}

	/**
	 * Instantiates a new email exception.
	 *
	 * @param message the message
	 */
	public EmailException(String message) {
		super("Invalid email address: " + message);
	}

	/**
	 * Instantiates a new email exception.
	 *
	 * @param cause the cause
	 */
	public EmailException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new email exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public EmailException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new email exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public EmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
