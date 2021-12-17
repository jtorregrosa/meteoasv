package com.jtorregrosa.meteoasv.aemet.utils;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * An HTTP interceptor used to populate all outgoing requests with default headers.
 */
public class DefaultHeadersInterceptor implements Interceptor {

    /**
     * Intercept the outgoing HTTP requests and customize them.
     *
     * @param chain the HTTP chain.
     * @return the HTTP response.
     * @throws IOException if there were a problem with the request.
     */
    @NotNull
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        Request requestWithDefaultHeaders = originalRequest
                .newBuilder()
                .header("Accept", "application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Cache-Control", "no-cache")
                .header("User-Agent", "java-aemetclient")
                .build();

        return chain.proceed(requestWithDefaultHeaders);
    }
}