package com.developer.assessment.services;

import java.io.InputStreamReader;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.developer.assessment.helper.Constants;
import com.developer.assessment.model.AirportModel;
import com.developer.assessment.model.CountryModel;
import com.developer.assessment.repositories.AirportRepository;
import com.developer.assessment.repositories.CountryRepository;
import com.google.gson.Gson;

/**
 * The Class ImportService.
 */
@Service
@Transactional
public class ImportService implements IImportService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ImportService.class);

	/** The airport repository. */
	@Autowired
	private AirportRepository airportRepository;

	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;

	/**
	 * Import json data.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean importJsonData() {

		log.info("Reading json with countries...");
		try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(Constants.COUNTRY_JSON))) {
			CountryModel countryModel = new Gson().fromJson(reader, CountryModel.class);

			log.info("Saving json with countries...");
			this.countryRepository.saveAll(countryModel.getCountries());
		} catch (Exception e) {
			log.error("Erorr during reading/saving countries json from resources");
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		log.info("Reading json with airports...");
		try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(Constants.AIRPORT_JSON))) {
			AirportModel airportModel = new Gson().fromJson(reader, AirportModel.class);

			log.info("Saving json with airports...");
			this.airportRepository.saveAll(airportModel.getAirports());
		} catch (Exception e) {
			log.error("Erorr during reading/saving airports json from resources");
			log.error(e.getMessage(), e);
			throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		log.info("End to save countries and aiports' data.");
		return Boolean.TRUE;
	}
}
