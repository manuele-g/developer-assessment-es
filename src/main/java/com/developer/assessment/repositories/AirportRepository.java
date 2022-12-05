package com.developer.assessment.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.developer.assessment.entities.Airport;

/**
 * The Interface AirportRepository.
 */
public interface AirportRepository extends ElasticsearchRepository<Airport, Long> {

	/**
	 * Find by iso country in.
	 *
	 * @param list the list
	 * @param pageAble the page able
	 * @return the list
	 */
	List<Airport> findByIsoCountryIn(List<String> list, Pageable pageAble);
}
