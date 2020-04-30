package com.cmackle.covidtracker.model;

import java.util.Map;

public class CountryTimelines {
	
	private String latest;
	
	private Map<String, Object> countryConfirmed;
	
	private Map<String, Object> countryDeaths;
	
	private Map<String, Object> countryRecovered;
	
	
	public CountryTimelines() {
	}


	public CountryTimelines(String latest, Map<String, Object> countryConfirmed, Map<String, Object> countryDeaths,
			Map<String, Object> countryRecovered) {
		this.latest = latest;
		this.countryConfirmed = countryConfirmed;
		this.countryDeaths = countryDeaths;
		this.countryRecovered = countryRecovered;
	}


	public String getLatest() {
		return latest;
	}


	public void setLatest(String latest) {
		this.latest = latest;
	}


	public Map<String, Object> getCountryConfirmed() {
		return countryConfirmed;
	}


	public void setCountryConfirmed(Map<String, Object> countryConfirmed) {
		this.countryConfirmed = countryConfirmed;
	}


	public Map<String, Object> getCountryDeaths() {
		return countryDeaths;
	}


	public void setCountryDeaths(Map<String, Object> countryDeaths) {
		this.countryDeaths = countryDeaths;
	}


	public Map<String, Object> getCountryRecovered() {
		return countryRecovered;
	}


	public void setCountryRecovered(Map<String, Object> countryRecovered) {
		this.countryRecovered = countryRecovered;
	}
		

}
