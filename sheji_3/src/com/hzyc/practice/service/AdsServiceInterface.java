package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.Advertise;

public interface AdsServiceInterface {
	public void insertAds(Advertise ads);//����
	public List<Advertise> selectAds();
	public void deleteAds(Advertise ads);//ɾ��
}
