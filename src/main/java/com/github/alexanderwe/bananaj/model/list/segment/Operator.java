package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 27.12.16.
 */
public enum Operator {

    // Note: Mandrill ConditionType has unknown possible values for 'op'

    /** The open. */
    OPEN("open"), /** The click. */
 CLICK("click"), /** The sent. */
 SENT("sent"), /** The noopen. */
 NOOPEN("noopen"), /** The noclick. */
 NOCLICK("noclick"), /** The nosent. */
 NOSENT("nosent"),
    
    /** The started. */
    STARTED("started"), 
 /** The completed. */
 COMPLETED("completed"), 
 /** The not started. */
 NOT_STARTED("not_started"), 
 /** The not completed. */
 NOT_COMPLETED("not_completed"),
    
    /** The member. */
    MEMBER("member"), 
 /** The notmember. */
 NOTMEMBER("notmember"),
    
    /** The greater. */
    GREATER("greater"), 
 /** The less. */
 LESS("less"), 
    
    /** The is. */
    IS("is"), 
 /** The not. */
 NOT("not"), 
    
    /** The blank. */
    BLANK("blank"), 
 /** The blank not. */
 BLANK_NOT("blank_not"),
    
    /** The client is. */
    CLIENT_IS("client_is"), 
 /** The client not. */
 CLIENT_NOT("client_not"),
    
    /** The source is. */
    SOURCE_IS("source_is"), 
 /** The source not. */
 SOURCE_NOT("source_not"),
    
    /** The interestcontains. */
    INTERESTCONTAINS("interestcontains"), 
 /** The interestcontainsall. */
 INTERESTCONTAINSALL("interestcontainsall"), 
 /** The interestnotcontains. */
 INTERESTNOTCONTAINS("interestnotcontains"),
    
    /** The contains. */
    CONTAINS("contains"), 
 /** The notcontain. */
 NOTCONTAIN("notcontain"), 
    
    /** The starts. */
    STARTS("starts"), 
 /** The ends. */
 ENDS("ends"),
    
    /** The goal not. */
    GOAL_NOT("goal_not"), 
 /** The goal notcontain. */
 GOAL_NOTCONTAIN("goal_notcontain"),
    
    /** The fuzzy is. */
    FUZZY_IS("fuzzy_is"), 
 /** The fuzzy not. */
 FUZZY_NOT("fuzzy_not"),
    
    /** The static is. */
    STATIC_IS("static_is"), 
 /** The static not. */
 STATIC_NOT("static_not"),
    
    /** The ipgeocountry. */
    IPGEOCOUNTRY("ipgeocountry"), 
 /** The ipgeonotcountry. */
 IPGEONOTCOUNTRY("ipgeonotcountry"), 
 /** The ipgeostate. */
 IPGEOSTATE("ipgeostate"), 
 /** The ipgeonotstate. */
 IPGEONOTSTATE("ipgeonotstate"),
	
	/** The ipgeoin. */
	IPGEOIN("ipgeoin"), 
 /** The ipgeonotin. */
 IPGEONOTIN("ipgeonotin"),
	
	/** The ipgeoinzip. */
	IPGEOINZIP("ipgeoinzip"),
	
	/** The ipgeounknown. */
	IPGEOUNKNOWN("ipgeounknown"),
	
	/** The ipgeoiszip. */
	IPGEOISZIP("ipgeoiszip"), 
 /** The ipgeonotzip. */
 IPGEONOTZIP("ipgeonotzip"),
	
	/** The follow. */
	FOLLOW("follow"), 
 /** The notfollow. */
 NOTFOLLOW("notfollow"),
	
	/** The geoin. */
	GEOIN("geoin");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, Operator> CONSTANTS = new HashMap<String, Operator>();

    static {
        for (Operator c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new operator.
     *
     * @param value the value
     */
    private Operator(String value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    /**
     * Value.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value.
     *
     * @param value the value
     * @return the operator
     */
    public static Operator fromValue(String value) {
    	Operator constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
