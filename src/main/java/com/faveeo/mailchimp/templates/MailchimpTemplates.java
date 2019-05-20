package com.faveeo.mailchimp.templates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailchimpTemplates {

    public List<MailchimpTemplate> templates = new ArrayList<>();


    @Override
    public String toString() {
        return "MailchimpTemplates{" +
                "templates=" + templates +
                '}';
    }
}
