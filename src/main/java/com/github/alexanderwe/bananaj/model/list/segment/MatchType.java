package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 27.12.16.
 */
public enum MatchType {

    /** The any. */
    ANY("any"),
    
    /** The all. */
    ALL("all");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, MatchType> CONSTANTS = new HashMap<String, MatchType>();

    static {
        for (MatchType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new match type.
     *
     * @param value the value
     */
    private MatchType(String value) {
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
     * @return the match type
     */
    public static MatchType fromValue(String value) {
    	MatchType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
