package com.developer.assessment.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * The persistent class for the Runways database table.
 * 
 */
public class Runway implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 587018188284792878L;

	/** The id. */
	@Id
	private Long id;

	/** The airport ident. */
	@Field(type = FieldType.Text, name = "airportIdent")
	private String airportIdent;

	/** The closed. */
	@Field(type = FieldType.Boolean, name = "closed")
	private Boolean closed;

	/** The he displaced threshold ft. */
	@Field(type = FieldType.Integer, name = "heDisplacedThresholdFt")
	private Integer heDisplacedThresholdFt;

	/** The he elevation ft. */
	@Field(type = FieldType.Integer, name = "heElevationFt")
	private Integer heElevationFt;

	/** The he heading deg T. */
	@Field(type = FieldType.Integer, name = "heHeadingDegT")
	private Integer heHeadingDegT;

	/** The he ident. */
	@Field(type = FieldType.Text, name = "heIdent")
	private String heIdent;

	/** The he latitude deg. */
	@Field(type = FieldType.Double, name = "heLatitudeDeg")
	private Double heLatitudeDeg;

	/** The he longitude deg. */
	@Field(type = FieldType.Double, name = "heLongitudeDeg")
	private Double heLongitudeDeg;

	/** The le displaced threshold ft. */
	@Field(type = FieldType.Integer, name = "leDisplacedThresholdFt")
	private Integer leDisplacedThresholdFt;

	/** The le elevation ft. */
	@Field(type = FieldType.Integer, name = "leElevationFt")
	private Integer leElevationFt;

	/** The le heading deg T. */
	@Field(type = FieldType.Integer, name = "leHeadingDegT")
	private Integer leHeadingDegT;

	/** The le ident. */
	@Field(type = FieldType.Text, name = "leIdent")
	private String leIdent;

	/** The le latitude deg. */
	@Field(type = FieldType.Double, name = "leLatitudeDeg")
	private Double leLatitudeDeg;

	/** The le longitude deg. */
	@Field(type = FieldType.Double, name = "leLongitudeDeg")
	private Double leLongitudeDeg;

	/** The length ft. */
	@Field(type = FieldType.Integer, name = "lengthFt")
	private Integer lengthFt;

	/** The lighted. */
	@Field(type = FieldType.Boolean, name = "lighted")
	private Boolean lighted;

	/** The surface. */
	@Field(type = FieldType.Text, name = "surface")
	private String surface;

	/** The width ft. */
	@Field(type = FieldType.Integer, name = "widthFt")
	private Integer widthFt;

	/**
	 * Instantiates a new runway.
	 */
	public Runway() {
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
	 * Gets the airport ident.
	 *
	 * @return the airport ident
	 */
	public String getAirportIdent() {
		return this.airportIdent;
	}

	/**
	 * Sets the airport ident.
	 *
	 * @param airportIdent the new airport ident
	 */
	public void setAirportIdent(String airportIdent) {
		this.airportIdent = airportIdent;
	}

	/**
	 * Gets the closed.
	 *
	 * @return the closed
	 */
	public Boolean getClosed() {
		return this.closed;
	}

	/**
	 * Sets the closed.
	 *
	 * @param closed the new closed
	 */
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	/**
	 * Gets the he displaced threshold ft.
	 *
	 * @return the he displaced threshold ft
	 */
	public Integer getHeDisplacedThresholdFt() {
		return this.heDisplacedThresholdFt;
	}

	/**
	 * Sets the he displaced threshold ft.
	 *
	 * @param heDisplacedThresholdFt the new he displaced threshold ft
	 */
	public void setHeDisplacedThresholdFt(Integer heDisplacedThresholdFt) {
		this.heDisplacedThresholdFt = heDisplacedThresholdFt;
	}

	/**
	 * Gets the he elevation ft.
	 *
	 * @return the he elevation ft
	 */
	public Integer getHeElevationFt() {
		return this.heElevationFt;
	}

	/**
	 * Sets the he elevation ft.
	 *
	 * @param heElevationFt the new he elevation ft
	 */
	public void setHeElevationFt(Integer heElevationFt) {
		this.heElevationFt = heElevationFt;
	}

	/**
	 * Gets the he heading deg T.
	 *
	 * @return the he heading deg T
	 */
	public Integer getHeHeadingDegT() {
		return this.heHeadingDegT;
	}

	/**
	 * Sets the he heading deg T.
	 *
	 * @param heHeadingDegT the new he heading deg T
	 */
	public void setHeHeadingDegT(Integer heHeadingDegT) {
		this.heHeadingDegT = heHeadingDegT;
	}

	/**
	 * Gets the he ident.
	 *
	 * @return the he ident
	 */
	public String getHeIdent() {
		return this.heIdent;
	}

	/**
	 * Sets the he ident.
	 *
	 * @param heIdent the new he ident
	 */
	public void setHeIdent(String heIdent) {
		this.heIdent = heIdent;
	}

	/**
	 * Gets the he latitude deg.
	 *
	 * @return the he latitude deg
	 */
	public Double getHeLatitudeDeg() {
		return this.heLatitudeDeg;
	}

	/**
	 * Sets the he latitude deg.
	 *
	 * @param heLatitudeDeg the new he latitude deg
	 */
	public void setHeLatitudeDeg(Double heLatitudeDeg) {
		this.heLatitudeDeg = heLatitudeDeg;
	}

	/**
	 * Gets the he longitude deg.
	 *
	 * @return the he longitude deg
	 */
	public Double getHeLongitudeDeg() {
		return this.heLongitudeDeg;
	}

	/**
	 * Sets the he longitude deg.
	 *
	 * @param heLongitudeDeg the new he longitude deg
	 */
	public void setHeLongitudeDeg(Double heLongitudeDeg) {
		this.heLongitudeDeg = heLongitudeDeg;
	}

	/**
	 * Gets the le displaced threshold ft.
	 *
	 * @return the le displaced threshold ft
	 */
	public Integer getLeDisplacedThresholdFt() {
		return this.leDisplacedThresholdFt;
	}

	/**
	 * Sets the le displaced threshold ft.
	 *
	 * @param leDisplacedThresholdFt the new le displaced threshold ft
	 */
	public void setLeDisplacedThresholdFt(Integer leDisplacedThresholdFt) {
		this.leDisplacedThresholdFt = leDisplacedThresholdFt;
	}

	/**
	 * Gets the le elevation ft.
	 *
	 * @return the le elevation ft
	 */
	public Integer getLeElevationFt() {
		return this.leElevationFt;
	}

	/**
	 * Sets the le elevation ft.
	 *
	 * @param leElevationFt the new le elevation ft
	 */
	public void setLeElevationFt(Integer leElevationFt) {
		this.leElevationFt = leElevationFt;
	}

	/**
	 * Gets the le heading deg T.
	 *
	 * @return the le heading deg T
	 */
	public Integer getLeHeadingDegT() {
		return this.leHeadingDegT;
	}

	/**
	 * Sets the le heading deg T.
	 *
	 * @param leHeadingDegT the new le heading deg T
	 */
	public void setLeHeadingDegT(Integer leHeadingDegT) {
		this.leHeadingDegT = leHeadingDegT;
	}

	/**
	 * Gets the le ident.
	 *
	 * @return the le ident
	 */
	public String getLeIdent() {
		return this.leIdent;
	}

	/**
	 * Sets the le ident.
	 *
	 * @param leIdent the new le ident
	 */
	public void setLeIdent(String leIdent) {
		this.leIdent = leIdent;
	}

	/**
	 * Gets the le latitude deg.
	 *
	 * @return the le latitude deg
	 */
	public Double getLeLatitudeDeg() {
		return this.leLatitudeDeg;
	}

	/**
	 * Sets the le latitude deg.
	 *
	 * @param leLatitudeDeg the new le latitude deg
	 */
	public void setLeLatitudeDeg(Double leLatitudeDeg) {
		this.leLatitudeDeg = leLatitudeDeg;
	}

	/**
	 * Gets the le longitude deg.
	 *
	 * @return the le longitude deg
	 */
	public Double getLeLongitudeDeg() {
		return this.leLongitudeDeg;
	}

	/**
	 * Sets the le longitude deg.
	 *
	 * @param leLongitudeDeg the new le longitude deg
	 */
	public void setLeLongitudeDeg(Double leLongitudeDeg) {
		this.leLongitudeDeg = leLongitudeDeg;
	}

	/**
	 * Gets the length ft.
	 *
	 * @return the length ft
	 */
	public Integer getLengthFt() {
		return this.lengthFt;
	}

	/**
	 * Sets the length ft.
	 *
	 * @param lengthFt the new length ft
	 */
	public void setLengthFt(Integer lengthFt) {
		this.lengthFt = lengthFt;
	}

	/**
	 * Gets the lighted.
	 *
	 * @return the lighted
	 */
	public Boolean getLighted() {
		return this.lighted;
	}

	/**
	 * Sets the lighted.
	 *
	 * @param lighted the new lighted
	 */
	public void setLighted(Boolean lighted) {
		this.lighted = lighted;
	}

	/**
	 * Gets the surface.
	 *
	 * @return the surface
	 */
	public String getSurface() {
		return this.surface;
	}

	/**
	 * Sets the surface.
	 *
	 * @param surface the new surface
	 */
	public void setSurface(String surface) {
		this.surface = surface;
	}

	/**
	 * Gets the width ft.
	 *
	 * @return the width ft
	 */
	public Integer getWidthFt() {
		return this.widthFt;
	}
}