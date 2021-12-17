package com.jtorregrosa.meteoasv.mappers;

import com.jtorregrosa.meteoasv.aemet.envelopes.prediction.DailyForecastResponse;
import com.jtorregrosa.meteoasv.aemet.envelopes.prediction.ValueTimeSlotResponse;
import com.jtorregrosa.meteoasv.domain.TemperatureUnit;
import com.jtorregrosa.meteoasv.domain.WeatherForecast;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The interface Aemet specific forecast mapper.
 */
@Mapper(componentModel = "spring")
public interface AemetSpecificForecastMapper {

    /**
     * To domain weather forecast.
     *
     * @param dailyForecastResponse the daily forecast response
     * @param unit                  the unit
     * @return the weather forecast
     */
    default WeatherForecast toDomain(DailyForecastResponse dailyForecastResponse, TemperatureUnit unit) {
        double temperatureAverage = dailyForecastResponse
            .getTemperature()
            .getData()
            .stream()
            .mapToInt(ValueTimeSlotResponse::getValue)
            .average()
            .orElse(0d);

        if (unit == TemperatureUnit.G_FAH) {
            temperatureAverage = (9d / 5d) * temperatureAverage + 32;
        }

        List<WeatherForecast.PrecipitationProbability> precipitationProbabilities = dailyForecastResponse
            .getPrecipitationProbability()
            .stream()
            .map(valuePeriodResponse -> new WeatherForecast.PrecipitationProbability(
                Integer.parseInt(valuePeriodResponse.getValue()),
                valuePeriodResponse.getPeriod()))
            .collect(Collectors.toList());

        WeatherForecast forecast = new WeatherForecast();
        forecast.setTemperatureAverage(temperatureAverage);
        forecast.setTemperatureUnit(unit.toString());
        forecast.setPrecipitationProbabilities(precipitationProbabilities);

        return forecast;
    }
}
