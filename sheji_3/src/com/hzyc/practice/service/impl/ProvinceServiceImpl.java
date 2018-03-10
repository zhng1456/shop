package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.ProvinceMapper;
import com.hzyc.practice.models.Province;
import com.hzyc.practice.service.ProvinceServiceInterface;
@Service
public class ProvinceServiceImpl implements ProvinceServiceInterface {
	@Autowired
	ProvinceMapper mapper;
	public List<Province> selectAllProvince() {
		// TODO Auto-generated method stub
		return mapper.selectAllProvince();
	}

}
