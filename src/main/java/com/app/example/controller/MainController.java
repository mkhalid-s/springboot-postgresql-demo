/**
 * 
 */
package com.app.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mshaikh4
 *
 */
@Controller
public class MainController {

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
		return PAGE_INDEX;
	}

}
