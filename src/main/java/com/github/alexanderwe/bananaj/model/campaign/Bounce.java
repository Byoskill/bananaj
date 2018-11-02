/**
 * @author alexanderweiss
 * @date 20.11.2015
 */
package com.github.alexanderwe.bananaj.model.campaign;

// TODO: Auto-generated Javadoc
/**
 * Class representing a bounce for a campaign.
 *
 * @author alexanderweiss
 */
public class Bounce {

	/** The hard bounces. */
	private int hard_bounces;
	
	/** The soft bounces. */
	private int soft_bounces;
	
	/** The syntax error bounces. */
	private int syntax_error_bounces;
	
	/**
	 * Instantiates a new bounce.
	 *
	 * @param hard_bounces the hard bounces
	 * @param soft_bounces the soft bounces
	 * @param syntax_error_bounces the syntax error bounces
	 */
	public Bounce(int hard_bounces, int soft_bounces, int syntax_error_bounces) {
		this.hard_bounces = hard_bounces;
		this.soft_bounces = soft_bounces;
		this.syntax_error_bounces = syntax_error_bounces;
	}

	/**
	 * Gets the hard bounces.
	 *
	 * @return the hard_bounces
	 */
	public int getHard_bounces() {
		return hard_bounces;
	}

	/**
	 * Gets the soft bounces.
	 *
	 * @return the soft_bounces
	 */
	public int getSoft_bounces() {
		return soft_bounces;
	}

	/**
	 * Gets the syntax error bounces.
	 *
	 * @return the syntax_error_bounces
	 */
	public int getSyntax_error_bounces() {
		return syntax_error_bounces;
	}

}
