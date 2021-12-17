package com.jtorregrosa.meteoasv.aemet;

/**
 * The Aemet client encapsulates all derived API clients and provided unified access to all of them.
 */
public class AemetClient {
    private static final String BASE_URL = "https://opendata.aemet.es/opendata/api";
    private static final String MASTER_BASE_URL = BASE_URL + "/maestro";
    private static final String SPECIFIC_PREDICTION_BASE_URL = BASE_URL + "/prediccion/especifica";

    private final PartialClientFactory partialClientFactory;

    /**
     * Instantiates a new Aemet client.
     *
     * @param apiKey the api key
     */
    public AemetClient(String apiKey) {
        this.partialClientFactory = new PartialClientFactory(apiKey);
    }

    /**
     * Instantiates a new Aemet client.
     *
     * @param partialClientFactory the partial client factory.
     */
    AemetClient(PartialClientFactory partialClientFactory) {
        this.partialClientFactory = partialClientFactory;
    }

    /**
     * Create a Master partial client.
     *
     * @return a Master partial client
     */
    public MasterClient masterClient() {
        return this.partialClientFactory.createMasterClient(MASTER_BASE_URL);
    }

    /**
     * Create a SpecificPrediction partial client.
     *
     * @return a SpecificPrediction partial client
     */
    public SpecificPredictionClient specificPredictionClient() {
        return this.partialClientFactory.createSpecificPredictionClient(SPECIFIC_PREDICTION_BASE_URL);
    }
}
