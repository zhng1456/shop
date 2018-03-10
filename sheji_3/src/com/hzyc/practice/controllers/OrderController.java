package com.hzyc.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.Order;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.SaleInfo;
import com.hzyc.practice.models.TimeInfo;
import com.hzyc.practice.models.User;
import com.hzyc.practice.service.CartServiceInterface;
import com.hzyc.practice.service.OrderServiceInterface;

@Controller
@RequestMapping("OrderController")
public class OrderController {
	@Autowired
	private OrderServiceInterface service;
	@Autowired
	private CartServiceInterface cartService;
	@RequestMapping("insertOrderAndDetail.do")
	public ModelAndView insertOrderAndDetail(User user){
		//���ݴ�������userId�ҵ�cart
		Cart cart = cartService.selectRealCartOfUser(user);
		cart.init();
		//����order��
		service.insertOrder(cart);
		cart.setOrderId(service.selectMaxOrderId());
		//�����Ӧ�������
		service.insertOrderDetail(cart);
		//ɾ�����ﳵ�����ύ��������Ʒ
		cartService.removreGoodOfCartAfterOrder(cart);
		//��ת
		ModelAndView andView = new ModelAndView();
		andView.addObject("cart", cart);
		andView.setViewName("../front/pay.jsp");
		return andView;
	}
	@RequestMapping("payOrder.do")
	public String payOrder(int id){
		service.payOrder(id);
		return "../front/success.jsp";
	}
	@RequestMapping("selectAllOrder.do")
	public ModelAndView selectAllOrder(Page page){
		List<Order> list = service.selectAllOrderAndUser(page);
		//���÷�ҳ
		page.setLength(list.size());
		//ÿҳ��ʾ5������
		page.setPerPage(5);
		page.init();
		list = service.selectAllOrderAndUser(page);
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", list);
		andView.addObject("page",page);
		//��ת
		andView.setViewName("../admin/order.jsp");
		return andView;
	}
	@RequestMapping("selectSalesByYear.do")
	public ModelAndView selectSalesByYear(int year){
		List<SaleInfo> list = service.selectSalesByYear(year);
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", list);
		andView.setViewName("../admin/sales.jsp");
		return andView;
	}
	@RequestMapping("selectOrderByTime.do")
	public ModelAndView selectOrderByTime(TimeInfo info){
		List<Order> list = service.selectOrderByTime(info);
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", list);
		//��ת
		andView.setViewName("../admin/order.jsp");
		return andView;
	}
}
