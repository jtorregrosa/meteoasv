package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailyForecastResponse {

    @JsonProperty("probPrecipitacion")
    private List<ValuePeriodResponse> precipitationProbability = null;

    @JsonProperty("cotaNieveProv")
    private List<ValuePeriodResponse> snowLevels = null;

    @JsonProperty("estadoCielo")
    private List<ValuePeriodResponse> skyState = null;

    @JsonProperty("viento")
    private List<WindResponse> wind = null;

    @JsonProperty("rachaMax")
    private List<ValuePeriodResponse> maxWindGust = null;

    @JsonProperty("temperatura")
    private MaxMinDataResponse temperature;

    @JsonProperty("sensTermica")
    private MaxMinDataResponse windChill;

    @JsonProperty("humedadRelativa")
    private MaxMinDataResponse relativeHumidity;

    @JsonProperty("uvMax")
    private Integer uvMax;

    @JsonProperty("fecha")
    private String date;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("probPrecipitacion")
    public List<ValuePeriodResponse> getPrecipitationProbability() {
        return precipitationProbability;
    }

    @JsonProperty("probPrecipitacion")
    public void setPrecipitationProbability(List<ValuePeriodResponse> precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    @JsonProperty("cotaNieveProv")
    public List<ValuePeriodResponse> getSnowLevels() {
        return snowLevels;
    }

    @JsonProperty("cotaNieveProv")
    public void setSnowLevels(List<ValuePeriodResponse> snowLevels) {
        this.snowLevels = snowLevels;
    }

    @JsonProperty("estadoCielo")
    public List<ValuePeriodResponse> getSkyState() {
        return skyState;
    }

    @JsonProperty("estadoCielo")
    public void setSkyState(List<ValuePeriodResponse> skyState) {
        this.skyState = skyState;
    }

    @JsonProperty("viento")
    public List<WindResponse> getWind() {
        return wind;
    }

    @JsonProperty("viento")
    public void setWind(List<WindResponse> wind) {
        this.wind = wind;
    }

    @JsonProperty("rachaMax")
    public List<ValuePeriodResponse> getMaxWindGust() {
        return maxWindGust;
    }

    @JsonProperty("rachaMax")
    public void setMaxWindGust(List<ValuePeriodResponse> maxWindGust) {
        this.maxWindGust = maxWindGust;
    }

    @JsonProperty("temperatura")
    public MaxMinDataResponse getTemperature() {
        return temperature;
    }

    @JsonProperty("temperatura")
    public void setTemperature(MaxMinDataResponse temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("sensTermica")
    public MaxMinDataResponse getWindChill() {
        return windChill;
    }

    @JsonProperty("sensTermica")
    public void setWindChill(MaxMinDataResponse windChill) {
        this.windChill = windChill;
    }

    @JsonProperty("humedadRelativa")
    public MaxMinDataResponse getRelativeHumidity() {
        return relativeHumidity;
    }

    @JsonProperty("humedadRelativa")
    public void setRelativeHumidity(MaxMinDataResponse relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonProperty("uvMax")
    public Integer getUvMax() {
        return uvMax;
    }

    @JsonProperty("uvMax")
    public void setUvMax(Integer uvMax) {
        this.uvMax = uvMax;
    }

    @JsonProperty("fecha")
    public String getDate() {
        return date;
    }

    @JsonProperty("fecha")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
