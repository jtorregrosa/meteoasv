package com.jtorregrosa.meteoasv.aemet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AemetClientTest {

    private AemetClient aemetClient;

    private PartialClientFactory partialClientFactory;

    @BeforeEach
    void setUp() {
        this.partialClientFactory = Mockito.spy(new PartialClientFactory(""));
        this.aemetClient = new AemetClient(this.partialClientFactory);
    }

    @Test
    void getMasterClient() {
        // Given
        String baseUrl = "https://opendata.aemet.es/opendata/api";
        String masterBaseUrl = baseUrl + "/maestro";

        // When
        MasterClient masterClient = this.aemetClient.masterClient();

        // Then
        verify(partialClientFactory, times(1)).createMasterClient(masterBaseUrl);
        Assertions.assertNotNull(masterClient);
    }

    @Test
    void getSpecificPredictionClient() {
        // Given
        String baseUrl = "https://opendata.aemet.es/opendata/api";
        String specificPredictionBaseUrl = baseUrl + "/prediccion/especifica";

        // When
        SpecificPredictionClient specificPredictionClient = this.aemetClient.specificPredictionClient();

        // Then
        verify(partialClientFactory, times(1)).createSpecificPredictionClient(specificPredictionBaseUrl);
        Assertions.assertNotNull(specificPredictionClient);
    }
}
