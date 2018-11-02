package com.github.alexanderwe.bananaj.connection;

import com.github.alexanderwe.bananaj.model.MailchimpObject;
import org.json.JSONObject;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * Class for representing your mailchimp account.
 */
 public class Account extends MailchimpObject{

	/** The connection. */
	private MailChimpConnection connection;
	
	/** The api key. */
	private String apiKey;
	
	/** The account name. */
	private String account_name;
	
	/** The company. */
	private String company;
	
	/** The address 1. */
	private String address1;
	
	/** The address 2. */
	private String address2;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The zip. */
	private String zip;
	
	/** The country. */
	private String country;
	
	/** The last login. */
	private LocalDateTime last_login;
	
	/** The subscriber count. */
	private int subscriber_count;

	/**
	 * Instantiates a new account.
	 *
	 * @param connection the connection
	 * @param id the id
	 * @param account_name the account name
	 * @param company the company
	 * @param address1 the address 1
	 * @param address2 the address 2
	 * @param city the city
	 * @param state the state
	 * @param zip the zip
	 * @param country the country
	 * @param last_login the last login
	 * @param subscriber_count the subscriber count
	 * @param jsonrepresentation the jsonrepresentation
	 */
	public Account(MailChimpConnection connection, String id, String account_name, String company, String address1, String address2, String city, String state, String zip, String country, LocalDateTime last_login, int subscriber_count, JSONObject jsonrepresentation) {
		super(id, jsonrepresentation);
		this.connection = connection;
		this.account_name = account_name;
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.last_login = last_login;
		this.subscriber_count = subscriber_count;
		this.apiKey = getApiKey();
	}

	/**
	 * Gets the connection.
	 *
	 * @return the com.github.alexanderwe.bananaj.connection
	 */
	public MailChimpConnection getConnection() {
		return connection;
	}

	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Gets the address 1.
	 *
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}


	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Gets the api key.
	 *
	 * @return the apiKey
	 */
	protected String getApiKey() {
		return apiKey;
	}

	/**
	 * Gets the address 2.
	 *
	 * @return the address 2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public LocalDateTime getLast_login() {
	return last_login;
}

	/**
	 * Gets the account name.
	 *
	 * @return the account name
	 */
	public String getAccount_name() {
		return account_name;
	}

	/**
	 * Gets the subscriber count.
	 *
	 * @return the subscriber count
	 */
	public int getSubscriber_count() {
		return subscriber_count;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.company + System.lineSeparator() +
				this.address1 + System.lineSeparator() +
				this.address2 + System.lineSeparator() +
				this.zip + System.lineSeparator() +
				this.city + System.lineSeparator() +
				this.state + System.lineSeparator() +
				"Last Login: " + this.last_login + System.lineSeparator() +
				"Total subscribers: " + this.subscriber_count;
	}
}