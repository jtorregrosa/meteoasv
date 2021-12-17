package com.jtorregrosa.meteoasv.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The Municipality domain object.
 */
public class Municipality {

    private String id;

    private String oldId;

    private String url;

    private String altitude;

    private String capitalCity;

    private String population;

    private String regionCode;

    private String highlighted;

    private String name;

    private String latitudeLong;

    private String longitudeLong;

    private String latitudeShort;

    private String longitudeShort;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets old id.
     *
     * @return the old id
     */
    public String getOldId() {
        return oldId;
    }

    /**
     * Sets old id.
     *
     * @param oldId the old id
     */
    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets altitude.
     *
     * @return the altitude
     */
    public String getAltitude() {
        return altitude;
    }

    /**
     * Sets altitude.
     *
     * @param altitude the altitude
     */
    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    /**
     * Gets capital city.
     *
     * @return the capital city
     */
    public String getCapitalCity() {
        return capitalCity;
    }

    /**
     * Sets capital city.
     *
     * @param capitalCity the capital city
     */
    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public String getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    /**
     * Gets region code.
     *
     * @return the region code
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * Sets region code.
     *
     * @param regionCode the region code
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * Gets highlighted.
     *
     * @return the highlighted
     */
    public String getHighlighted() {
        return highlighted;
    }

    /**
     * Sets highlighted.
     *
     * @param highlighted the highlighted
     */
    public void setHighlighted(String highlighted) {
        this.highlighted = highlighted;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets latitude long.
     *
     * @return the latitude long
     */
    public String getLatitudeLong() {
        return latitudeLong;
    }

    /**
     * Sets latitude long.
     *
     * @param latitudeLong the latitude long
     */
    public void setLatitudeLong(String latitudeLong) {
        this.latitudeLong = latitudeLong;
    }

    /**
     * Gets longitude long.
     *
     * @return the longitude long
     */
    public String getLongitudeLong() {
        return longitudeLong;
    }

    /**
     * Sets longitude long.
     *
     * @param longitudeLong the longitude long
     */
    public void setLongitudeLong(String longitudeLong) {
        this.longitudeLong = longitudeLong;
    }

    /**
     * Gets latitude short.
     *
     * @return the latitude short
     */
    public String getLatitudeShort() {
        return latitudeShort;
    }

    /**
     * Sets latitude short.
     *
     * @param latitudeShort the latitude short
     */
    public void setLatitudeShort(String latitudeShort) {
        this.latitudeShort = latitudeShort;
    }

    /**
     * Gets longitude short.
     *
     * @return the longitude short
     */
    public String getLongitudeShort() {
        return longitudeShort;
    }

    /**
     * Sets longitude short.
     *
     * @param longitudeShort the longitude short
     */
    public void setLongitudeShort(String longitudeShort) {
        this.longitudeShort = longitudeShort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Municipality that = (Municipality) o;

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
