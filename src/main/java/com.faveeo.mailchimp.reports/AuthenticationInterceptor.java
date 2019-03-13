package com.faveeo.mailchimp.reports;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {
    @Override
    public Response intercept(final Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
            .header("Authorization", "apikey d091cb7094540ba029f5c906c851ebd7-us13");

        Request request = builder.build();
        return chain.proceed(request);
    }
}
