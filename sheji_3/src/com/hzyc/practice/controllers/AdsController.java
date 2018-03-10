package com.hzyc.practice.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Advertise;
import com.hzyc.practice.service.AdsServiceInterface;
import com.hzyc.practice.tools.DateTools;

@Controller
@RequestMapping("AdsController")
public class AdsController {
	@Autowired
	private AdsServiceInterface service;
	@RequestMapping("insertAds.do")
	public String insertAds(MultipartFile file,HttpServletRequest request){
		//获取上传图片的路径
		String path=request.getSession().getServletContext().getRealPath("/pictures");
		
		//插入数据库
		Advertise ads = new Advertise();
		//根据当前时间产生图片名称
		ads.setName(new DateTools().createName(file.getOriginalFilename()));
		service.insertAds(ads);
		//上传文件
				try {
					file.transferTo(new File(path+File.separator+ads.getName()));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return "../admin/success.jsp";
	}
	@RequestMapping("selectAds.do")
	public ModelAndView selectAds(){
		List<Advertise> aList = service.selectAds();
		ModelAndView andView = new ModelAndView();
		andView.addObject("aList", aList);
		andView.setViewName("../admin/topAds.jsp");
		return andView;
	}
	@RequestMapping("deleteAds.do")
	public String deleteAds(Advertise ads){
		service.deleteAds(ads);
		return "selectAds.do";
	}
}
