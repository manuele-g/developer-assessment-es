package com.developer.assessment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.assessment.services.IImportService;

/**
 * The Class ImportController.
 */
@RestController
@RequestMapping("/import")
public class ImportController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ImportController.class);

	/** The import service. */
	@Autowired
	private IImportService importService;

	/**
	 * Import json data.
	 */
	@GetMapping("/json/data")
	public Boolean importJsonData() {
		log.info("Start to import airports and countries' data from json");
		return this.importService.importJsonData();
	}
}
