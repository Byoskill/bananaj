/**
 * @author alexanderweiss
 * @date 12.12.2015
 */
package com.github.alexanderwe.bananaj.model.report;

// TODO: Auto-generated Javadoc
/**
 * Class for representing the opens of a campaign.
 *
 * @author alexanderweiss
 */
public class Open {

	/** The opens total. */
	private int opens_total;
	
	/** The unique opens. */
	private int unique_opens;
	
	/** The open rate. */
	private double open_rate;
	
	/** The last open. */
	private String last_open;
	
	
	/**
	 * Instantiates a new open.
	 *
	 * @param opens_total the opens total
	 * @param unique_opens the unique opens
	 * @param open_rate the open rate
	 * @param last_open the last open
	 */
	public Open(int opens_total, int unique_opens, double open_rate, String last_open) {
		this.opens_total = opens_total;
		this.unique_opens = unique_opens;
		this.open_rate = open_rate;
		this.last_open = last_open;
	}

	/**
	 * Gets the opens total.
	 *
	 * @return the opens_total
	 */
	public int getOpens_total() {
		return opens_total;
	}

	/**
	 * Gets the unique opens.
	 *
	 * @return the unique_opens
	 */
	public int getUnique_opens() {
		return unique_opens;
	}

	/**
	 * Gets the open rate.
	 *
	 * @return the open_rate
	 */
	public double getOpen_rate() {
		return open_rate;
	}

	/**
	 * Gets the last open.
	 *
	 * @return the last_open
	 */
	public String getLast_open() {
		return last_open;
	}
}
