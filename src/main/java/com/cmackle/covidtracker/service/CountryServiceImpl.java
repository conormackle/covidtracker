package com.cmackle.covidtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cmackle.covidtracker.dao.CountryInformationRepository;
import com.cmackle.covidtracker.entity.CountryInformation;

@Service
public class CountryServiceImpl implements CountryService{
	
	
	private CountryInformationRepository countryInformationRepository;
	
	@Autowired
	public CountryServiceImpl(CountryInformationRepository countryInformationRepository) {
		this.countryInformationRepository = countryInformationRepository;
	}
	
	
	@Override
	public List<CountryInformation> findAll() {
		return countryInformationRepository.findAll();
	}

	@Override
	public CountryInformation findById(int theId) {
		
		Optional<CountryInformation> result = countryInformationRepository.findById(theId);
		
		CountryInformation countryInformation = null;
		if(result.isPresent()) {
			countryInformation = result.get();
		}else {
			// we didn't find the employee
			throw new RuntimeException("Did not find the country id - " + theId);
		}
		
		return countryInformation;
	}

	@Override
	public void save(CountryInformation customerInformation) {
		countryInformationRepository.save(customerInformation);
		
	}

	@Override
	public void deleteById(int Id) {
		countryInformationRepository.deleteById(Id);
		
	}

}
