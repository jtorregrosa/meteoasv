package com.jtorregrosa.meteoasv.aemet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtorregrosa.meteoasv.aemet.envelopes.master.MunicipalityResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The partial client about Master operations.
 */
public class MasterClient extends BaseClient {
    private static final String MUNICIPALITY_REQUEST_URI = "/municipios";

    /**
     * Instantiates a new MasterClient.
     *
     * @param baseUrl    the base url.
     * @param httpClient the http client.
     * @param mapper     the mapper.
     */
    MasterClient(@NotNull String baseUrl, @NotNull OkHttpClient httpClient, @NotNull ObjectMapper mapper) {
        super(baseUrl, httpClient, mapper);
    }

    /**
     * Retrieve a collection of all available municipalities.
     *
     * @return a collection of all available municipalities
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    @NotNull
    public List<MunicipalityResponse> getMunicipalityList() throws IOException, HttpAemetException {
        Request request = this.createGetRequest(this.getBaseUrl() + MUNICIPALITY_REQUEST_URI);
        MunicipalityResponse[] response = this.executeRequest(request, MunicipalityResponse[].class);

        return Arrays.asList(response);
    }
}