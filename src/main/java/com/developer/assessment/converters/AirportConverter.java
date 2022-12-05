package com.developer.assessment.converters;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.entities.Airport;

/**
 * The Class AirportConverter.
 */
@Converter
@Service
public class AirportConverter implements AttributeConverter<AirportDto, Airport> {

	/** The runway converter. */
	@Autowired
	RunwayConverter runwayConverter;

	/**
	 * Convert to database column.
	 *
	 * @param dto the dto
	 * @return the airport
	 */
	@Override
	public Airport convertToDatabaseColumn(AirportDto dto) {
		Airport entity = new Airport();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * Convert to entity attribute.
	 *
	 * @param entity the entity
	 * @return the airport dto
	 */
	@Override
	public AirportDto convertToEntityAttribute(Airport entity) {
		AirportDto dto = new AirportDto();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
			dto.setRunways(this.runwayConverter.convertAllToEntityAttribute(entity.getRunways()));
		}
		return dto;
	}

	/**
	 * Convert all to entity attribute.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<AirportDto> convertListToEntityAttribute(List<Airport> entities) {
		return entities.stream().map(this::convertToEntityAttribute).toList();
	}

	/**
	 * Convert stream to entity attribute.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<AirportDto> convertStreamToEntityAttribute(Stream<SearchHit<Airport>> entities) {
		return entities.map(searchHit -> this.convertToEntityAttribute(searchHit.getContent())).toList();
	}

}
