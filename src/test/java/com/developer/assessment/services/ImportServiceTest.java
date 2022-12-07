package com.developer.assessment.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.developer.assessment.repositories.AirportRepository;
import com.developer.assessment.repositories.CountryRepository;
import com.google.common.collect.Lists;

/**
 * The Class ImportServiceTest.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
class ImportServiceTest {

	/** The airport repository. */
	@Mock
	private AirportRepository airportRepository;

	/** The country repository. */
	@Mock
	private CountryRepository countryRepository;

	/** The import service. */
	@InjectMocks
	private ImportService importService;

	/**
	 * Import json data success.
	 */
	@Test
	void importJsonData_success() {
		when(this.countryRepository.saveAll(Mockito.any())).thenReturn(Lists.newArrayList());

		when(this.airportRepository.saveAll(Mockito.any())).thenReturn(Lists.newArrayList());

		Boolean result = this.importService.importJsonData();
		assertTrue(result);
	}

	/**
	 * Import json data fail during import countries.
	 */
	@Test
	void importJsonData_fail_during_import_countries() {
		when(this.countryRepository.saveAll(Mockito.any())).thenThrow(new InternalError());
		Assertions.assertThrows(InternalError.class, () -> {
			this.importService.importJsonData();
		});
	}

	/**
	 * Import json data fail during import airports.
	 */
	@Test
	void importJsonData_fail_during_import_airports() {
		when(this.airportRepository.saveAll(Mockito.any())).thenThrow(new InternalError());
		Assertions.assertThrows(InternalError.class, () -> {
			this.importService.importJsonData();
		});
	}
}
