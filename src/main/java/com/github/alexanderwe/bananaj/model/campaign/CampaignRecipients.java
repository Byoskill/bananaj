package com.github.alexanderwe.bananaj.model.campaign;

import javax.annotation.Nullable;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.exceptions.ConditionException;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignRecipients.
 */
public class CampaignRecipients {

    /** The list id. */
    private String              list_id;

    /** The segment opts. */
    private CampaignSegmentOpts segment_opts;

    /**
     * Used when created a Condition locally with the Builder class.
     *
     * @param b the builder
     * @see Builder
     */
    public CampaignRecipients(Builder b) {
        this.segment_opts = b.segment_opts;
        this.list_id      = b.list_id;
    }

    /**
     * Gets the list id.
     *
     * @return the list id
     */
    public String getListId() {
        return list_id;
    }

    /**
     * Gets the segment opts.
     *
     * @return the segment opts
     */
    public CampaignSegmentOpts getSegmentOpts() {
        return segment_opts;
    }

    /**
     * Gets the json representation.
     *
     * @return the json representation
     */
    public JSONObject getJsonRepresentation() {
        JSONObject recipents = new JSONObject();

        recipents.put("list_id", getListId());
        if (getSegmentOpts() != null) {
            recipents.put("segment_opts", getSegmentOpts().getJsonRepresentation());
        }

        return recipents;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Nullable
    @Override
    public String toString() {
        return "List ID: " + getListId() + System.lineSeparator() +
                "Segment opts: " + getSegmentOpts();
    }

    /**
     * The Class Builder.
     */
    public static class Builder {

        /** The list id. */
        private String              list_id;

        /** The segment opts. */
        private CampaignSegmentOpts segment_opts;

        /**
         * List id.
         *
         * @param list_id the list id
         * @return the builder
         */
        public Builder listId(String list_id) {
            this.list_id = list_id;
            return this;
        }

        /**
         * Segment opts.
         *
         * @param op the op
         * @return the builder
         */
        public Builder segmentOpts(CampaignSegmentOpts op) {
            this.segment_opts = op;
            return this;
        }

        /**
         * Builds the campaign recipient.
         *
         * @return the campaign recipients
         */
        public CampaignRecipients build() {
            return new CampaignRecipients(this);
        }
    }

}
