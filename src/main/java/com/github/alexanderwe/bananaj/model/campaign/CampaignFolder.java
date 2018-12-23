package com.github.alexanderwe.bananaj.model.campaign;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.model.MailchimpObject;


/**
 * Created by alexanderweiss on 10.08.2016.
 */
public class CampaignFolder extends MailchimpObject{


    /** The name. */
    private String name;
    
    /** The count. */
    private int count;


    /**
     * Instantiates a new campaign folder.
     *
     * @param id the id
     * @param name the name
     * @param count the count
     * @param jsonCampaignFolder the json campaign folder
     */
    public CampaignFolder(String id, String name, int count, JSONObject jsonCampaignFolder) {
        super(id, jsonCampaignFolder);
        this.name = name;
        this.count = count;
    }

    /**
     * Instantiates a new campaign folder.
     *
     * @param jsonCampaignFolder the json campaign folder
     */
    public CampaignFolder(JSONObject jsonCampaignFolder) {
        super(jsonCampaignFolder.getString("id"), jsonCampaignFolder);
        this.name = jsonCampaignFolder.getString("name");
        this.count = jsonCampaignFolder.getInt("count");
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return "ID: " + super.getId() + System.lineSeparator() +
                "Name: " + this.getName() + System.lineSeparator() +
                "Count: " + this.getCount();
    }
}
