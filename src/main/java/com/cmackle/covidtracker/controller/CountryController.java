package com.cmackle.covidtracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmackle.covidtracker.entity.CountryInformation;
import com.cmackle.covidtracker.mapper.CountryMapper;
import com.cmackle.covidtracker.model.Country;
import com.cmackle.covidtracker.service.CountryService;
import com.cmackle.covidtracker.service.MailService;

@Controller
@RequestMapping("/countries")
public class CountryController {
	
	private CountryService countryService;
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	// add mapping for "/list"
	
		@GetMapping("/list")
		public String listCountries(Model theModel) {
			
			List<CountryInformation> countryInformation = countryService.findAll();
			
			
			theModel.addAttribute("countryInformation", countryInformation);
			
			return "countries/list-country-information";
		}
		
		@GetMapping("/showCountryUpdates")
		public String showCountryUpdates(@RequestParam("countryCode") String countryCode, Model theModel) {
			
			String url = "https://coronavirus-tracker-api.herokuapp.com/v2/locations?country_code=" + countryCode;
			
			CountryMapper cm = new CountryMapper();
			
			Country country = new Country();
							
			cm.map(country, url);	
			
			if(country.getCountryDetails() == null) {
				return "countries/country-not-found.html";
			}
			
			
			theModel.addAttribute("countryInformation", country);

			
			return "countries/country-updates";
		}
		
		@GetMapping("/showCountryTimelines")
		public String showCountryTimelines(@RequestParam("countryCode") String countryCode, Model theModel) {
			
			String url = "https://coronavirus-tracker-api.herokuapp.com/v2/locations?country_code=" + countryCode;
			
			CountryMapper cm = new CountryMapper();
			
			Country country = new Country();
							
			cm.map(country, url);	
			
			if(country.getCountryDetails() == null) {
				return "countries/country-not-found.html";
			}
			
			
			theModel.addAttribute("countryInformation", country);

			
			return "countries/country-timelines";
		}
		
		@GetMapping("/report")
		public String reportCountryLink(@RequestParam("countryCode") String countryCode, Model theModel) {
			
	//		MailService mailService = new MailService();
		
	//		mailService.sendEmail("The country code: " + countryCode+ " is invalid!", "Invalid CountryCode", "conor.mackle@aqauq.co.uk");
			
			return "countries/reported-country";
		}
	

}
