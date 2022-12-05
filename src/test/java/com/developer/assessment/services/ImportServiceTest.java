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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
class ImportServiceTest {

	@Mock
	private AirportRepository airportRepository;

	@Mock
	private CountryRepository countryRepository;

	/** The chat service. */
	@InjectMocks
	private ImportService importService;

	@Test
	void importJsonData_success() {
		when(this.countryRepository.saveAll(Mockito.any())).thenReturn(Lists.newArrayList());

		when(this.airportRepository.saveAll(Mockito.any())).thenReturn(Lists.newArrayList());

		Boolean result = this.importService.importJsonData();
		assertTrue(result);
	}

	@Test
	void importJsonData_fail_during_import_countries() {
		when(this.countryRepository.saveAll(Mockito.any())).thenThrow(new InternalError());
		Assertions.assertThrows(InternalError.class, () -> {
			this.importService.importJsonData();
		});
	}

	@Test
	void importJsonData_fail_during_import_airports() {
		when(this.airportRepository.saveAll(Mockito.any())).thenThrow(new InternalError());
		Assertions.assertThrows(InternalError.class, () -> {
			this.importService.importJsonData();
		});
	}
}
