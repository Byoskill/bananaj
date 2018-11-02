/**
 * @author alexanderweiss
 * @date 13.12.2015
 */
package com.github.alexanderwe.bananaj.model.report;


// TODO: Auto-generated Javadoc
/**
 * Class for representing the average campaign statistics for your industry.
 *
 * @author alexanderweiss
 */
public class IndustryStats {

	/** The type. */
	private String type;
	
	/** The open rate. */
	private double open_rate;
	
	/** The click rate. */
	private double click_rate;
	
	/** The bounce rate. */
	private double bounce_rate;
	
	/** The unopen rate. */
	private double unopen_rate;
	
	/** The unsub rate. */
	private double unsub_rate;
	
	/** The abuse rate. */
	private double abuse_rate;
	
	
	/**
	 * Instantiates a new industry stats.
	 *
	 * @param type the type
	 * @param open_rate the open rate
	 * @param click_rate the click rate
	 * @param bounce_rate the bounce rate
	 * @param unopen_rate the unopen rate
	 * @param unsub_rate the unsub rate
	 * @param absue_rate the absue rate
	 */
	public IndustryStats(String type, double open_rate, double click_rate, double bounce_rate, double unopen_rate, double unsub_rate, double absue_rate) {
		this.type = type;
		this.open_rate = open_rate;
		this.click_rate = click_rate;
		this.bounce_rate = bounce_rate;
		this.unopen_rate = unopen_rate;
		this.unsub_rate = unsub_rate;
		this.abuse_rate = absue_rate;
	}


	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
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
	 * Gets the click rate.
	 *
	 * @return the click_rate
	 */
	public double getClick_rate() {
		return click_rate;
	}

	/**
	 * Gets the bounce rate.
	 *
	 * @return the bounce_rate
	 */
	public double getBounce_rate() {
		return bounce_rate;
	}

	/**
	 * Gets the unopen rate.
	 *
	 * @return the unopen_rate
	 */
	public double getUnopen_rate() {
		return unopen_rate;
	}

	/**
	 * Gets the unsub rate.
	 *
	 * @return the unsub_rate
	 */
	public double getUnsub_rate() {
		return unsub_rate;
	}

	/**
	 * Gets the abuse rate.
	 *
	 * @return the abuse_rate
	 */
	public double getAbuse_rate() {
		return abuse_rate;
	}
}
