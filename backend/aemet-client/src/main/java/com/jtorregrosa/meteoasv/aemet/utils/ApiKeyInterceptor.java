package com.jtorregrosa.meteoasv.aemet.utils;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * An HTTP interceptor used to populate all outgoing requests with an api key.
 */
public class ApiKeyInterceptor implements Interceptor {
    private static final String API_KEY_PARAMETER_NAME = "api_key";

    /**
     * The api key used in all authenticated requests.
     */
    private final String apiKey;

    /**
     * Instantiates a new ApiKeyInterceptor.
     *
     * @param apiKey the api key.
     */
    public ApiKeyInterceptor(@NotNull String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Intercept the outgoing HTTP requests and customize them.
     *
     * @param chain the HTTP chain.
     * @return the HTTP response.
     * @throws IOException if there were a problem with the request.
     */
    @NotNull
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY_PARAMETER_NAME, this.apiKey)
                .build();

        Request.Builder requestBuilder = original
                .newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}