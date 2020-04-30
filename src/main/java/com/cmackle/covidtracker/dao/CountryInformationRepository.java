package com.cmackle.covidtracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmackle.covidtracker.entity.CountryInformation;

public interface CountryInformationRepository extends JpaRepository<CountryInformation, Integer> {
	// no need to implement code !!
}
