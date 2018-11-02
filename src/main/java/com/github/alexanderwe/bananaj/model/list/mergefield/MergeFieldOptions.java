package com.github.alexanderwe.bananaj.model.list.mergefield;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 *  Class for representing merge field options.
 * Created by Alexander on 09.08.2016.
 */
public class MergeFieldOptions {

    /** The default country. */
    private int default_country;
    
    /** The phone format. */
    private String phone_format;
    
    /** The date format. */
    private String date_format;
    
    /** The choices. */
    private List<String> choices;
    
    /** The size. */
    private int size;

    /**
     * Default constructor.
     */
    public MergeFieldOptions(){
    }

    /**
     * Instantiates a new merge field options.
     *
     * @param default_country the default country
     * @param phone_format the phone format
     * @param date_format the date format
     * @param choices the choices
     * @param size the size
     */
    public MergeFieldOptions(int default_country, String phone_format, String date_format, ArrayList<String> choices, int size){
        this.default_country = default_country;
        this.phone_format = phone_format;
        this.date_format = date_format;
        this.choices = choices;
        this.size = size;
    }

    /**
     * Gets the default country.
     *
     * @return the default country
     */
    public int getDefault_country() {
        return default_country;
    }

    /**
     * Gets the phone format.
     *
     * @return the phone format
     */
    public String getPhone_format() {
        return phone_format;
    }

    /**
     * Gets the date format.
     *
     * @return the date format
     */
    public String getDate_format() {
        return date_format;
    }

    /**
     * Gets the choices.
     *
     * @return the choices
     */
    public List<String> getChoices() {
        return choices;
    }

    /**
     * Gets the size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the phone format.
     *
     * @param phone_format the new phone format
     */
    public void setPhone_format(String phone_format) {
        this.phone_format = phone_format;
    }

    /**
     * Sets the date format.
     *
     * @param date_format the new date format
     */
    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    /**
     * Sets the choices.
     *
     * @param choices the new choices
     */
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    /**
     * Sets the size.
     *
     * @param size the new size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        return "Default_Country: " + this.default_country + System.lineSeparator() +
                "Phone_Format: " + this.phone_format + System.lineSeparator() +
                "Date_Format: " + this.date_format + System.lineSeparator() +
                "Choices: " + this.choices + System.lineSeparator() +
                "Size: " + this.size;
    }

    /**
     * Sets the default country.
     *
     * @param default_country the new default country
     */
    public void setDefault_country(int default_country) {
        this.default_country = default_country;
    }
}
