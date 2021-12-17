package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecificDailyPredictionResponse {

    @JsonProperty("origen")
    private DataSourceResponse dataSource;

    @JsonProperty("elaborado")
    private String createdAt;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("provincia")
    private String province;

    @JsonProperty("prediccion")
    private ForecastResponse forecast;

    @JsonProperty("id")
    private int id;

    @JsonProperty("version")
    private Double version;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("origen")
    public DataSourceResponse getDataSource() {
        return dataSource;
    }

    @JsonProperty("origen")
    public void setDataSource(DataSourceResponse dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("elaborado")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("elaborado")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("nombre")
    public String getName() {
        return name;
    }

    @JsonProperty("nombre")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("provincia")
    public String getProvince() {
        return province;
    }

    @JsonProperty("provincia")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("prediccion")
    public ForecastResponse getForecast() {
        return forecast;
    }

    @JsonProperty("prediccion")
    public void setForecast(ForecastResponse forecast) {
        this.forecast = forecast;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("version")
    public Double getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Double version) {
        this.version = version;
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
