package com.cmackle.covidtracker.model;

public class Country {
		
	private CountryDetails countryDetails;
	
	private CountryLatest countryLatest;
	
	private CountryTimelines countryTimelines;
	
	public Country() {
		
	}

	public CountryLatest getCountryLatest() {
		return countryLatest;
	}

	public void setCountryLatest(CountryLatest countryLatest) {
		this.countryLatest = countryLatest;
	}

	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}

	public CountryTimelines getCountryTimelines() {
		return countryTimelines;
	}

	public void setCountryTimelines(CountryTimelines countryTimelines) {
		this.countryTimelines = countryTimelines;
	}
	

}
