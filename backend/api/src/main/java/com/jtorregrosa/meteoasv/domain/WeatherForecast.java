package com.jtorregrosa.meteoasv.domain;

import java.util.List;

/**
 * The type Weather forecast.
 */
public class WeatherForecast {
    private double temperatureAverage;
    private String temperatureUnit;
    private List<PrecipitationProbability> precipitationProbabilities;

    /**
     * Gets temperature average.
     *
     * @return the temperature average
     */
    public double getTemperatureAverage() {
        return temperatureAverage;
    }

    /**
     * Sets temperature average.
     *
     * @param temperatureAverage the temperature average
     */
    public void setTemperatureAverage(double temperatureAverage) {
        this.temperatureAverage = temperatureAverage;
    }

    /**
     * Gets temperature unit.
     *
     * @return the temperature unit
     */
    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    /**
     * Sets temperature unit.
     *
     * @param temperatureUnit the temperature unit
     */
    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    /**
     * Gets precipitation probabilities.
     *
     * @return the precipitation probabilities
     */
    public List<PrecipitationProbability> getPrecipitationProbabilities() {
        return precipitationProbabilities;
    }

    /**
     * Sets precipitation probabilities.
     *
     * @param precipitationProbabilities the precipitation probabilities
     */
    public void setPrecipitationProbabilities(List<PrecipitationProbability> precipitationProbabilities) {
        this.precipitationProbabilities = precipitationProbabilities;
    }

    /**
     * The type Precipitation probability.
     */
    public static class PrecipitationProbability {
        private int probability;
        private String period;

        /**
         * Instantiates a new Precipitation probability.
         *
         * @param probability the probability
         * @param period      the period
         */
        public PrecipitationProbability(int probability, String period) {
            this.probability = probability;
            this.period = period;
        }

        /**
         * Gets probability.
         *
         * @return the probability
         */
        public int getProbability() {
            return probability;
        }

        /**
         * Sets probability.
         *
         * @param probability the probability
         */
        public void setProbability(int probability) {
            this.probability = probability;
        }

        /**
         * Gets period.
         *
         * @return the period
         */
        public String getPeriod() {
            return period;
        }

        /**
         * Sets period.
         *
         * @param period the period
         */
        public void setPeriod(String period) {
            this.period = period;
        }
    }
}
