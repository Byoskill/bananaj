package com.github.alexanderwe.bananaj.model.template;

import org.json.JSONObject;

import com.github.alexanderwe.bananaj.model.MailchimpObject;

// TODO: Auto-generated Javadoc
/**
 * Class for representing a template folder
 * Created by alexanderweiss on 10.08.2016.
 */
public class TemplateFolder extends MailchimpObject{

    /** The name. */
    private String name;
    
    /** The count. */
    private int count;


    /**
     * Instantiates a new template folder.
     *
     * @param id the id
     * @param name the name
     * @param count the count
     * @param jsonTemplateFolder the json template folder
     */
    public TemplateFolder(String id, String name, int count, JSONObject jsonTemplateFolder) {
        super(id, jsonTemplateFolder);
        this.name = name;
        this.count = count;
    }

    /**
     * Instantiates a new template folder.
     *
     * @param jsonTemplateFolder the json template folder
     */
    public TemplateFolder(JSONObject jsonTemplateFolder) {
        super(jsonTemplateFolder.getString("id"), jsonTemplateFolder);
        this.name = jsonTemplateFolder.getString("name");
        this.count = jsonTemplateFolder.getInt("count");
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
