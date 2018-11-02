/**
 * @author alexanderweiss
 * @date 12.12.2015
 */
package com.github.alexanderwe.bananaj.model.report;


// TODO: Auto-generated Javadoc
/**
 * Class for representing facebook likes.
 *
 * @author alexanderweiss
 */
public class FacebookLikes {

	/** The recipient likes. */
	private int recipient_likes;
	
	/** The unique likes. */
	private int unique_likes;
	
	/** The facebook likes. */
	private int facebook_likes;
	
	/**
	 * Instantiates a new facebook likes.
	 *
	 * @param recipient_likes the recipient likes
	 * @param unique_likes the unique likes
	 * @param facebook_likes the facebook likes
	 */
	public FacebookLikes(int recipient_likes, int unique_likes, int facebook_likes  ) {
		this.recipient_likes = recipient_likes;
		this.unique_likes = unique_likes;
		this.facebook_likes = facebook_likes;
	}

	/**
	 * Gets the recipient likes.
	 *
	 * @return the recipient_likes
	 */
	public int getRecipient_likes() {
		return recipient_likes;
	}

	/**
	 * Gets the unique likes.
	 *
	 * @return the unique_likes
	 */
	public int getUnique_likes() {
		return unique_likes;
	}

	/**
	 * Gets the facebook likes.
	 *
	 * @return the facebook_likes
	 */
	public int getFacebook_likes() {
		return facebook_likes;
	}

}
