package com.developer.assessment.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.developer.assessment.entities.Airport;

/**
 * The Interface AirportRepository.
 */
public interface AirportRepository extends ElasticsearchRepository<Airport, Long> {

	List<Airport> findByIsoCountryIn(List<String> list, Pageable pageAble);
}
