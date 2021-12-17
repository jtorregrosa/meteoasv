package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValuePeriodResponse {

    @JsonProperty("value")
    private String value;

    @JsonProperty("periodo")
    private String period;

    @JsonProperty("descripcion")
    private String description;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("periodo")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("periodo")
    public void setPeriod(String period) {
        this.period = period;
    }

    @JsonProperty("descripcion")
    public String getDescription() {
        return description;
    }

    @JsonProperty("descripcion")
    public void setDescription(String description) {
        this.description = description;
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
