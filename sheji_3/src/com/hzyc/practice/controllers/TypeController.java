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
	//获取所有类别，并传到listType.jsp
	public ModelAndView selectTypeById(Type type){
		List<Type> list=typeService.selectTypeById(type);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listType_1.jsp");
		andView.addObject("list",list);
		return andView;
	}
	@RequestMapping("selectPageType.do")
	//分页查询
	public ModelAndView selectPageType(Page page){
		//id为空,用来获取总记录数
		List<Type> info = typeService.selectTypeById(new Type());
		//总记录数
		page.setLength(info.size());
		//每页显示4条数据
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
	//在listType页面点击修改后进入这里,根据id找到相应的type，传给editType.jsp
	public ModelAndView editType(Type type){
		System.out.println("editType-----------"+type);
		//根据id获取整个type的信息
		List<Type> list=typeService.selectTypeById(type);
		System.out.println("取到的信息为"+list);
		ModelAndView andView = new ModelAndView();
		andView.addObject("type",list.get(0));
		andView.setViewName("../admin/editType.jsp");
		return andView;
	}
	@RequestMapping("updateType.do")
	//修改商品类别，执行完后跳向selectAllType.do，显示修改后的结果
	public String updateType(Type type){
		typeService.updateType(type);
		return "redirect:selectPageType.do?currentPage=1";
	}
	@RequestMapping("deleteType.do")
	public String deleteType(HttpServletRequest request){
		String id=request.getParameter("id");
		Type type=new Type();
		type.setId(Integer.parseInt(id));
		//删除
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
	//查询出所有类别，传给商品添加页面
	public ModelAndView PrepareForGood(Type type){
		//id为空,用来获取所有类别
		List<Type> info = typeService.selectTypeById(new Type());
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", info);
		andView.setViewName("../admin/addPro.jsp");
		return andView;
	}
}
