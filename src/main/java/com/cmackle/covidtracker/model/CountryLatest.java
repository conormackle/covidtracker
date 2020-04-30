package com.cmackle.covidtracker.model;

public class CountryLatest {
	
	private String confirmed;
	
	private String deaths;
	
	private String recovered;



	public CountryLatest() {
	}


	public CountryLatest(String confirmed, String deaths, String recovered) {
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}


	public String getConfirmed() {
		return confirmed;
	}


	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}


	public String getDeaths() {
		return deaths;
	}


	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}


	public String getRecovered() {
		return recovered;
	}


	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}


	@Override
	public String toString() {
		return "CountryLatest [confirmed=" + confirmed + ", deaths=" + deaths + ", recovered=" + recovered + "]";
	}
	
		

}
