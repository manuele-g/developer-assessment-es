package com.developer.assessment.model;

import java.util.List;

import com.developer.assessment.entities.Airport;

/**
 * The Class AirportModel.
 */
public class AirportModel {

	/** The airports. */
	private List<Airport> airports;

	/**
	 * Instantiates a new airport model.
	 */
	public AirportModel() {
		super();
	}

	/**
	 * Gets the airports.
	 *
	 * @return the airports
	 */
	public List<Airport> getAirports() {
		return airports;
	}

	/**
	 * Sets the airports.
	 *
	 * @param airports the new airports
	 */
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}