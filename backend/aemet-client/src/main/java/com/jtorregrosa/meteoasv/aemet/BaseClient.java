package com.jtorregrosa.meteoasv.aemet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtorregrosa.meteoasv.aemet.envelopes.error.ErrorResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.concurrent.CompletableFuture;

/**
 * This class represent the base class for all derived and specialized partial clients.
 */
public abstract class BaseClient {

    /**
     * The base url used to perform remote requests.
     */
    private final String baseUrl;

    /**
     * The internal http client used to perform remote API calls.
     */
    private final OkHttpClient httpClient;

    /**
     * The internal mapper used to deserialize responses.
     */
    private final ObjectMapper mapper;

    /**
     * Instantiates a new BaseClient.
     *
     * @param baseUrl    the base url.
     * @param httpClient the http client.
     * @param mapper     the mapper.
     */
    BaseClient(@NotNull String baseUrl, @NotNull OkHttpClient httpClient, @NotNull ObjectMapper mapper) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    /**
     * Gets the base url.
     *
     * @return the base url.
     */
    @NotNull
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Create a GET request.
     *
     * @param url the target url.
     * @return the created request.
     */
    @NotNull
    protected Request createGetRequest(@NotNull String url) {
        return new Request.Builder()
                .url(url)
                .build();
    }

    /**
     * Executes a provided request and manages the deserialization process.
     *
     * @param request      the request object.
     * @param responseType the target response type.
     * @param <T>          the type of the response.
     * @return the POJO class with response data.
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    @NotNull
    protected <T> T executeRequest(@NotNull Request request, @NotNull Class<T> responseType) throws IOException, HttpAemetException {
        Call call = this.httpClient.newCall(request);

        try (Response response = call.execute();
             ResponseBody responseBody = response.body()) {

            if (!response.isSuccessful()) {
                throw new IllegalStateException("The request was not successful. StatusCode=" + response.code());
            }

            if (responseBody == null) {
                throw new InvalidObjectException("The remote response had no body");
            }

            return this.deserializeResponse(responseBody, responseType);
        }
    }

    /**
     * Executes a provided request asynchronously and manages the deserialization process.
     *
     * @param request      the request object.
     * @param responseType the target response type.
     * @param <T>          the type of the response.
     * @return a completable future with the result of the request.
     */
    @NotNull
    protected <T> CompletableFuture<T> executeRequestAsync(@NotNull Request request, @NotNull Class<T> responseType) {
        final CompletableFuture<T> future = new CompletableFuture<>();
        this.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                T responseEntity = null;

                try (ResponseBody responseBody = response.body()) {
                    if (responseBody == null) {
                        throw new InvalidObjectException("The remote response had no body");
                    }

                    responseEntity = BaseClient.this.deserializeResponse(responseBody, responseType);
                } catch (HttpAemetException e) {
                    future.completeExceptionally(e);
                } finally {
                    future.complete(responseEntity);
                }
            }
        });

        return future;
    }

    /**
     * Deserializes the response body producing a POJO class with response data.
     *
     * @param responseBody the response body.
     * @param responseType the target response type.
     * @param <T>          the type of the response.
     * @return the POJO class with response data.
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    @NotNull
    private <T> T deserializeResponse(@NotNull ResponseBody responseBody, @NotNull Class<T> responseType) throws IOException, HttpAemetException {
        String body = responseBody.string();
        try {
            return this.mapper.readValue(body, responseType);
        } catch (JsonProcessingException e) {
            try {
                ErrorResponse error = this.mapper.readValue(body, ErrorResponse.class);

                throw new HttpAemetException(error.getStatus(), "The response was not successful. StatusCode=" + error.getStatus());
            } catch (JsonProcessingException e2) {
                throw new InvalidObjectException("There was not possible to deserialize remote response");
            }
        }
    }
}
