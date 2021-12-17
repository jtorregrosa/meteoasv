package com.jtorregrosa.meteoasv.aemet;

import com.jtorregrosa.meteoasv.aemet.envelopes.prediction.SpecificDailyPredictionResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.aemet.utils.TestUtils;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SpecificPredictionClientTest {

    private MockWebServer mockWebServer;

    private SpecificPredictionClient specificPredictionClient;

    @BeforeEach
    void setUp() throws IOException {
        PartialClientFactory partialClientFactory = Mockito.spy(new PartialClientFactory(""));
        AemetClient aemetClient = new AemetClient(partialClientFactory);

        this.mockWebServer = new MockWebServer();
        this.mockWebServer.start(); //initialise mock web server

        String baseUrl = mockWebServer.url("").toString();
        this.specificPredictionClient = new PartialClientFactory("").createSpecificPredictionClient(baseUrl);
    }

    @AfterEach
    void tearDown() throws IOException {
        this.mockWebServer.shutdown();
    }

    @Test
    void ShouldGetValidDataWithValidParameters() throws IOException, HttpAemetException {
        // Given
        String dailySpecificPredictionResponse = TestUtils.getResourceFileAsString("dailyspecificprediction-response.json");
        String dailySpecificPredictionResolutionResponse = TestUtils.getResourceFileAsString("dailyspecificpredictionresolution-response.json");
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResponse));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResolutionResponse));

        // When
        List<SpecificDailyPredictionResponse> predictions = this.specificPredictionClient.getDailyPrediction("1234", url -> mockWebServer.url("").toString());

        // Then
        Assertions.assertEquals(1, predictions.size());
    }

    @Test
    void ShouldExceptionBeThrownWhenRemoteApiDown() throws IOException, HttpAemetException {
        // Given
        String dailySpecificPredictionResponse = TestUtils.getResourceFileAsString("dailyspecificprediction-response.json");
        String dailySpecificPredictionResolutionResponse = TestUtils.getResourceFileAsString("dailyspecificpredictionresolution-response.json");
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResponse));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResolutionResponse));

        // When
        Executable exec = () -> {
            this.specificPredictionClient.getDailyPrediction("1234", url -> "http://www.475A2FDA9F6E8EBC0161A5CBF75F967DF353F8242810AE326F0707CDDBF9DEAE.com");
        };

        // Then
        assertThrows(IllegalArgumentException.class, exec);
    }

    @Test
    void ShouldExceptionBeThrownWhenRemoteApiManagedErrors() throws IOException, HttpAemetException {
        // Given
        String dailySpecificPredictionResponse = TestUtils.getResourceFileAsString("error-response.json");
        String dailySpecificPredictionResolutionResponse = TestUtils.getResourceFileAsString("dailyspecificpredictionresolution-response.json");
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResponse));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResolutionResponse));

        // When
        Executable exec = () -> {
            this.specificPredictionClient.getDailyPrediction("1234");
        };

        // Then
        assertThrows(HttpAemetException.class, exec);
    }

    @Test
    void ShouldExceptionBeThrownWhenRemoteApiInternalErrors() throws IOException, HttpAemetException {
        // Given
        mockWebServer.enqueue(new MockResponse().setResponseCode(500));
        mockWebServer.enqueue(new MockResponse().setResponseCode(500));

        // When
        Executable exec = () -> {
            this.specificPredictionClient.getDailyPrediction("1234");
        };

        // Then
        assertThrows(IllegalStateException.class, exec);
    }

    @Test
    void ShouldExceptionBeThrownWhenMalformedRemoteResponse() throws IOException, HttpAemetException {
        // Given
        String dailySpecificPredictionResponse = TestUtils.getResourceFileAsString("malformed-data.json");
        String dailySpecificPredictionResolutionResponse = TestUtils.getResourceFileAsString("dailyspecificpredictionresolution-response.json");
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResponse));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(dailySpecificPredictionResolutionResponse));

        // When
        Executable exec = () -> {
            this.specificPredictionClient.getDailyPrediction("1234", url -> mockWebServer.url("").toString());
        };

        // Then
        assertThrows(InvalidObjectException.class, exec);
    }
}
