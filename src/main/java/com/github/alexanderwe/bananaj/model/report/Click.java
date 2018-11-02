/**
 * @author alexanderweiss
 * @date 20.11.2015
 */
package com.github.alexanderwe.bananaj.model.report;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * Class for representing clicks for a campaign.
 *
 * @author alexanderweiss
 */
public class Click {
	
	/** The clicks total. */
	private int clicks_total;
	
	/** The unique clicks. */
	private int unique_clicks;
	
	/** The unique subscriber clicks. */
	private int unique_subscriber_clicks;
	
	/** The click rate. */
	private double click_rate;
	
	/** The last click. */
	private LocalDateTime last_click;

	/**
	 * Instantiates a new click.
	 *
	 * @param clicks_total the clicks total
	 * @param unique_clicks the unique clicks
	 * @param unique_subscriber_clicks the unique subscriber clicks
	 * @param click_rate the click rate
	 * @param last_click the last click
	 */
	public Click(int clicks_total, int unique_clicks, int unique_subscriber_clicks, double click_rate, LocalDateTime last_click) {
		this.clicks_total = clicks_total;
		this.unique_clicks = unique_clicks;
		this.unique_subscriber_clicks = unique_subscriber_clicks;
		this.click_rate = click_rate;
		this.last_click = last_click;
	}

	/**
	 * Gets the clicks total.
	 *
	 * @return the clicks_total
	 */
	public int getClicks_total() {
		return clicks_total;
	}

	/**
	 * Gets the unique clicks.
	 *
	 * @return the unique_clicks
	 */
	public int getUnique_clicks() {
		return unique_clicks;
	}

	/**
	 * Gets the unique subscriber clicks.
	 *
	 * @return the unique_subscriber_clicks
	 */
	public int getUnique_subscriber_clicks() {
		return unique_subscriber_clicks;
	}

	/**
	 * Gets the click rate.
	 *
	 * @return the click_rate
	 */
	public double getClick_rate() {
		return click_rate;
	}

	/**
	 * Gets the last click.
	 *
	 * @return the last_click
	 */
	public LocalDateTime getLast_click() {
		return last_click;
	}


}
