package com.techelevator.city.dao;

import com.techelevator.city.model.City;

import java.util.List;

public interface CityDAO {

	public void create(City newCity);
	public City findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district, String countrycode);
	public void update(City city);
	public void delete(long id);
}
