package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.City;
import com.hzyc.practice.models.Province;

public interface CityServiceInterface {
	public List<City> selectCityByPId(Province p);//����ʡ�ݲ��ҳ���
}
