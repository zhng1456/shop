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
		//根据传过来的userId找到cart
		Cart cart = cartService.selectRealCartOfUser(user);
		cart.init();
		//插入order表
		service.insertOrder(cart);
		cart.setOrderId(service.selectMaxOrderId());
		//插入对应的详情表
		service.insertOrderDetail(cart);
		//删除购物车中已提交订单的商品
		cartService.removreGoodOfCartAfterOrder(cart);
		//跳转
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
		//设置分页
		page.setLength(list.size());
		//每页显示5条数据
		page.setPerPage(5);
		page.init();
		list = service.selectAllOrderAndUser(page);
		ModelAndView andView = new ModelAndView();
		andView.addObject("list", list);
		andView.addObject("page",page);
		//跳转
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
		//跳转
		andView.setViewName("../admin/order.jsp");
		return andView;
	}
}
