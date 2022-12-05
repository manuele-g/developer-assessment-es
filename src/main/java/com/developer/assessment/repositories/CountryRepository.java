package com.developer.assessment.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.developer.assessment.entities.Country;

/**
 * The Interface CountryRepository.
 */
public interface CountryRepository extends ElasticsearchRepository<Country, Long> {

	/**
	 * Find by code.
	 *
	 * @param code the code
	 * @return the optional
	 */
	Optional<Country> findByCode(String code);
}
