package com.hzyc.practice.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Advertise;
import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.Province;
import com.hzyc.practice.models.Type;
import com.hzyc.practice.service.AdsServiceInterface;
import com.hzyc.practice.service.GoodServiceInterface;
import com.hzyc.practice.service.ProvinceServiceInterface;
import com.hzyc.practice.service.TypeServiceInterface;

@Controller
@RequestMapping("InitController")
public class InitController {
	@Autowired
	private ProvinceServiceInterface service;
	@Autowired
	private TypeServiceInterface typeService;
	@Autowired
	private GoodServiceInterface goodService;
	@Autowired
	private AdsServiceInterface AdsService;
	@RequestMapping("initRegister.do")
	public ModelAndView initRegister(){
		//��ѯ��ʡ��
		List<Province> pList =service.selectAllProvince();
		//��ֵ
		ModelAndView andView= new ModelAndView();
		andView.addObject("pList", pList);
		andView.setViewName("../front/register.jsp");
		return andView;
	}
	@RequestMapping("initIndex.do")
	//��ѯ��ʼ����,��index.jsp��ʾ
	public ModelAndView initIndex(HttpSession session){
		//��ѯ�����е������Ϣ
		List<Type> tList = typeService.selectTypeById(new Type());
		//��ѯ���µ���Ʒ
		List<Good> gList = goodService.selectLatestGood();
		//��ѯ��ɫ����Ʒ
		List<Good> fList = goodService.selectFeaturedGood();
		//��ѯ�����Ĺ��ͼƬ
		List<Advertise> aList = AdsService.selectAds();
		ModelAndView andView = new ModelAndView();
		andView.addObject("tList", tList);
		andView.addObject("gList", gList);
		andView.addObject("fList", fList);
		andView.addObject("fListSize", fList.size());
		andView.addObject("aList", aList);
		//�������Ϣ����session�У����ڲ��������ʾ
		session.setAttribute("tList",tList);
		andView.setViewName("../front/index.jsp");
		return andView;
	}
}
