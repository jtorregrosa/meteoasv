package com.jtorregrosa.meteoasv.aemet.envelopes.master;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MunicipalityResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("id_old")
    private String oldId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("altitud")
    private String altitude;

    @JsonProperty("capital")
    private String capitalCity;

    @JsonProperty("num_hab")
    private String population;

    @JsonProperty("zona_comarcal")
    private String regionCode;

    @JsonProperty("destacada")
    private String highlighted;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("latitud")
    private String latitudeLong;

    @JsonProperty("longitud")
    private String longitudeLong;

    @JsonProperty("latitud_dec")
    private String latitudeShort;

    @JsonProperty("longitud_dec")
    private String longitudeShort;

    public MunicipalityResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(String highlighted) {
        this.highlighted = highlighted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitudeLong() {
        return latitudeLong;
    }

    public void setLatitudeLong(String latitudeLong) {
        this.latitudeLong = latitudeLong;
    }

    public String getLongitudeLong() {
        return longitudeLong;
    }

    public void setLongitudeLong(String longitudeLong) {
        this.longitudeLong = longitudeLong;
    }

    public String getLatitudeShort() {
        return latitudeShort;
    }

    public void setLatitudeShort(String latitudeShort) {
        this.latitudeShort = latitudeShort;
    }

    public String getLongitudeShort() {
        return longitudeShort;
    }

    public void setLongitudeShort(String longitudeShort) {
        this.longitudeShort = longitudeShort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MunicipalityResponse that = (MunicipalityResponse) o;

        return new EqualsBuilder().append(id, that.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("oldId", oldId)
                .append("url", url)
                .append("altitude", altitude)
                .append("capitalCity", capitalCity)
                .append("population", population)
                .append("regionCode", regionCode)
                .append("highlighted", highlighted)
                .append("name", name)
                .append("latitudeLong", latitudeLong)
                .append("longitudeLong", longitudeLong)
                .append("latitudeShort", latitudeShort)
                .append("longitudeShort", longitudeShort)
                .toString();
    }
}
