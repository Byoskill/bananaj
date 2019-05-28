package com.faveeo.mailchimp.reports;

import com.faveeo.mailchimp.templates.MailchimpTemplateClient;
import com.github.alexanderwe.bananaj.connection.MailChimpConnection;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;


public class MailchimpConfiguration {

    public static final String URL = "https://us13.api.mailchimp.com/3.0/";
    private static final Logger log = LoggerFactory.getLogger(MailchimpConfiguration.class);
    private String key;

    public MailchimpConfiguration() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * New mailchimp connection mail chimp connection.
     *
     * @return the mail chimp connection
     */
    public MailChimpConnection newMailchimpConnection() {
        return new MailChimpConnection(key);
    }

    /**
     * New client to read the templates.
     *
     * @return the mailchimp service
     */
    public MailchimpReportClient newReportClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (log.isDebugEnabled()) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(getKey()))
                .addInterceptor(interceptor)
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(MailchimpReportClient.class);
    }


    /**
     * Creation of a mailchimp template lcient.
     *
     * @return the mailchimp service
     */
    public MailchimpTemplateClient newTemplateClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (log.isDebugEnabled()) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(getKey()))
                .addInterceptor(interceptor)
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(MailchimpTemplateClient.class);
    }

}
