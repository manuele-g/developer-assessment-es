package com.developer.assessment.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import com.developer.assessment.helper.Constants;

/**
 * The persistent class for the Airports database table.
 * 
 */
@Document(indexName = Constants.AIRPORT_INDEX)
@Setting(settingPath = "/settings/index-settings.json")
public class Airport implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1907592485297599992L;

	/** The id. */
	@Id
	private Long id;

	/** The continent. */
	@Field(type = FieldType.Text, name = "continent", fielddata = true)
	private String continent;

	/** The elevation ft. */
	@Field(type = FieldType.Integer, name = "elevationFt")
	private Integer elevationFt;

	/** The gps code. */
	@Field(type = FieldType.Text, name = "gpsCode", fielddata = true)
	private String gpsCode;

	/** The home link. */
	@Field(type = FieldType.Text, name = "homeLink", fielddata = true)
	private String homeLink;

	/** The iata code. */
	@Field(type = FieldType.Text, name = "iataCode", fielddata = true)
	private String iataCode;

	/** The ident. */
	@Field(type = FieldType.Text, name = "ident", fielddata = true)
	private String ident;

	/** The iso region. */
	@Field(type = FieldType.Text, name = "isoRegion", fielddata = true)
	private String isoRegion;

	/** The keywords. */
	@Field(type = FieldType.Text, name = "keywords", fielddata = true)
	private String keywords;

	/** The latitude deg. */
	@Field(type = FieldType.Double, name = "latitudeDeg")
	private Double latitudeDeg;

	/** The local code. */
	@Field(type = FieldType.Text, name = "localCode", fielddata = true)
	private String localCode;

	/** The longitude deg. */
	@Field(type = FieldType.Double, name = "longitudeDeg")
	private Double longitudeDeg;

	/** The municipality. */
	@Field(type = FieldType.Text, name = "municipality", fielddata = true)
	private String municipality;

	/** The name. */
	@Field(type = FieldType.Text, name = "name", fielddata = true)
	private String name;

	/** The scheduled service. */
	@Field(type = FieldType.Text, name = "scheduledService", fielddata = true)
	private String scheduledService;

	/** The type. */
	@Field(type = FieldType.Text, name = "type", fielddata = true)
	private String type;

	/** The wikipedia link. */
	@Field(type = FieldType.Text, name = "wikipediaLink", fielddata = true)
	private String wikipediaLink;

	/** The country. */
	@Field(type = FieldType.Text, fielddata = true)
	private String isoCountry;

	/** The runways. */
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Runway> runways;

	/**
	 * Instantiates a new airport.
	 */
	public Airport() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the continent.
	 *
	 * @return the continent
	 */
	public String getContinent() {
		return this.continent;
	}

	/**
	 * Sets the continent.
	 *
	 * @param continent the new continent
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * Gets the elevation ft.
	 *
	 * @return the elevation ft
	 */
	public Integer getElevationFt() {
		return this.elevationFt;
	}

	/**
	 * Sets the elevation ft.
	 *
	 * @param elevationFt the new elevation ft
	 */
	public void setElevationFt(Integer elevationFt) {
		this.elevationFt = elevationFt;
	}

	/**
	 * Gets the gps code.
	 *
	 * @return the gps code
	 */
	public String getGpsCode() {
		return this.gpsCode;
	}

	/**
	 * Sets the gps code.
	 *
	 * @param gpsCode the new gps code
	 */
	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}

	/**
	 * Gets the home link.
	 *
	 * @return the home link
	 */
	public String getHomeLink() {
		return this.homeLink;
	}

	/**
	 * Sets the home link.
	 *
	 * @param homeLink the new home link
	 */
	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
	}

	/**
	 * Gets the iata code.
	 *
	 * @return the iata code
	 */
	public String getIataCode() {
		return this.iataCode;
	}

	/**
	 * Sets the iata code.
	 *
	 * @param iataCode the new iata code
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	/**
	 * Gets the ident.
	 *
	 * @return the ident
	 */
	public String getIdent() {
		return this.ident;
	}

	/**
	 * Sets the ident.
	 *
	 * @param ident the new ident
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}

	/**
	 * Gets the iso region.
	 *
	 * @return the iso region
	 */
	public String getIsoRegion() {
		return this.isoRegion;
	}

	/**
	 * Sets the iso region.
	 *
	 * @param isoRegion the new iso region
	 */
	public void setIsoRegion(String isoRegion) {
		this.isoRegion = isoRegion;
	}

	/**
	 * Gets the keywords.
	 *
	 * @return the keywords
	 */
	public String getKeywords() {
		return this.keywords;
	}

	/**
	 * Sets the keywords.
	 *
	 * @param keywords the new keywords
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * Gets the latitude deg.
	 *
	 * @return the latitude deg
	 */
	public Double getLatitudeDeg() {
		return this.latitudeDeg;
	}

	/**
	 * Sets the latitude deg.
	 *
	 * @param latitudeDeg the new latitude deg
	 */
	public void setLatitudeDeg(Double latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}

	/**
	 * Gets the local code.
	 *
	 * @return the local code
	 */
	public String getLocalCode() {
		return this.localCode;
	}

	/**
	 * Sets the local code.
	 *
	 * @param localCode the new local code
	 */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/**
	 * Gets the longitude deg.
	 *
	 * @return the longitude deg
	 */
	public Double getLongitudeDeg() {
		return this.longitudeDeg;
	}

	/**
	 * Sets the longitude deg.
	 *
	 * @param longitudeDeg the new longitude deg
	 */
	public void setLongitudeDeg(Double longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}

	/**
	 * Gets the municipality.
	 *
	 * @return the municipality
	 */
	public String getMunicipality() {
		return this.municipality;
	}

	/**
	 * Sets the municipality.
	 *
	 * @param municipality the new municipality
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the scheduled service.
	 *
	 * @return the scheduled service
	 */
	public String getScheduledService() {
		return this.scheduledService;
	}

	/**
	 * Sets the scheduled service.
	 *
	 * @param scheduledService the new scheduled service
	 */
	public void setScheduledService(String scheduledService) {
		this.scheduledService = scheduledService;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the wikipedia link.
	 *
	 * @return the wikipedia link
	 */
	public String getWikipediaLink() {
		return this.wikipediaLink;
	}

	/**
	 * Sets the wikipedia link.
	 *
	 * @param wikipediaLink the new wikipedia link
	 */
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}

	/**
	 * Gets the iso country.
	 *
	 * @return the iso country
	 */
	public String getIsoCountry() {
		return isoCountry;
	}

	/**
	 * Sets the iso country.
	 *
	 * @param isoCountry the new iso country
	 */
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

	/**
	 * Gets the runways.
	 *
	 * @return the runways
	 */
	public List<Runway> getRunways() {
		return runways;
	}

	/**
	 * Sets the runways.
	 *
	 * @param runways the new runways
	 */
	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}

}