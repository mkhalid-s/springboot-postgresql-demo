/**
 * 
 */
package com.app.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.example.repository.PersonRepository;

/**
 * @author mshaikh4
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
public class MainController {

	@Autowired
	private PersonRepository personRepository;

	/*
	 * 
	 */
	private static final String PAGE_INDEX = "index";
	/**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(MainController.class);

	/**
	 * Index Point
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("ipaddress", request.getRemoteAddr());
		logger.info("Hello Index");
		return PAGE_INDEX;
	}

	/**
	 * Index Point
	 * 
	 * @return
	 */
	@GetMapping("/test")
	public String test(Model model, HttpServletRequest request) {
		return PAGE_INDEX;
	}

	@GetMapping("/persons")
	public String getPerson(Model model, HttpServletRequest request) {
		model.addAttribute("persons", personRepository.findAll());
		return PAGE_INDEX;
	}

}
