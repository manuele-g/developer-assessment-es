package com.developer.assessment.model;

import java.util.List;

import com.developer.assessment.entities.Country;

/**
 * The Class CountryModel.
 */
public class CountryModel {

	/** The countries. */
	private List<Country> countries;

	/**
	 * Instantiates a new country model.
	 */
	public CountryModel() {
		super();
	}

	/**
	 * Gets the countries.
	 *
	 * @return the countries
	 */
	public List<Country> getCountries() {
		return countries;
	}

	/**
	 * Sets the countries.
	 *
	 * @param countries the new countries
	 */
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}