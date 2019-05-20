package com.faveeo.mailchimp.reports;

public class LinkPerListKey {
    private String url;
    private String listID;

    public LinkPerListKey(final String url, final String listID) {
        this.url = url;
        this.listID = listID;
    }

    public String getKey() {
        return listID + "-" + url;
    }
}
