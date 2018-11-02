package com.github.alexanderwe.bananaj.utils;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

// TODO: Auto-generated Javadoc
/**
 * Validator for E-Mail addresses. Replacement for deprecated apache commons EmailValidator.
 * Created by alexanderweiss on 27.12.16.
 */
public class DateConverter {

    /** The instance. */
    private static DateConverter instance = null;

    /**
     * Instantiates a new date converter.
     */
    protected DateConverter () {

    }

    /**
     * Gets the single instance of DateConverter.
     *
     * @return single instance of DateConverter
     */
    public static DateConverter getInstance(){
        if(instance == null){
            instance = new DateConverter();
        }
        return instance;
    }

    /**
     * Convert a date formatted in IS8601 to a normal java date.
     *
     * @param dateString the date string
     * @return Date
     */
    public LocalDateTime createDateFromISO8601(String dateString){
        ZonedDateTime zdt = ZonedDateTime.parse(dateString);
        return zdt.toLocalDateTime();
    }

    /**
     * Creates the date from normal.
     *
     * @param dateString the date string
     * @return the local date time
     */
    /* Convert a date formatted in IS8601 to a normal java date
     * @param dateString
     * @return Date
     */
    public LocalDateTime createDateFromNormal(String dateString) {
        String formatIn = "yyyy-MM-dd HH:mm:ss";
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(formatIn));
    }
}
