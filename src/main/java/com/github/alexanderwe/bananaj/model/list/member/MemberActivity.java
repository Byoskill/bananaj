package com.github.alexanderwe.bananaj.model.list.member;

// TODO: Auto-generated Javadoc
/**
 * Created by alexanderweiss on 20.01.16.
 */
public class MemberActivity {

    /** The unique email id. */
    String unique_email_id;
    
    /** The list id. */
    String list_id;
    
    /** The action. */
    String action;
    
    /** The timestamp. */
    String timestamp;
    
    /** The url. */
    String url;
    
    /** The type. */
    String type;
    
    /** The campaign id. */
    String campaign_id;
    
    /** The title. */
    String title;
    
    /** The parent campaign. */
    String parent_campaign;

    /**
     * Instantiates a new member activity.
     *
     * @param unique_email_id the unique email id
     * @param list_id the list id
     * @param action the action
     * @param timestamp the timestamp
     * @param campaign_id the campaign id
     * @param title the title
     */
    public MemberActivity(String unique_email_id, String list_id, String action, String timestamp, String campaign_id, String title){
        this.unique_email_id = unique_email_id;
        this.list_id = list_id;
        this.action = action;
        this.timestamp = timestamp;
        this.campaign_id = campaign_id;
        this.title = title;
    }

    /**
     * Actions like unsub do not have a title.
     *
     * @param unique_email_id the unique email id
     * @param list_id the list id
     * @param action the action
     * @param timestamp the timestamp
     * @param campaign_id the campaign id
     */
    public MemberActivity(String unique_email_id, String list_id, String action, String timestamp, String campaign_id){
        this.unique_email_id = unique_email_id;
        this.list_id = list_id;
        this.action = action;
        this.timestamp = timestamp;
        this.campaign_id = campaign_id;
    }

    /**
     * Gets the unique email id.
     *
     * @return the unique email id
     */
    public String getUnique_email_id() {
        return unique_email_id;
    }

    /**
     * Gets the list id.
     *
     * @return the list id
     */
    public String getList_id() {
        return list_id;
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the campaign id.
     *
     * @return the campaign id
     */
    public String getCampaign_id() {
        return campaign_id;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the parent campaign.
     *
     * @return the parent campaign
     */
    public String getParent_campaign() {
        return parent_campaign;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return "Title: " +this.title +
                " Action: " + this.action +
                " Timestamp: " + this.timestamp +System.lineSeparator();
    }
}
