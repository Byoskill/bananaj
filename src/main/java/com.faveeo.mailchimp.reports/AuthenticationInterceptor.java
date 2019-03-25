package com.faveeo.mailchimp.reports;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private String key;

    public AuthenticationInterceptor(String key) {

        this.key = key;
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", "apikey " + key);

        Request request = builder.build();
        return chain.proceed(request);
    }
}
