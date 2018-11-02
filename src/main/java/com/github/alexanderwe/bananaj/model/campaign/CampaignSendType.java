package com.github.alexanderwe.bananaj.model.campaign;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Enum CampaignSendType.
 */
public enum CampaignSendType {

	/** The html. */
	HTML("html"),
	
	/** The plaintext. */
	PLAINTEXT("plaintext");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, CampaignSendType> CONSTANTS = new HashMap<String, CampaignSendType>();

    static {
        for (CampaignSendType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new campaign send type.
     *
     * @param value the value
     */
    private CampaignSendType(String value) {
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
     * @return the campaign send type
     */
    public static CampaignSendType fromValue(String value) {
    	CampaignSendType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
