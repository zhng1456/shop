package com.hzyc.practice.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Comment;
import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.GoodAndType;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;
import com.hzyc.practice.service.CommentServiceInterface;
import com.hzyc.practice.service.GoodServiceInterface;
import com.hzyc.practice.service.TypeServiceInterface;
import com.hzyc.practice.tools.DateTools;
import com.hzyc.practice.tools.FileTools;
@Controller
@RequestMapping("GoodController")
public class GoodController {
	@Autowired
	private GoodServiceInterface service;
	@Autowired
	private TypeServiceInterface typeService;
	@Autowired
	private CommentServiceInterface commentService;
	@RequestMapping("InsertGood.do")
	public String insertGood(Good good,MultipartFile file,HttpServletRequest request){
		//产生图片名称
		good.setPictureName(new DateTools().createName(file.getOriginalFilename()));
		//调用service层的方法，参数good匹配
		service.insertGood(good);
		//获取路径
		//request.getSession().getServletContext().
		String path=request.getSession().getServletContext().getRealPath("/pictures");
		//写入文件
		try {
			new FileTools().writeFromInput(file.getInputStream(), path, good.getPictureName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "../admin/success.jsp";
	}
	@RequestMapping("selectAllGood.do")
	public ModelAndView selectAllGood(){
		//查询所有商品
		List<Good> list = service.selectAllGood();
		ModelAndView andView = new ModelAndView();
		andView.addObject("list",list);
		andView.setViewName("../admin/listPro.jsp");
		return andView;
	}
	
	@RequestMapping("editGood.do")
	public ModelAndView selectGoodById(int id){
		Good good = service.selectGoodById(id);
		ModelAndView andView = new ModelAndView();
		List<Type> list = typeService.selectTypeById(new Type());
		//根据id查询到的good
		andView.addObject("good",good);
		//System.out.println(good);
		//所有的种类信息
		andView.addObject("list",list);
		//跳转
		andView.setViewName("../admin/editPro.jsp");
		return andView;
	}
	@RequestMapping("selectGoodByName.do")
	public ModelAndView selectGoodByName(String name){
		ModelAndView andView = new ModelAndView();
		//根据name模糊查询
		List<Good> list;
		try {
			list = service.selectGoodByName(URLDecoder.decode(name, "utf-8"));
			andView.addObject("list",list);
			andView.setViewName("../admin/listPro.jsp");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return andView;
	}
	@RequestMapping("selectGoodByNameForFeatured.do")
	public ModelAndView selectGoodByNameForFeatured(String name){
		ModelAndView andView = new ModelAndView();
		//根据name模糊查询
		List<Good> list;
		try {
			list = service.selectGoodByName(URLDecoder.decode(name, "utf-8"));
			andView.addObject("list",list);
			andView.setViewName("../admin/featured.jsp");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return andView;
	}
	
	@RequestMapping("updateGood.do")
	public String updateGood(Good good,MultipartFile file,HttpServletRequest request){
		service.updateGood(good,file,request);
		return "redirect:selectPageGood.do?currentPage=1";
	}
	@RequestMapping("downGood.do")
	public String downGood(Good good){
		service.downGood(good);
		return "redirect:selectAllGood.do";
	}
	
	@RequestMapping("selectPageGood.do")
	//分页查询
	public ModelAndView selectPageGood(Page page){
		//总记录数
		page.setLength(service.selectAllLength());
		//每页显示5条数据
		page.setPerPage(5);
		page.init();
		List<Good> list=service.selectPageGood(page);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/listPro.jsp");
		andView.addObject("list",list);
		andView.addObject("page",page);
		return andView;
	}
	@RequestMapping("selectPageGoodForFeatured.do")
	//分页查询
	public ModelAndView selectPageGoodForFeatured(Page page){
		//总记录数
		page.setLength(service.selectAllLength());
		//每页显示5条数据
		page.setPerPage(5);
		page.init();
		List<Good> list=service.selectPageGood(page);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/featured.jsp");
		andView.addObject("list",list);
		andView.addObject("page",page);
		return andView;
	}
	//根据类别查找到商品
	//并分页显示
	@RequestMapping("selectGoodByType.do")
	public ModelAndView selectGoodByType(Type type){
		//设置分页的参数
		Page page = type.getPage();
		if(page==null)
			page = new Page();
		//每页显示6条记录
		page.setPerPage(6);
		//设置总记录数
		page.setLength(service.selectGoodByTypeLength(type));
		page.init();
		type.setPage(page);
		//分页查询
		List<Good> gList = service.selectGoodByType(type);
		ModelAndView andView = new ModelAndView();
		//跳转到对应类别的商品显示页面
		andView.setViewName("../front/products.jsp");
		andView.addObject("gList",gList);
		andView.addObject("type",type);
		return andView;
	}
	
	//前台跳转到商品详情页
	@RequestMapping("initDetails.do")
	public ModelAndView initDetails(int id){
		//根据id查到对应的商品信息
		Good good = service.selectGoodById(id);
		ModelAndView andView = new ModelAndView();
		//查找对应的商品评论信息
		List<Comment> cList = commentService.selectCommentByGood(good);
		//传值
		andView.addObject("good", good);
		andView.addObject("cList", cList);
		System.out.println("--------------"+cList);
		//跳转 
		andView.setViewName("../front/details.jsp");
		return andView;
	}
	//设置某个商品为特色商品
	@RequestMapping("setFeatured.do")
	public String setFeatured(Good good){
		//完成update
		service.setGoodFeatured(good);
		return "selectPageGoodForFeatured.do?currentPage=1";
	}
	@RequestMapping("cancelFeatured.do")
	public String cancelFeatured(Good good){
		//完成update
		service.cancelGoodFeatured(good);
		return "selectPageGoodForFeatured.do?currentPage=1";
	}
	@RequestMapping("selectGoodByNameAndType.do")
	public ModelAndView selectGoodByNameAndType(GoodAndType gat){
		List<Good> gList = service.selectGoodByNameAndType(gat);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../front/products.jsp");
		andView.addObject("gList",gList);
		return andView;
	}
}
