package com.faveeo.mailchimp.templates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailchimpTemplate {
    public Long id;
    public String type;
    public String name;
    public Boolean drag_and_drop;
    public Boolean responsive;
    public String category;
    public DateTime date_created;
    public DateTime date_edited;
    public String created_by;
    public String edited_by;
    public Boolean active;
    public String thumbnail;

    @Override
    public String toString() {
        return "MailchimpTemplate{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", name='" + name + '\'' +
            ", drag_and_drop=" + drag_and_drop +
            ", responsive=" + responsive +
            ", category='" + category + '\'' +
            ", date_created=" + date_created +
            ", date_edited=" + date_edited +
            ", created_by='" + created_by + '\'' +
            ", edited_by='" + edited_by + '\'' +
            ", active=" + active +
            ", thumbnail='" + thumbnail + '\'' +
            '}';
    }
}
