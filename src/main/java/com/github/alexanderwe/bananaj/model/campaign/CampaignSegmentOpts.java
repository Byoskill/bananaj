package com.github.alexanderwe.bananaj.model.campaign;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.alexanderwe.bananaj.exceptions.ConditionException;
import com.github.alexanderwe.bananaj.model.list.segment.AbstractCondition;
import com.github.alexanderwe.bananaj.model.list.segment.MatchType;

/**
 * The Class CampaignSegmentOpts.
 */
public class CampaignSegmentOpts {

    /** The saved segment id. */
    private Integer                 saved_segment_id;

    /** The match. */
    private MatchType               match;

    /** The conditions. */
    private List<AbstractCondition> conditions;

    /**
     * Used when created a Condition locally with the Builder class.
     *
     * @param b the b
     * @see Builder
     */

    public CampaignSegmentOpts(Builder b) {
        this.saved_segment_id = b.saved_segment_id;
        this.match            = b.match;
        this.conditions       = b.conditions;
    }

    /**
     * Gets the saved segment id.
     *
     * @return the saved segment id
     */
    public Integer getSavedSegmentId() {
        return saved_segment_id;
    }

    /**
     * Gets the match.
     *
     * @return the match
     */
    public MatchType getMatch() {
        return match;
    }

    /**
     * Gets the conditions.
     *
     * @return the conditions
     */
    public List<AbstractCondition> getConditions() {
        return conditions;
    }

    /**
     * Gets the json representation.
     *
     * @return the json representation
     */
    public JSONObject getJsonRepresentation() {
        JSONObject segmentOpts = new JSONObject();

        if (getSavedSegmentId() != null) {
            segmentOpts.put("saved_segment_id", getSavedSegmentId());
        }

        if (getMatch() != null) {
            segmentOpts.put("match", getMatch().value());
        }

        if (getConditions() != null) {
            JSONArray                   jsonConditions = new JSONArray();
            Iterator<AbstractCondition> i              = getConditions().iterator();
            while (i.hasNext()) {
                jsonConditions.put(i.next());
            }
            segmentOpts.put("conditions", jsonConditions);
        }

        return segmentOpts;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Saved Segment ID: " + getSavedSegmentId() + System.lineSeparator() +
                "Match: " + getMatch() + System.lineSeparator() +
                "Conditions: " + getConditions() + System.lineSeparator();
    }

    /**
     * The Class Builder.
     */
    public static class Builder {

        /** The saved segment id. */
        private Integer                 saved_segment_id;

        /** The match. */
        private MatchType               match;

        /** The conditions. */
        private List<AbstractCondition> conditions;

        /**
         * Saved segment id.
         *
         * @param saved_segment_id the saved segment id
         * @return the builder
         */
        public Builder savedSegmentId(Integer saved_segment_id) {
            this.saved_segment_id = saved_segment_id;
            return this;
        }

        /**
         * Match.
         *
         * @param match the match
         * @return the builder
         */
        public Builder match(MatchType match) {
            this.match = match;
            return this;
        }

        /**
         * Conditions.
         *
         * @param conditions the conditions
         * @return the builder
         */
        public Builder conditions(List<AbstractCondition> conditions) {
            this.conditions = conditions;
            return this;
        }

        /**
         * Builds the.
         *
         * @return the campaign segment opts
         */
        public CampaignSegmentOpts build() {
            return new CampaignSegmentOpts(this);
        }
    }

}
