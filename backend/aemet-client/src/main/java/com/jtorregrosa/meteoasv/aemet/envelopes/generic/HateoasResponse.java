package com.jtorregrosa.meteoasv.aemet.envelopes.generic;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HateoasResponse {
    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("estado")
    private int status;

    @JsonProperty("datos")
    private String data;

    @JsonProperty("metadatos")
    private String metadata;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("descripcion")
    public String getDescription() {
        return description;
    }

    @JsonProperty("descripcion")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("estado")
    public int getStatus() {
        return status;
    }

    @JsonProperty("estado")
    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("datos")
    public String getData() {
        return data;
    }

    @JsonProperty("datos")
    public void setData(String data) {
        this.data = data;
    }

    @JsonProperty("metadatos")
    public String getMetadata() {
        return metadata;
    }

    @JsonProperty("metadatos")
    public void setMetadata(String metadata) {
        this.metadata = metadata;
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
