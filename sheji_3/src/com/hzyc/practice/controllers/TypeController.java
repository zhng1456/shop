package com.hzyc.practice.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;
import com.hzyc.practice.service.TypeServiceInterface;
@Controller
@RequestMapping("TypeController")
public class TypeController {
	@Autowired
	private TypeServiceInterface typeService;
	@RequestMapping("addType.do")
	public String addType(Type type){
		typeService.addType(type);
		return "../admin/success.jsp";
	}
	@RequestMapping("selectTypeById.do")
	//��ȡ������𣬲�����listType.jsp
	public ModelAndView selectTypeById(Type type){
		List<Type> list=typeService.selectTypeById(type);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listType_1.jsp");
		andView.addObject("list",list);
		return andView;
	}
	@RequestMapping("selectPageType.do")
	//��ҳ��ѯ
	public ModelAndView selectPageType(Page page){
		//idΪ��,������ȡ�ܼ�¼��
		List<Type> info = typeService.selectTypeById(new Type());
		//�ܼ�¼��
		page.setLength(info.size());
		//ÿҳ��ʾ4������
		page.setPerPage(4);
		page.init();
		List<Type> list=typeService.selectPageType(page);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listType_1.jsp");
		andView.addObject("list",list);
		andView.addObject("page",page);
		return andView;
	}
	@RequestMapping("editType.do")
	//��listTypeҳ�����޸ĺ��������,����id�ҵ���Ӧ��type������editType.jsp
	public ModelAndView editType(Type type){
		System.out.println("editType-----------"+type);
		//����id��ȡ����type����Ϣ
		List<Type> list=typeService.selectTypeById(type);
		System.out.println("ȡ������ϢΪ"+list);
		ModelAndView andView = new ModelAndView();
		andView.addObject("type",list.get(0));
		andView.setViewName("../admin/editType.jsp");
		return andView;
	}
	@RequestMapping("updateType.do")
	//�޸���Ʒ���ִ���������selectAllType.do����ʾ�޸ĺ�Ľ��
	public String updateType(Type type){
		typeService.updateType(type);
		return "redirect:selectPageType.do?currentPage=1";
	}
	@RequestMapping("deleteType.do")
	public String deleteType(HttpServletRequest request){
		String id=request.getParameter("id");
		Type type=new Type();
		type.setId(Integer.parseInt(id));
		//ɾ��
		typeService.deleteType(type);
		return "redirect:selectPageType.do?currentPage=1";
	}
	@RequestMapping("deleteMulType.do")
	public String deleteMulType(String[] typeId){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<typeId.length;++i){
			list.add(Integer.parseInt(typeId[i]));
		}
		typeService.deleteMulType(list);
		return "redirect:selectPageType.do?currentPage=1";
	}
	
	@RequestMapping("PrepareForGood.do")
	//��ѯ��������𣬴�����Ʒ���ҳ��
	public ModelAndView PrepareForGood(Type type){
		//idΪ��,������ȡ�������
		List<Type> info = typeService.selectTypeById(new Type());
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", info);
		andView.setViewName("../admin/addPro.jsp");
		return andView;
	}
}
