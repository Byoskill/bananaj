package com.github.alexanderwe.bananaj.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator for E-Mail addresses. Replacement for deprecated apache commons EmailValidator.
 * Created by alexanderweiss on 27.12.16.
 */
public class EmailValidator {

    /** The instance. */
    private static EmailValidator instance = null;
    
    /** The Constant emailRegex. */
    private static final String emailRegex  = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; // RFC 5322 Internet Message Format characters allowed

    /**
     * Instantiates a new email validator.
     */
    protected EmailValidator () {

    }

    /**
     * Gets the single instance of EmailValidator.
     *
     * @return single instance of EmailValidator
     */
    public static EmailValidator getInstance(){
        if(instance == null){
            instance = new EmailValidator();
        }
        return instance;
    }

    /**
     * Validate.
     *
     * @param email the email
     * @return true, if successful
     */
    public boolean validate(String email){
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
