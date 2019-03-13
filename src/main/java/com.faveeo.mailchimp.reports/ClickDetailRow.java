package com.faveeo.mailchimp.reports;

public class ClickDetailRow {
    private final String url;
    private final String list_id;
    private final int total_clicks;

    public ClickDetailRow(final String url, String listId, final int total_clicks) {
        this.url = url;
        this.list_id = listId;
        this.total_clicks = total_clicks;
    }

    public String getUrl() { return url; }
    public String getList_id() { return list_id; }
    public int getTotal_clicks() { return total_clicks; }

    @Override
    public String toString() {
        return "ClickDetailRow{" +
                "url='" + url + '\'' +
                ", list_id='" + list_id + '\'' +
                ", total_clicks=" + total_clicks +
                '}';
    }
}
