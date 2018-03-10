package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.AdsMapper;
import com.hzyc.practice.models.Advertise;
import com.hzyc.practice.service.AdsServiceInterface;
@Service
public class AdsServiceImpl implements AdsServiceInterface{
	@Autowired
	private AdsMapper mapper;
	public void insertAds(Advertise ads) {
		// TODO Auto-generated method stub
		mapper.insertAds(ads);
	}

	public List<Advertise> selectAds() {
		// TODO Auto-generated method stub
		return mapper.selectAds();
	}

	public void deleteAds(Advertise ads) {
		// TODO Auto-generated method stub
		mapper.deleteAds(ads);
	}

}
