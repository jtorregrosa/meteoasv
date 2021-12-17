package com.jtorregrosa.meteoasv.repository;

import com.jtorregrosa.meteoasv.aemet.AemetClient;
import com.jtorregrosa.meteoasv.aemet.envelopes.prediction.DailyForecastResponse;
import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.domain.Municipality;
import com.jtorregrosa.meteoasv.domain.TemperatureUnit;
import com.jtorregrosa.meteoasv.domain.WeatherForecast;
import com.jtorregrosa.meteoasv.mappers.AemetMunicipalityMapper;
import com.jtorregrosa.meteoasv.mappers.AemetSpecificForecastMapper;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Aemet repository.
 */
@Component
public class AemetRepository {

    private final AemetClient aemetClient;
    private final AemetMunicipalityMapper aemetMunicipalityMapper;
    private final AemetSpecificForecastMapper aemetSpecificForecastMapper;

    /**
     * Instantiates a new Aemet repository.
     *
     * @param aemetClient                 the aemet client
     * @param aemetMunicipalityMapper     the aemet municipality mapper
     * @param aemetSpecificForecastMapper the aemet specific forecast mapper
     */
    public AemetRepository(AemetClient aemetClient, AemetMunicipalityMapper aemetMunicipalityMapper, AemetSpecificForecastMapper aemetSpecificForecastMapper) {
        this.aemetClient = aemetClient;
        this.aemetMunicipalityMapper = aemetMunicipalityMapper;
        this.aemetSpecificForecastMapper = aemetSpecificForecastMapper;
    }

    /**
     * Filter municipalities by name.
     *
     * @param name the name
     * @return the list
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    public List<Municipality> filterMunicipalitiesByName(@Nullable String name) throws IOException, HttpAemetException {
        return this.aemetMunicipalityMapper
            .toDomain(this.aemetClient.masterClient().getMunicipalityList())
            .stream()
            .filter(municipality -> name == null || municipality.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }

    /**
     * Gets weather forecast.
     *
     * @param municipalityCode the municipality code
     * @param temperatureUnit  the temperature unit
     * @return the weather forecast
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    public WeatherForecast getWeatherForecast(String municipalityCode, TemperatureUnit temperatureUnit) throws IOException, HttpAemetException {
        DailyForecastResponse response = this.aemetClient
            .specificPredictionClient()
            .getDailyPrediction(municipalityCode)
            .stream()
            .findFirst()
            .map(specificDailyPredictionResponse -> specificDailyPredictionResponse.getForecast().getDailyForecasts())
            .map(dailyForecastResponses -> dailyForecastResponses.get(1))
            .orElse(null);

        return response == null ? null : this.aemetSpecificForecastMapper.toDomain(response, temperatureUnit);
    }
}
