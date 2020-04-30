package com.cmackle.covidtracker.mapper;

import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cmackle.covidtracker.model.Country;
import com.cmackle.covidtracker.model.CountryTimelines;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapCountryTimelines {
	
	
	public void mappingCountryTimelines(Country country, Map<String, Object> map,
										int countryId, ObjectMapper objectMapper) {
		
		CountryTimelines countryTimelines = new CountryTimelines();
		
		String url = "https://coronavirus-tracker-api.herokuapp.com/v2/locations/" + countryId;
		
		try {
			
			Map<String, Object> timelineMap
			= objectMapper.readValue(new URL(url), new TypeReference<Map<String,Object>>(){});
			
			
					
			Map<String, Object> allCountryTimelinesFromJson = (Map<String, Object>) ((Map<String, Object>) timelineMap.get("location")).get("timelines");
			
			
			countryTimelines.setCountryConfirmed((Map<String, Object>) ((Map<String, Object>) allCountryTimelinesFromJson.get("confirmed")).get("timeline")); 
			countryTimelines.setCountryDeaths((Map<String, Object>) ((Map<String, Object>) allCountryTimelinesFromJson.get("deaths")).get("timeline"));
			countryTimelines.setCountryRecovered((Map<String, Object>) ((Map<String, Object>) allCountryTimelinesFromJson.get("recovered")).get("timeline"));
			
						
			country.setCountryTimelines(countryTimelines);
			
		}catch(Exception exc) {
			
			exc.printStackTrace();
			
		}

		
		
	}
	

}
