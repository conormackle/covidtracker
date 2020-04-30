package com.cmackle.covidtracker.service;

import java.util.List;

public interface EntityService {
	
	public List<Object> findAll();
	
	public Object findById(int theId);
	
	public void save(Object Object);
	
	public void deleteById(int Id);

}
