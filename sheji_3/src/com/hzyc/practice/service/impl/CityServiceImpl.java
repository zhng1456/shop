package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.CityMapper;
import com.hzyc.practice.models.City;
import com.hzyc.practice.models.Province;
import com.hzyc.practice.service.CityServiceInterface;
@Service
public class CityServiceImpl implements CityServiceInterface {
	@Autowired
	private CityMapper mapper;
	public List<City> selectCityByPId(Province p) {
		// TODO Auto-generated method stub
		return mapper.selectCityByPId(p);
	}

}
