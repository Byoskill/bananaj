package com.faveeo.mailchimp.templates;

import com.fasterxml.jackson.databind.JsonNode;
import retrofit2.Call;
import retrofit2.http.*;


public interface MailchimpTemplateClient {
    @GET("templates")
    Call<JsonNode> getTemplates(
            @Query("count") Integer count,
            @Query("offset") final int offset);

    @GET("templates/{id}")
    Call<JsonNode> getTemplate(@Path("id") Integer templateId);


    @GET("templates/{id}/default-content")
    Call<JsonNode> getTemplateDefaultContent(@Path("id") Integer templateId);

    @POST("templates")
    Call<JsonNode> createTemplate(@Query("name") String name,
                                  @Query("folder_id") String folderId,
                                  @Query("html") String html);

    @PATCH("templates/{id}")
    Call<JsonNode> editTemplate(@Path("id") String templateId,
                                @Query("name") String name,
                                @Query("folder_id") String folderId,
                                @Query("html") String html);

    @DELETE("templates/{id}")
    Call<JsonNode> deleteTemplate(@Path("id") String templateId);


}
