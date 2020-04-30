package com.cmackle.covidtracker.service;

import java.util.List;

import com.cmackle.covidtracker.entity.CountryInformation;

public interface CountryService{
	
	public List<CountryInformation> findAll();
	
	public CountryInformation findById(int theId);
	
	public void save(CountryInformation countryInformation);
	
	public void deleteById(int Id);

	

}
