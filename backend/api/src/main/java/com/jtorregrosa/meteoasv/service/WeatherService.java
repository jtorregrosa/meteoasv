package com.jtorregrosa.meteoasv.service;

import com.jtorregrosa.meteoasv.aemet.exception.HttpAemetException;
import com.jtorregrosa.meteoasv.domain.Municipality;
import com.jtorregrosa.meteoasv.domain.TemperatureUnit;
import com.jtorregrosa.meteoasv.domain.WeatherForecast;
import com.jtorregrosa.meteoasv.repository.AemetRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * The type Weather service.
 */
@Service
public class WeatherService {
    private final AemetRepository repository;

    /**
     * Instantiates a new Weather service.
     *
     * @param repository the repository
     */
    public WeatherService(AemetRepository repository) {
        this.repository = repository;
    }

    /**
     * Filter municipalities by name list.
     *
     * @param name the name
     * @return the list
     * @throws IOException        if there is a problem during the deserialization process
     * @throws HttpAemetException if the response was successfully parsed but indicates an error.
     */
    public List<Municipality> filterMunicipalitiesByName(String name) throws IOException, HttpAemetException {
        return this.repository.filterMunicipalitiesByName(name);
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
        return this.repository.getWeatherForecast(municipalityCode, temperatureUnit);
    }
}
