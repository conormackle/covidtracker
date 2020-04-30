package com.cmackle.covidtracker.mapper;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cmackle.covidtracker.model.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CountryMapper implements CustomObjectMapper{
	
	public CountryMapper() {
		
	}
	
	public void map(Object obj, String url) {
		
		try {
			if(obj instanceof Country) {
			Country country = (Country) obj;
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			// create map object for json response
			Map<String, Object> map
			= objectMapper.readValue(new URL(url), new TypeReference<Map<String,Object>>(){});
			
						
			// get 'latest' properties from json response
			Map<String, Object> latest = (Map<String, Object>) map.get("latest");
			
			// get 'locations' properties from json response
			List<Object> locations = (List<Object>) map.get("locations");
			
			// finding the country as whole without province specific info
			Map<String, Object> countryInformation = getCountryWithoutProvinceProperty(locations);	

			
			MapCountryDetails mapCountryDetails = new MapCountryDetails();
			MapCountryLatest mapCountryLatest = new MapCountryLatest();
			MapCountryTimelines mapCountryTimelines = new MapCountryTimelines();
			
			
			// mapping country details and country info
			mapCountryLatest.mappingCountryLatest(country, latest);
			mapCountryDetails.mappingCountryDetails(country, countryInformation);
					
			mapCountryTimelines.mappingCountryTimelines(country, countryInformation, country.getCountryDetails().getId(), objectMapper);
		
			}
		}catch(IllegalArgumentException exc) {
			System.out.println("Object is not a Country - " + exc.getMessage());
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}
	
	public Map<String, Object> getCountryWithoutProvinceProperty(List<Object> locations) throws Exception {
		
		Map<String, Object> countryDetails = null;
		
		for(Object tempLocation : locations) {
			
						
			if(((Map<String, Object>) tempLocation).get("province") == "") {
				
				countryDetails = (Map<String, Object>) tempLocation;
				
				break;
			}
			
		}
		
		if(countryDetails == null) {
			throw new Exception("No location has a province as ''");
		}
		
		return countryDetails;
				
	}



	
	

}
