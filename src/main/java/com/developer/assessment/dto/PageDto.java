package com.developer.assessment.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * The Class PageDto.
 */
public class PageDto extends SortDto {

	/** The page. */
	@NotNull(message = "Page field must be not blank")
	private Integer page;

	/** The size. */
	@NotNull(message = "Size field must be not blank")
	@Positive(message = "Size field must be positive")
	private Integer size;

	/**
	 * Instantiates a new page dto.
	 */
	public PageDto() {
		super();
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the new page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
