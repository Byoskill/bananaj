package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 04.02.16.
 */
public enum SegmentType {

    /** The saved. */
    SAVED("saved"),
    
    /** The static. */
    STATIC("static"),
    
    /** The fuzzy. */
    FUZZY("fuzzy");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, SegmentType> CONSTANTS = new HashMap<String, SegmentType>();

    static {
        for (SegmentType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new segment type.
     *
     * @param value the value
     */
    private SegmentType(String value) {
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
     * @return the segment type
     */
    public static SegmentType fromValue(String value) {
    	SegmentType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
