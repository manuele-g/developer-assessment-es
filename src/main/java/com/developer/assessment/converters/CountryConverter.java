package com.developer.assessment.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.entities.Country;

/**
 * The Class CountryConverter.
 */
@Converter
@Service
public class CountryConverter implements AttributeConverter<CountryDto, Country> {

	/**
	 * Convert to database column.
	 *
	 * @param dto the dto
	 * @return the country
	 */
	@Override
	public Country convertToDatabaseColumn(CountryDto dto) {
		Country entity = new Country();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the country dto
	 */
	@Override
	public CountryDto convertToEntityAttribute(Country entity) {
		CountryDto dto = new CountryDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}
}
