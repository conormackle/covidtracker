package com.cmackle.covidtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmackle.covidtracker.mapper.CountryMapper;
import com.cmackle.covidtracker.model.Country;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHome() {
				
		return "index";
	}
	

}
