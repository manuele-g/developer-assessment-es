package com.developer.assessment.dto;

/**
 * The Class TopCountriesDto.
 */
public class TopCountriesDto extends CountryDto {

	/** The number of airports. */
	private Long numberOfAirports;

	/**
	 * Instantiates a new top ten countries dto.
	 */
	public TopCountriesDto() {
		super();
	}

	/**
	 * Instantiates a new top countries dto.
	 *
	 * @param country the country
	 */
	public TopCountriesDto(CountryDto country) {
		super(country.getId(), country.getCode(), country.getContinent(), country.getKeywords(), country.getName(),
				country.getWikipediaLink());
	}

	/**
	 * Gets the number of airports.
	 *
	 * @return the number of airports
	 */
	public Long getNumberOfAirports() {
		return numberOfAirports;
	}

	/**
	 * Sets the number of airports.
	 *
	 * @param numberOfAirports the new number of airports
	 */
	public void setNumberOfAirports(Long numberOfAirports) {
		this.numberOfAirports = numberOfAirports;
	}

}
