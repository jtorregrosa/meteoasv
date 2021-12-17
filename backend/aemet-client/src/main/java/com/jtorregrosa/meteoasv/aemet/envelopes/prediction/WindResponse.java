package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class WindResponse {

    @JsonProperty("direccion")
    private String direction;
    @JsonProperty("velocidad")
    private Integer speed;
    @JsonProperty("periodo")
    private String period;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("direccion")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direccion")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("velocidad")
    public Integer getSpeed() {
        return speed;
    }

    @JsonProperty("velocidad")
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @JsonProperty("periodo")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("periodo")
    public void setPeriod(String period) {
        this.period = period;
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
