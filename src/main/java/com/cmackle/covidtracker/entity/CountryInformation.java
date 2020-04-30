package com.cmackle.covidtracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_countries")
public class CountryInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CountryID")
	private String id;
	
	@Column(name="CountryName")
	private String countryName;

	@Column(name="twoCharCountryCode")
	private String twoCharCode;

	public CountryInformation() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTwoCharCode() {
		return twoCharCode;
	}

	public void setTwoCharCode(String twoCharCode) {
		this.twoCharCode = twoCharCode;
	}
	
	

}
