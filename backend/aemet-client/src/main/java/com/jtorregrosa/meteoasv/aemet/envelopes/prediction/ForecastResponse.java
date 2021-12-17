package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForecastResponse {

    @JsonProperty("dia")
    private List<DailyForecastResponse> dailyForecasts = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dia")
    public List<DailyForecastResponse> getDailyForecasts() {
        return dailyForecasts;
    }

    @JsonProperty("dia")
    public void setDailyForecasts(List<DailyForecastResponse> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
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
