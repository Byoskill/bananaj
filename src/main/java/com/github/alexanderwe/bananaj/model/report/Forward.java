/**
 * @author alexanderweiss
 * @date 20.11.2015
 */
package com.github.alexanderwe.bananaj.model.report;

// TODO: Auto-generated Javadoc
/**
 * Class for representing a forward in a campaign.
 *
 * @author alexanderweiss
 */
public class Forward{

	/** The count. */
	private int count;
	
	/** The forwards open. */
	private int forwards_open;
	
	/**
	 * Instantiates a new forward.
	 *
	 * @param count the count
	 * @param forward_open the forward open
	 */
	public Forward(int count, int forward_open) {
		this.count = count;
		this.forwards_open = forward_open;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Gets the forwards open.
	 *
	 * @return the forwards_open
	 */
	public int getForwards_open() {
		return forwards_open;
	}
}
