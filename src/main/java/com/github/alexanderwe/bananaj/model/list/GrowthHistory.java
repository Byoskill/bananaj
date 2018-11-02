/**
 * @author alexanderweiss
 * @date 07.12.2015
 */
package com.github.alexanderwe.bananaj.model.list;


// TODO: Auto-generated Javadoc
/**
 * Class for representing a growth history of a mailChimpList.
 *
 * @author alexanderweiss
 */
public class GrowthHistory {

	/** The mail chimp list. */
	private MailChimpList mailChimpList;
	
	/** The list id. */
	private String list_id;
	
	/** The month. */
	private String month;
	
	/** The existing. */
	private int existing;
	
	/** The imports. */
	private int imports;
	
	/** The optins. */
	private int optins;

	/**
	 * Instantiates a new growth history.
	 *
	 * @param mailChimpList the mail chimp list
	 * @param month the month
	 * @param existing the existing
	 * @param imports the imports
	 * @param optins the optins
	 */
	public GrowthHistory(MailChimpList mailChimpList, String month, int existing, int imports, int optins) {
		this.mailChimpList = mailChimpList;
		this.list_id = mailChimpList.getId();
		this.month = month;
		this.existing = existing;
		this.imports = imports;
		this.optins = optins;
	}
	
	/**
	 * Gets the mail chimp list.
	 *
	 * @return the mailChimpList
	 */
	public MailChimpList getMailChimpList() {
		return mailChimpList;
	}

	/**
	 * Gets the list id.
	 *
	 * @return the list_id
	 */
	public String getList_id() {
		return list_id;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Gets the existing.
	 *
	 * @return the existing
	 */
	public int getExisting() {
		return existing;
	}

	/**
	 * Gets the imports.
	 *
	 * @return the imports
	 */
	public int getImports() {
		return imports;
	}

	/**
	 * Gets the optins.
	 *
	 * @return the optins
	 */
	public int getOptins() {
		return optins;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Growth History for mailChimpList: " + getList_id() + System.lineSeparator() +
				"Month: " + getMonth() + System.lineSeparator() +
				"Existing members: " + getExisting() + System.lineSeparator() +
				"Imported member: " + getImports() + System.lineSeparator() +
				"Opt-ins: " + getOptins();
	}
	
}
