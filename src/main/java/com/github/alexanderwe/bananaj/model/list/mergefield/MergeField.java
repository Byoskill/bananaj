package com.github.alexanderwe.bananaj.model.list.mergefield;

import com.github.alexanderwe.bananaj.model.MailchimpObject;
import org.json.JSONObject;


/**
 * Created by Alexander on 09.08.2016.
 */
public class MergeField extends MailchimpObject {


    /** The id. */
    private String id;
    
    /** The tag. */
    private String tag;
    
    /** The name. */
    private String name;
    
    /** The type. */
    private String type;
    
    /** The is required. */
    private boolean isRequired;
    
    /** The default value. */
    private String default_value;
    
    /** The is public. */
    private boolean isPublic;
    
    /** The list id. */
    private String listId;
    
    /** The merge field options. */
    private MergeFieldOptions mergeFieldOptions;


    /**
     * Instantiates a new merge field.
     *
     * @param id the id
     * @param tag the tag
     * @param name the name
     * @param type the type
     * @param isRequired the is required
     * @param default_value the default value
     * @param isPublic the is public
     * @param listId the list id
     * @param mergeFieldOptions the merge field options
     * @param jsonResponse the json response
     */
    public MergeField(String id, String tag, String name, String type, boolean isRequired, String default_value, boolean isPublic, String listId, MergeFieldOptions mergeFieldOptions, JSONObject jsonResponse) {
        super(id, jsonResponse);
        this.tag = tag;
        this.name = name;
        this.type = type;
        this.isRequired = isRequired;
        this.default_value = default_value;
        this.isPublic = isPublic;
        this.listId = listId;
        this.mergeFieldOptions = mergeFieldOptions;
    }


    /**
     * Gets the tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
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
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the required.
     *
     * @return the required
     */
    public boolean getRequired() {
        return isRequired;
    }

    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public String getDefault_value() {
        return default_value;
    }

    /**
     * Checks if is public.
     *
     * @return true, if is public
     */
    public boolean isPublic() {
        return isPublic;
    }

    /**
     * Gets the list id.
     *
     * @return the list id
     */
    public String getListId() {
        return listId;
    }

    /**
     * Gets the merge field options.
     *
     * @return the merge field options
     */
    public MergeFieldOptions getMergeFieldOptions() {
        return mergeFieldOptions;
    }


    @Override
    public String toString() {
        return "MergeField [id=" + id + ", tag=" + tag + ", name=" + name + ", type=" + type + ", isRequired="
                + isRequired + ", default_value=" + default_value + ", isPublic=" + isPublic + ", listId=" + listId
                + ", mergeFieldOptions=" + mergeFieldOptions + "]";
    }

}
