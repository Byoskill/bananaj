package com.github.alexanderwe.bananaj.model.list.interests;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Enum InterestCategoryType.
 */
public enum InterestCategoryType {

	/** The checkboxes. */
	CHECKBOXES("checkboxes"),
	
	/** The dropdown. */
	DROPDOWN("dropdown"),
	
	/** The radio. */
	RADIO("radio"),
	
	/** The hidden. */
	HIDDEN("hidden");
	
    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, InterestCategoryType> CONSTANTS = new HashMap<String, InterestCategoryType>();

    static {
        for (InterestCategoryType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new interest category type.
     *
     * @param value the value
     */
    private InterestCategoryType(String value) {
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
     * @return the interest category type
     */
    public static InterestCategoryType fromValue(String value) {
    	InterestCategoryType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
