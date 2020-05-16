package com.medici.controller;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author a73s
 *
 */
@RestController
@RequestMapping("/environment")
public class EnvironmentController {

	protected Logger logger = Logger.getLogger(EnvironmentController.class.getName());

	@Autowired
	Environment environment;

	@RequestMapping(value = "/system", method = RequestMethod.GET)
	public Map<String, String> envVars() {
		logger.info("microservice envVars() invoked");
		return System.getenv();
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public String[] activeProfiles() {
		logger.info("microservice activeProfiles() invoked");
		return environment.getActiveProfiles();
	}

}
