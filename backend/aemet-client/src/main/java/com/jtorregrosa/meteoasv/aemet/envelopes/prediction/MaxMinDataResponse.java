package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaxMinDataResponse {

    @JsonProperty("maxima")
    private Integer maximum;
    @JsonProperty("minima")
    private Integer minimum;
    @JsonProperty("dato")
    private List<ValueTimeSlotResponse> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxima")
    public Integer getMaximum() {
        return maximum;
    }

    @JsonProperty("maxima")
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @JsonProperty("minima")
    public Integer getMinimum() {
        return minimum;
    }

    @JsonProperty("minima")
    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("dato")
    public List<ValueTimeSlotResponse> getData() {
        return data;
    }

    @JsonProperty("dato")
    public void setData(List<ValueTimeSlotResponse> data) {
        this.data = data;
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
