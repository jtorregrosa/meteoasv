package com.jtorregrosa.meteoasv.web.rest.controllers.vm;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherForecast {
    @JsonProperty("temperatureAverage")
    private double temperatureAverage;
    @JsonProperty("temperatureUnit")
    private String temperatureUnit;
    @JsonProperty("precipitationProbabilities")
    private List<PrecipitationProbability> precipitationProbabilities;

    @JsonProperty("temperatureAverage")
    public double getTemperatureAverage() {
        return temperatureAverage;
    }

    @JsonProperty("temperatureAverage")
    public void setTemperatureAverage(double temperatureAverage) {
        this.temperatureAverage = temperatureAverage;
    }

    @JsonProperty("temperatureUnit")
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    @JsonProperty("temperatureUnit")
    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    @JsonProperty("precipitationProbabilities")
    public List<PrecipitationProbability> getPrecipitationProbabilities() {
        return precipitationProbabilities;
    }

    @JsonProperty("precipitationProbabilities")
    public void setPrecipitationProbabilities(List<PrecipitationProbability> precipitationProbabilities) {
        this.precipitationProbabilities = precipitationProbabilities;
    }

    public static class PrecipitationProbability {
        @JsonProperty("probability")
        private int probability;

        @JsonProperty("period")
        private String period;

        public PrecipitationProbability(int probability, String period) {
            this.probability = probability;
            this.period = period;
        }

        @JsonProperty("probability")
        public int getProbability() {
            return probability;
        }

        @JsonProperty("probability")
        public void setProbability(int probability) {
            this.probability = probability;
        }

        @JsonProperty("period")
        public String getPeriod() {
            return period;
        }

        @JsonProperty("period")
        public void setPeriod(String period) {
            this.period = period;
        }
    }
}
