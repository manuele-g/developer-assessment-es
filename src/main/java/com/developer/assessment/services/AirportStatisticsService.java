package com.developer.assessment.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchAggregation;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.AggregationsContainer;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.developer.assessment.converters.AirportConverter;
import com.developer.assessment.converters.CountryConverter;
import com.developer.assessment.dto.AirportDto;
import com.developer.assessment.dto.CountryDto;
import com.developer.assessment.dto.CountryFilterDto;
import com.developer.assessment.dto.TopCountriesDto;
import com.developer.assessment.entities.Airport;
import com.developer.assessment.entities.Country;
import com.developer.assessment.repositories.AirportRepository;
import com.developer.assessment.repositories.CountryRepository;
import com.google.common.collect.Lists;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.aggregations.Buckets;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsAggregate;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsBucket;
import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.WildcardQuery;

/**
 * The Class AiportStatisticsService.
 */
@Service
@Transactional
public class AirportStatisticsService implements IAirportStatisticsService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AirportStatisticsService.class);

	/** The Constant EXECUTING_QUERY. */
	private static final String EXECUTING_QUERY = "Executing query...";

	/** The Constant FIELD_COUNTRY_NAME. */
	private static final String FIELD_COUNTRY_NAME = "name";

	/** The Constant FIELD_COUNTRY_CODE. */
	private static final String FIELD_COUNTRY_CODE = "code";

	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private AirportRepository airportRepository;

	/** The airport converter. */
	@Autowired
	private AirportConverter airportConverter;

	/** The country converter. */
	@Autowired
	private CountryConverter countryConverter;

	/** The elasticsearch operations. */
	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	@Value("${page.size.country}")
	private Integer pageSizeCountry;

	/**
	 * Gets the runways by country code or name.
	 *
	 * @param filter the filter
	 * @return the runways by country code or name
	 */
	@Override
	public List<AirportDto> getRunwaysByCountryCodeOrName(CountryFilterDto filter) {
		try {

			List<String> countryCodes = this.filterCountryByCodeOrName(filter);

			Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize(),
					Sort.by("DESC".equalsIgnoreCase(filter.getSortOrder()) ? Sort.Direction.DESC : Sort.Direction.ASC,
							filter.getSortBy()));

			log.info("Creating query and pageable to get runways given countries...");
			List<Airport> aiports = this.airportRepository.findByIsoCountryIn(countryCodes, pageable);

			log.info("Mapping data to dto");
			List<AirportDto> result = this.airportConverter.convertListToEntityAttribute(aiports);
			log.info("Number of airports found given a country code or name: {}", result.size());
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the top countries.
	 *
	 * @param limit the limit
	 * @return the top countries
	 */
	@Override
	public List<TopCountriesDto> getTopCountries(int limit) {
		try {
			List<TopCountriesDto> result = Lists.newArrayList();
			log.info("Building query to get top {} countries with highest number of airports", limit);
			Query query = NativeQuery.builder().withAggregation("topCountries",
					Aggregation.of(agg -> agg.terms(term -> term.field("isoCountry").size(limit)))).build();

			log.info(EXECUTING_QUERY);
			SearchHits<Airport> searchHits = elasticsearchOperations.search(query, Airport.class);

			log.info("Getting aggregation...");
			AggregationsContainer<?> aggregationsContainer = searchHits.getAggregations();
			if (aggregationsContainer == null) {
				return result;
			}

			@SuppressWarnings("unchecked")
			List<ElasticsearchAggregation> aggregations = (List<ElasticsearchAggregation>) aggregationsContainer
					.aggregations();

			StringTermsAggregate stringTermsAggregate = (StringTermsAggregate) aggregations.get(0).aggregation()
					.getAggregate()._get();
			Buckets<StringTermsBucket> buckets = stringTermsAggregate.buckets();
			if (buckets != null) {
				log.info("Processing buckets, getting and mapping countries to dto...");
				result = buckets.array().stream().map(bucket -> {
					Country country = this.countryRepository.findByCode(bucket.key().stringValue())
							.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Country not found"));
					CountryDto countryDto = this.countryConverter.convertToEntityAttribute(country);
					TopCountriesDto dto = new TopCountriesDto(countryDto);
					dto.setNumberOfAirports(bucket.docCount());
					return dto;
				}).toList();
			}
			log.info("End getting top {} countries with highest number of airports.", limit);
			return result;
		} catch (HttpClientErrorException e) {
			log.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private List<String> filterCountryByCodeOrName(CountryFilterDto filter) {
		log.info("Creating query and pageable to get countries given a code or name...");
		Pageable pageable = PageRequest.of(0, pageSizeCountry, Sort.Direction.ASC, "id");
		log.info("Creating query and pageable to get runways given a country code or name...");
		NativeQueryBuilder withQuery = NativeQuery.builder();
		if (StringUtils.isNotBlank(filter.getName())) {
			log.info("Creating query to get runways given a country NAME...");
			String name = filter.getName().toLowerCase();
			String wildcardValue = name.length() >= 3 ? new StringBuilder(name).append("*").toString() : name;

			WildcardQuery wildcardQuery = QueryBuilders.wildcard().field(FIELD_COUNTRY_NAME).wildcard(wildcardValue)
					.build();

			FuzzyQuery fuzzyQuery = QueryBuilders.fuzzy().field(FIELD_COUNTRY_NAME).value(name).build();

			MatchQuery matchQuery = QueryBuilders.match().field(FIELD_COUNTRY_NAME).query(name).build();

			withQuery.withQuery(QueryBuilders.bool(boolQuery -> boolQuery
					.should(co.elastic.clients.elasticsearch._types.query_dsl.Query
							.of(match -> match.match(matchQuery)))
					.should(co.elastic.clients.elasticsearch._types.query_dsl.Query
							.of(wildcard -> wildcard.wildcard(wildcardQuery)))
					.should(co.elastic.clients.elasticsearch._types.query_dsl.Query
							.of(fuzzy -> fuzzy.fuzzy(fuzzyQuery)))));
		}

		if (StringUtils.isNotBlank(filter.getCode())) {
			log.info("Creating query to get runways given a country CODE...");
			MatchQuery matchQuery = QueryBuilders.match().field(FIELD_COUNTRY_CODE).query(filter.getCode()).build();
			withQuery.withFilter(QueryBuilders.bool(
					b -> b.must(co.elastic.clients.elasticsearch._types.query_dsl.Query.of(a -> a.match(matchQuery)))));
		}

		Query query = withQuery.withPageable(pageable).build();

		log.info(EXECUTING_QUERY);
		SearchHits<Country> search = this.elasticsearchOperations.search(query, Country.class);

		List<String> countries = search.get().map(t -> t.getContent().getCode()).toList();
		log.info("{} countries found", countries.size());
		return countries;

	}

}
