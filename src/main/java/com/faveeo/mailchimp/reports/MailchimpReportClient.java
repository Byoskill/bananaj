package com.faveeo.mailchimp.reports;

import com.fasterxml.jackson.databind.JsonNode;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MailchimpReportClient {
    @GET("/reports")
    Call<JsonNode> getReports(@Query("count") Integer count, @Query("offset") final int offset);

    @GET("/reports/{id}/click-details")
    Call<JsonNode> getClickDetailsReportCampaign(@Path("id") String reportId, @Query("count") Integer count, @Query("offset") final int offset);

    @GET("/reports/{id}/click-details/{clickId}/members")
    Call<JsonNode> getMembersPerClicksReportCampaign(@Path("id") String reportId,
                                                     @Path("clickId") String clickId,
                                                     @Query("count") Integer count,
                                                     @Query("offset") final int offset);

    
}
