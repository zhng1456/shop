package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Advertise;

public interface AdsMapper {
	public void insertAds(Advertise ads);//����
	public List<Advertise> selectAds();
	public void deleteAds(Advertise ads);//ɾ��
}
