package com.spring.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("logger")
public class HomeController {

	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/home")
	public String getHome() {
		log.error("the error");
		log.trace("new error");
		return"home controller";
	}
}
