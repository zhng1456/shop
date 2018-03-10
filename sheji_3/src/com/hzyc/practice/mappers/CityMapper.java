package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.City;
import com.hzyc.practice.models.Province;

public interface CityMapper {
	public List<City> selectCityByPId(Province p);
}
