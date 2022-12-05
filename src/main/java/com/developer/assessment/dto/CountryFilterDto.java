package com.developer.assessment.dto;

/**
 * The Class CountryFilterDto.
 */
public class CountryFilterDto extends PageDto {

	/** The code. */
	private String code;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new country filter dto.
	 */
	public CountryFilterDto() {
		super();
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
