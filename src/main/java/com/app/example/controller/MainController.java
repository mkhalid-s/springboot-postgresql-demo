/**
 * 
 */
package com.app.example.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.example.entity.Person;
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

	@GetMapping("/allpersons")
	public String getPerson(Model model, HttpServletRequest request) {
		model.addAttribute("persons", personRepository.findAll());
		return PAGE_INDEX;
	}

	@GetMapping("/person")
	public String getPagePerson(Model model, HttpServletRequest request, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		int currentPage = page.orElse(1);
		int pageSize = size.orElse(10);
		Page<Person> personPage = personRepository.findAll(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("persons", personPage);

		int totalPages = personPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return PAGE_INDEX;
	}

}
