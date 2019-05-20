package com.faveeo.mailchimp.reports;

import java.util.Objects;

public class MailchimpClickDetail {
    public String url;
    public int total_clicks;
    public int click_percentage;
    public int unique_clicks;
    public int unique_click_percentage;
    public String listID;
    public String campaignName;

    public MailchimpClickDetail() {
        total_clicks = 0;
        click_percentage = 0;
        unique_clicks = 0;
        unique_click_percentage = 0;
        url = "";
    }

    public void increase(final MailchimpClickDetail mailchimpClickDetail) {
        this.total_clicks += mailchimpClickDetail.total_clicks;
        this.click_percentage += mailchimpClickDetail.click_percentage;
        this.unique_clicks += mailchimpClickDetail.unique_clicks;
        this.unique_click_percentage += mailchimpClickDetail.unique_click_percentage;
    }

    public boolean hasSameListId(final String listeID) {
        return Objects.equals(listID, listeID);
    }
}
