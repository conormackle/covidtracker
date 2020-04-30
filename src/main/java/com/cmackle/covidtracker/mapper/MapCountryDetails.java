package com.cmackle.covidtracker.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cmackle.covidtracker.model.Country;
import com.cmackle.covidtracker.model.CountryDetails;

@Component
public class MapCountryDetails {
	
	public void mappingCountryDetails(Country country, Map<String, Object> map) {
		
		CountryDetails countryDetails = new CountryDetails();
		
		countryDetails.setId((int)map.get("id"));
		countryDetails.setName(map.get("country").toString());
		countryDetails.setLastUpdated(map.get("last_updated").toString());
		countryDetails.setPopulation((int)map.get("country_population"));
		
		country.setCountryDetails(countryDetails);
		
	}

}
