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
		//����ͼƬ����
		good.setPictureName(new DateTools().createName(file.getOriginalFilename()));
		//����service��ķ���������goodƥ��
		service.insertGood(good);
		//��ȡ·��
		//request.getSession().getServletContext().
		String path=request.getSession().getServletContext().getRealPath("/pictures");
		//д���ļ�
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
		//��ѯ������Ʒ
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
		//����id��ѯ����good
		andView.addObject("good",good);
		//System.out.println(good);
		//���е�������Ϣ
		andView.addObject("list",list);
		//��ת
		andView.setViewName("../admin/editPro.jsp");
		return andView;
	}
	@RequestMapping("selectGoodByName.do")
	public ModelAndView selectGoodByName(String name){
		ModelAndView andView = new ModelAndView();
		//����nameģ����ѯ
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
		//����nameģ����ѯ
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
	//��ҳ��ѯ
	public ModelAndView selectPageGood(Page page){
		//�ܼ�¼��
		page.setLength(service.selectAllLength());
		//ÿҳ��ʾ5������
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
	//��ҳ��ѯ
	public ModelAndView selectPageGoodForFeatured(Page page){
		//�ܼ�¼��
		page.setLength(service.selectAllLength());
		//ÿҳ��ʾ5������
		page.setPerPage(5);
		page.init();
		List<Good> list=service.selectPageGood(page);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("../admin/featured.jsp");
		andView.addObject("list",list);
		andView.addObject("page",page);
		return andView;
	}
	//���������ҵ���Ʒ
	//����ҳ��ʾ
	@RequestMapping("selectGoodByType.do")
	public ModelAndView selectGoodByType(Type type){
		//���÷�ҳ�Ĳ���
		Page page = type.getPage();
		if(page==null)
			page = new Page();
		//ÿҳ��ʾ6����¼
		page.setPerPage(6);
		//�����ܼ�¼��
		page.setLength(service.selectGoodByTypeLength(type));
		page.init();
		type.setPage(page);
		//��ҳ��ѯ
		List<Good> gList = service.selectGoodByType(type);
		ModelAndView andView = new ModelAndView();
		//��ת����Ӧ������Ʒ��ʾҳ��
		andView.setViewName("../front/products.jsp");
		andView.addObject("gList",gList);
		andView.addObject("type",type);
		return andView;
	}
	
	//ǰ̨��ת����Ʒ����ҳ
	@RequestMapping("initDetails.do")
	public ModelAndView initDetails(int id){
		//����id�鵽��Ӧ����Ʒ��Ϣ
		Good good = service.selectGoodById(id);
		ModelAndView andView = new ModelAndView();
		//���Ҷ�Ӧ����Ʒ������Ϣ
		List<Comment> cList = commentService.selectCommentByGood(good);
		//��ֵ
		andView.addObject("good", good);
		andView.addObject("cList", cList);
		System.out.println("--------------"+cList);
		//��ת 
		andView.setViewName("../front/details.jsp");
		return andView;
	}
	//����ĳ����ƷΪ��ɫ��Ʒ
	@RequestMapping("setFeatured.do")
	public String setFeatured(Good good){
		//���update
		service.setGoodFeatured(good);
		return "selectPageGoodForFeatured.do?currentPage=1";
	}
	@RequestMapping("cancelFeatured.do")
	public String cancelFeatured(Good good){
		//���update
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
