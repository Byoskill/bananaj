package com.faveeo.mailchimp.templates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailchimpTemplateDetails {
    public Integer id;
    public String type;
    public String name;
    public Boolean drag_and_drop;
    public Boolean responsive;
    public String category;
    public String date_created;
    public String date_edited;
    public String created_by;
    public Boolean active;
    public String folder_id;
    public String thumbnail;
    public String share_url;


    @Override
    public String toString() {
        return "MailchimpTemplateDetails{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", drag_and_drop=" + drag_and_drop +
                ", responsive=" + responsive +
                ", category='" + category + '\'' +
                ", date_created='" + date_created + '\'' +
                ", date_edited='" + date_edited + '\'' +
                ", created_by='" + created_by + '\'' +
                ", active=" + active +
                ", folder_id='" + folder_id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", share_url='" + share_url + '\'' +
                '}';
    }
}
