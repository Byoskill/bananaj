/**
 * 
 */
package com.github.alexanderwe.bananaj.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class TransportException.
 *
 * @author USCRIGA
 * TODO: Maybe add some additional fields like type, title, detail etc. to make them accessible to the user
 */
public class TransportException extends Exception {

	/**
	 * Instantiates a new transport exception.
	 */
	public TransportException() {
		super("Mailchimp transport failure");
	}

	/**
	 * Instantiates a new transport exception.
	 *
	 * @param message the detail message
	 */
	public TransportException(String message) {
		super(message);
	}


	/**
	 * Instantiates a new transport exception.
	 *
	 * @param cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public TransportException(Throwable cause) {
		super("Mailchimp transport failure", cause);
	}

	/**
	 * Instantiates a new transport exception.
	 *
	 * @param message the detail message
	 * @param cause cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public TransportException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new transport exception.
	 *
	 * @param message the detail message
	 * @param cause cause the cause. (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 * @param enableSuppression whether or not suppression is enabled or disabled
	 * @param writableStackTrace whether or not the stack trace should be writable
	 */
	public TransportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
