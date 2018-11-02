/**
 * @author alexanderweiss
 * @date 13.12.2015
 */
package com.github.alexanderwe.bananaj.model.report;


// TODO: Auto-generated Javadoc
/**
 * Class for representing list stats in a report object.
 *
 * @author alexanderweiss
 */
public class ReportListStats {

	/** The sub rate. */
	private double sub_rate;
	
	/** The unsub rate. */
	private double unsub_rate;
	
	/** The open rate. */
	private double open_rate;
	
	/** The click rate. */
	private double click_rate;
	
	/**
	 * Instantiates a new report list stats.
	 *
	 * @param sub_rate the sub rate
	 * @param unsub_rate the unsub rate
	 * @param open_rate the open rate
	 * @param click_rate the click rate
	 */
	public ReportListStats(double sub_rate, double unsub_rate, double open_rate, double click_rate) {
		this.sub_rate = sub_rate;
		this.unsub_rate = unsub_rate;
		this.open_rate = open_rate;
		this.click_rate = click_rate;
	}

	/**
	 * Gets the sub rate.
	 *
	 * @return the sub_rate
	 */
	public double getSub_rate() {
		return sub_rate;
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

}
