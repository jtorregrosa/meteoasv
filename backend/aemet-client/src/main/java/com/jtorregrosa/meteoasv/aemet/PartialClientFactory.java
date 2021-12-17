package com.jtorregrosa.meteoasv.aemet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtorregrosa.meteoasv.aemet.utils.ApiKeyInterceptor;
import com.jtorregrosa.meteoasv.aemet.utils.DefaultHeadersInterceptor;
import com.jtorregrosa.meteoasv.aemet.utils.TrustAllX509TrustManager;
import okhttp3.OkHttpClient;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

class PartialClientFactory {
    /**
     * The API key.
     */
    private final String apiKey;

    /**
     * Instantiates a new Aemet client.
     *
     * @param apiKey the api key
     */
    public PartialClientFactory(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Create a Master partial client.
     *
     * @return a Master partial client
     */
    public MasterClient createMasterClient(String baseUrl) {
        return new MasterClient(baseUrl, this.createHttpClient(), new ObjectMapper());
    }

    /**
     * Create a SpecificPrediction partial client.
     *
     * @return a SpecificPrediction partial client
     */
    public SpecificPredictionClient createSpecificPredictionClient(String baseUrl) {
        return new SpecificPredictionClient(baseUrl, this.createHttpClient(), new ObjectMapper());
    }

    /**
     * Create a new HttpClient populated with defaults.
     *
     * @return a new configured HttpClient.
     */
    OkHttpClient createHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(new ApiKeyInterceptor(this.apiKey));
        httpClientBuilder.addInterceptor(new DefaultHeadersInterceptor());
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);

        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLSv1.2");
            TrustManager[] trustAllCerts = new TrustManager[]{new TrustAllX509TrustManager()};
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            httpClientBuilder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0]);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

        return httpClientBuilder.build();
    }
}
