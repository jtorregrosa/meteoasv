package com.jtorregrosa.meteoasv.aemet.envelopes.prediction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataSourceResponse {

    @JsonProperty("productor")
    private String producer;

    @JsonProperty("web")
    private String web;

    @JsonProperty("enlace")
    private String link;

    @JsonProperty("language")
    private String language;

    @JsonProperty("copyright")
    private String copyright;

    @JsonProperty("notaLegal")
    private String legalConditions;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("productor")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("productor")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonProperty("web")
    public String getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(String web) {
        this.web = web;
    }

    @JsonProperty("enlace")
    public String getLink() {
        return link;
    }

    @JsonProperty("enlace")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("notaLegal")
    public String getLegalConditions() {
        return legalConditions;
    }

    @JsonProperty("notaLegal")
    public void setLegalConditions(String legalConditions) {
        this.legalConditions = legalConditions;
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
