package com.cmackle.covidtracker.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cmackle.covidtracker.model.Country;
import com.cmackle.covidtracker.model.CountryLatest;

@Component
public class MapCountryLatest {

	public void mappingCountryLatest(Country country, Map<String, Object> map) {
		
		CountryLatest countryLatest = new CountryLatest();
		
		countryLatest.setConfirmed(map.get("confirmed").toString());
		countryLatest.setDeaths(map.get("deaths").toString());
		countryLatest.setRecovered(map.get("recovered").toString());

		country.setCountryLatest(countryLatest);
	}
}
