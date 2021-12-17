package com.jtorregrosa.meteoasv.aemet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtorregrosa.meteoasv.aemet.envelopes.generic.HateoasResponse;
import com.jtorregrosa.meteoasv.aemet.envelopes.prediction.SpecificDailyPredictionResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.aemet.utils.HttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The partial client about SpecificPrediction operations.
 */
public class SpecificPredictionClient extends BaseClient {
    private static final String MUNICIPALITY_DAILY_REQUEST_URI = "/municipio/diaria";

    /**
     * Instantiates a new SpecificPredictionClient.
     *
     * @param baseUrl    the base url.
     * @param httpClient the http client.
     * @param mapper     the mapper.
     */
    SpecificPredictionClient(@NotNull String baseUrl, @NotNull OkHttpClient httpClient, @NotNull ObjectMapper mapper) {
        super(baseUrl, httpClient, mapper);
    }

    /**
     * Retrieve the daily prediction for provided municipality.
     *
     * @param municipalityCode the municipality code.
     * @return a collection of all daily predictions.
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    @NotNull
    public List<SpecificDailyPredictionResponse> getDailyPrediction(@NotNull String municipalityCode) throws IOException, HttpAemetException {
        return this.getDailyPrediction(municipalityCode, url -> url);
    }

    /**
     * Retrieve the daily prediction for provided municipality. The url preprocessor helps during url customization
     * for hateoas requests.
     *
     * @param municipalityCode       the municipality code.
     * @param hateoasUrlPreprocessor the preprocessor used in hateoas requests
     * @return
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    @NotNull
    public List<SpecificDailyPredictionResponse> getDailyPrediction(@NotNull String municipalityCode, @NotNull UrlPreprocessor hateoasUrlPreprocessor) throws IOException, HttpAemetException {
        Request hateoasRequest = this.createGetRequest(this.getBaseUrl() + MUNICIPALITY_DAILY_REQUEST_URI + "/" + municipalityCode);
        HateoasResponse hateoasResponse = this.executeRequest(hateoasRequest, HateoasResponse.class);

        int statusCode = hateoasResponse.getStatus();
        if (!HttpUtils.isStatusCodeSuccessful(statusCode)) {
            throw new HttpAemetException(statusCode, "The request was not successful");
        }

        String targetUrl = hateoasUrlPreprocessor.processUrl(hateoasResponse.getData());
        Request request = this.createGetRequest(targetUrl);
        SpecificDailyPredictionResponse[] response = this.executeRequest(request, SpecificDailyPredictionResponse[].class);

        return Arrays.asList(response);
    }

    public interface UrlPreprocessor {
        String processUrl(String url);
    }
}
