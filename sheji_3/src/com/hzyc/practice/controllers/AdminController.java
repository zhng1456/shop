package com.hzyc.practice.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Admin;
import com.hzyc.practice.service.AdminServiceInterface;

@Controller
@RequestMapping("AdminController")
public class AdminController {
	@Autowired
	private AdminServiceInterface service;
	@RequestMapping("addAdmin.do")
	public String addAdmin(Admin admin){
		service.addAdmin(admin);
		return "../admin/success.jsp";
	}
	
	@RequestMapping("selectAdmin.do")
	//��ȡ������𣬲�����listType.jsp
	public ModelAndView selectAllType(Admin admin){
		List<Admin> list = service.selectAdmin(admin);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listAdmin.jsp");
		andView.addObject("list",list);
		return andView;
	}
	@RequestMapping("editAdmin.do")
	//��listTypeҳ�����޸ĺ��������,����id�ҵ���Ӧ��type������editType.jsp
	public ModelAndView editType(HttpServletRequest request){
		System.out.println("edit---------------------");
		String id=request.getParameter("id");
		System.out.println("id---------------"+id);
		Admin admin=new Admin();
		admin.setId(Integer.parseInt(id));
		//����id��ȡ����type����Ϣ
		List<Admin> list=service.selectAdmin(admin);
		ModelAndView andView = new ModelAndView();
		andView.addObject("admin",list.get(0));
		andView.setViewName("../admin/editAdmin.jsp");
		return andView;
	}
	@RequestMapping("updateAdmin.do")
	//�޸���Ʒ���ִ���������selectAdmin.do����ʾ�޸ĺ�Ľ��
	public String updateAdmin(Admin admin){
		service.updateAdmin(admin);
		return "redirect:selectAdmin.do";
	}
	@RequestMapping("deleteAdmin.do")
	public String deleteType(HttpServletRequest request){
		String id=request.getParameter("id");
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		//ɾ��
		service.deleteAdmin(admin);
		return "redirect:selectAdmin.do";
	}
}
