package com.github.alexanderwe.bananaj.model.list.member;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Enum EmailType.
 */
public enum EmailType {

	/** The html. */
	HTML("html"),
	
	/** The text. */
	TEXT("text");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, EmailType> CONSTANTS = new HashMap<String, EmailType>();

    static {
        for (EmailType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new email type.
     *
     * @param value the value
     */
    private EmailType(String value) {
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
     * @return the email type
     */
    public static EmailType fromValue(String value) {
    	EmailType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
