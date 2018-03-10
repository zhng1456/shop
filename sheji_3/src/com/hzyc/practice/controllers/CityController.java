package com.hzyc.practice.controllers;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hzyc.practice.models.City;
import com.hzyc.practice.models.Province;
import com.hzyc.practice.service.CityServiceInterface;
@Controller
@RequestMapping("CityController")
public class CityController {
	@Autowired
	private CityServiceInterface service;
	@RequestMapping("selectCityByPId.do")
	public void selectCityByPId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		Province p = new Province();
		p.setId(Integer.parseInt(id));
		//��ѯ��Ӧ��city
		List<City> cList = service.selectCityByPId(p);
		//ת����json
		Gson json = new Gson();
		String jsonValue = json.toJson(cList);
		//����
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonValue);
		out.flush();
		out.close();
		
	}
}
