package com.jtorregrosa.meteoasv.aemet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtorregrosa.meteoasv.aemet.envelopes.master.MunicipalityResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.aemet.utils.TestUtils;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MasterClientTest {

    private AemetClient aemetClient;

    private PartialClientFactory partialClientFactory;

    private MockWebServer mockWebServer;

    private URL mockServerBaseUrl;

    @BeforeEach
    void setUp() throws IOException {
        this.partialClientFactory = Mockito.spy(new PartialClientFactory(""));
        this.aemetClient = new AemetClient(this.partialClientFactory);

        this.mockWebServer = new MockWebServer();
        this.mockWebServer.start(); //initialise mock web server

        this.mockServerBaseUrl = mockWebServer.url("").url(); //get base url of mockwebserver
    }

    @AfterEach
    void tearDown() throws IOException {
        this.mockWebServer.shutdown();
    }

    @Test
    void getMunicipalities() throws IOException, HttpAemetException {
        // Given
        String municipalitiesResponse = TestUtils.getResourceFileAsString("municipalities-response.json");
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(municipalitiesResponse));
        MasterClient masterClient = new MasterClient(this.mockServerBaseUrl.toString(), new OkHttpClient.Builder().build(), new ObjectMapper());

        // When
        List<MunicipalityResponse> municipalities = masterClient.getMunicipalityList();

        // Then
        Assertions.assertEquals(8122, municipalities.size());
    }
}
