package com.hzyc.practice.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;
import com.hzyc.practice.service.UserServiceInterface;

@Controller
@RequestMapping("UserController")
public class UserController {
	@Autowired
	private UserServiceInterface service;
	@RequestMapping("insertUser.do")
	public String insertUser(User user){
		service.insertUser(user);
		return "../InitController/initIndex.do";
	}
	@RequestMapping("login.do")
	public ModelAndView selectAllUser(HttpServletRequest request,HttpSession session){
		//��ֵ
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//��ѯ���ݿ�
		List<User> list =service.selectAllUser();
		ModelAndView andView = new ModelAndView();
		boolean flag = false;
		//�Ƚ�
		for(int i=0;i<list.size();++i){
			User temp = list.get(i);
			if(temp.getUsername().equals(userName)&&temp.getPassword().equals(password)){
				//temp�е���Ϣȫ���ʽ�temp����session��������ʾ
				session.setAttribute("user",temp);
				//�ҵ����û����ջ���ַ
				Address address = service.selectAddressOfUser(temp);
				session.setAttribute("address", address);
				//������ҳ��
				andView.setViewName("../InitController/initIndex.do");
				flag=true;
				break;
			}
		}
		//û�ҵ���Ӧ���û�
		if(!flag){
			andView.setViewName("error.jsp");
		}
		return andView;
	}
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "../InitController/initIndex.do";
	}
}
