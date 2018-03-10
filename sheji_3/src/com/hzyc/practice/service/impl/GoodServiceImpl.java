package com.hzyc.practice.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hzyc.practice.mappers.GoodMapper;
import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.GoodAndType;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;
import com.hzyc.practice.service.GoodServiceInterface;
import com.hzyc.practice.tools.DateTools;
import com.hzyc.practice.tools.FileTools;
//����Ʒ�йص�ҵ��
@Service
public class GoodServiceImpl implements GoodServiceInterface{
	@Autowired
private GoodMapper goodMapper;
	//������Ʒ
public int insertGood(Good good) {
	
	return goodMapper.insertGood(good);
}
public List<Good> selectAllGood() {
	// TODO Auto-generated method stub
	return goodMapper.selectAllGood();
}
public Good selectGoodById(int id) {
	// TODO Auto-generated method stub
	return goodMapper.selectGoodById(id);
}
public List<Good> selectGoodByName(String name) {
	// TODO Auto-generated method stub
	return goodMapper.selectGoodByName(name);
}
//������Ʒ��Ϣ
public void updateGood(Good good,MultipartFile file,HttpServletRequest request) {
	// TODO Auto-generated method stub
	//�ļ��ϴ�,���ж��Ƿ�ѡ�����µ�ͼƬ
	//��ѡ�����µ�ͼƬ���򽫽�ԭͼƬɾ������д����ͼƬ
	if(!file.getOriginalFilename().equals("")){
	//��ȡ·��
	String path=request.getSession().getServletContext().getRealPath("/pictures");
	
	//д���ļ�
			try {
				//ɾ��Դ�ļ�
				File src = new File(path+File.separator+good.getPictureName());
				src.delete();
				//�����µ�ͼƬ����
				good.setPictureName(new DateTools().createName(good.getPictureName()));
				new FileTools().writeFromInput(file.getInputStream(), path, good.getPictureName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
			goodMapper.updateGood(good);
}
public void downGood(Good good) {
	// TODO Auto-generated method stub
	goodMapper.downGood(good);
}
public List<Good> selectPageGood(Page page) {
	// TODO Auto-generated method stub
	return goodMapper.selectPageGood(page);
}
public int selectAllLength() {
	// TODO Auto-generated method stub
	return goodMapper.selectAllLength();
}
public List<Good> selectGoodByType(Type type) {
	// TODO Auto-generated method stub
	return goodMapper.selectGoodByType(type);
}
public int selectGoodByTypeLength(Type type) {
	// TODO Auto-generated method stub
	return goodMapper.selectGoodByTypeLength(type);
}
public List<Good> selectLatestGood() {
	// TODO Auto-generated method stub
	return goodMapper.selectLatestGood();
}
public List<Good> selectFeaturedGood() {
	// TODO Auto-generated method stub
	return goodMapper.selectFeaturedGood();
}
public void setGoodFeatured(Good good) {
	// TODO Auto-generated method stub
	goodMapper.setGoodFeatured(good);
}
public void cancelGoodFeatured(Good good) {
	// TODO Auto-generated method stub
	goodMapper.cancelGoodFeatured(good);
}
public List<Good> selectGoodByNameAndType(GoodAndType gat) {
	// TODO Auto-generated method stub
	return goodMapper.selectGoodByNameAndType(gat);
}
}
