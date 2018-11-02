package com.github.alexanderwe.bananaj.model.list.segment;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 04.02.16.
 */
public enum ConditionType {

    /** The aim. */
    AIM("Aim"),
    
    /** The automation. */
    AUTOMATION("Automation"),
    
    /** The campaign poll. */
    CAMPAIGN_POLL("CampaignPoll"),
    
    /** The conversation. */
    CONVERSATION("Conversation"),
    
    /** The date. */
    DATE("Date"),
    
    /** The email client. */
    EMAIL_CLIENT("EmailClient"),
    
    /** The language. */
    LANGUAGE("Language"),
    
    /** The mandrill. */
    MANDRILL("Mandrill"),
    
    /** The member rating. */
    MEMBER_RATING("MemberRating"),
    
    /** The signup source. */
    SIGNUP_SOURCE("SignupSource"),
    
    /** The survey monkey. */
    SURVEY_MONKEY("SurveyMonkey"),
    
    /** The vip. */
    VIP("VIP"),
    
    /** The interests. */
    INTERESTS("Interests"),
    
    /** The ecomm category. */
    ECOMM_CATEGORY("EcommCategory"),
    
    /** The ecomm number. */
    ECOMM_NUMBER("EcommNumber"),
    
    /** The ecomm purchased. */
    ECOMM_PURCHASED("EcommPurchased"),
    
    /** The ecomm spent. */
    ECOMM_SPENT("EcommSpent"),
    
    /** The ecomm store. */
    ECOMM_STORE("EcommStore"),
    
    /** The goal activity. */
    GOAL_ACTIVITY("GoalActivity"),
    
    /** The goal timestamp. */
    GOAL_TIMESTAMP("GoalTimestamp"),
    
    /** The fuzzy segment. */
    FUZZY_SEGMENT("FuzzySegment"),
    
    /** The static segment. */
    STATIC_SEGMENT("StaticSegment"),
    
    /** The ip geo country state. */
    IP_GEO_COUNTRY_STATE("IPGeoCountryState"),
    
    /** The ip geo in. */
    IP_GEO_IN("IPGeoIn"),
    
    /** The ip geo in zip. */
    IP_GEO_IN_ZIP("IPGeoInZip"),
    
    /** The ip geo unknown. */
    IP_GEO_UNKNOWN("IPGeoUnknown"),
    
    /** The ip geo zip. */
    IP_GEO_ZIP("IPGeoZip"),
    
    /** The social age. */
    SOCIAL_AGE("SocialAge"),
    
    /** The social gender. */
    SOCIAL_GENDER("SocialGender"),
    
    /** The social influence. */
    SOCIAL_INFLUENCE("SocialInfluence"),
    
    /** The social network member. */
    SOCIAL_NETWORK_MEMBER("SocialNetworkMember"),
    
    /** The social network follow. */
    SOCIAL_NETWORK_FOLLOW("SocialNetworkFollow"),
    
    /** The address merge. */
    ADDRESS_MERGE("AddressMerge"),
    
    /** The zip merge. */
    ZIP_MERGE("ZipMerge"),
    
    /** The birthday merge. */
    BIRTHDAY_MERGE("BirthdayMerge"),
    
    /** The date merge. */
    DATE_MERGE("DateMerge"),
    
    /** The text merge. */
    TEXT_MERGE("TextMerge"),
    
    /** The select merge. */
    SELECT_MERGE("SelectMerge"),
    
    /** The email address. */
    EMAIL_ADDRESS("EmailAddress");

    /** The value. */
    private final String value;
    
    /** The Constant CONSTANTS. */
    private final static Map<String, ConditionType> CONSTANTS = new HashMap<String, ConditionType>();

    static {
        for (ConditionType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    /**
     * Instantiates a new condition type.
     *
     * @param value the value
     */
    private ConditionType(String value) {
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
     * @return the condition type
     */
    public static ConditionType fromValue(String value) {
        ConditionType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
