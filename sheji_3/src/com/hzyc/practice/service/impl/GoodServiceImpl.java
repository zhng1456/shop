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
//与商品有关的业务
@Service
public class GoodServiceImpl implements GoodServiceInterface{
	@Autowired
private GoodMapper goodMapper;
	//插入商品
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
//更新商品信息
public void updateGood(Good good,MultipartFile file,HttpServletRequest request) {
	// TODO Auto-generated method stub
	//文件上传,先判断是否选择了新的图片
	//若选择了新的图片，则将将原图片删除，再写入新图片
	if(!file.getOriginalFilename().equals("")){
	//获取路径
	String path=request.getSession().getServletContext().getRealPath("/pictures");
	
	//写入文件
			try {
				//删除源文件
				File src = new File(path+File.separator+good.getPictureName());
				src.delete();
				//产生新的图片名称
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
