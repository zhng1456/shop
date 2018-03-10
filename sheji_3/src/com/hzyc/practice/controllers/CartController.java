package com.hzyc.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.SimpleCart;
import com.hzyc.practice.models.User;
import com.hzyc.practice.service.CartServiceInterface;

@Controller
@RequestMapping("CartController")
public class CartController {
	@Autowired
	private CartServiceInterface service;
	@RequestMapping("insertCart.do")
	public ModelAndView insertCart(SimpleCart cart){
		//传过来的cart包含userId，goodId的信息,cartNumber默认为1
		//需要先判断，购物车内是否已有了此商品
		int flag = 0;
		if(service.isHaveGoodOfCart(cart)>0){
			flag=1;
		}
		//有，则数量+1
		if(flag>0){
			service.cartNumberAdd1(cart);
		}
		else{
		//没有则插入
		service.insertCart(cart);
		}
		//传值
		ModelAndView andView = new ModelAndView();
		
		
		//跳转
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("goodOfCartSub1.do")
	public ModelAndView goodOfCartSub1(SimpleCart cart){
		//购物车对应商品-1
		service.cartNumberSub1(cart);
		//传值
		ModelAndView andView = new ModelAndView();		
		//跳转
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("deleteGoodOfCart.do")
	public String deleteGoodOfCart(SimpleCart cart){
		service.removreGoodOfCart(cart);
		//传值
				//ModelAndView andView = new ModelAndView();		
				//跳转
				//andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
				return "selectCartOfUser.do?id="+cart.getUserId();
	}
	@RequestMapping("confirmGoodOfCart.do")
	public ModelAndView confirmGoodOfCart(SimpleCart cart){
		service.confirmGoodOfCart(cart);
		ModelAndView andView = new ModelAndView();		
		//跳转
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("cancelGoodOfCart.do")
	public ModelAndView cancelGoodOfCart(SimpleCart cart){
		service.cancelGoodOfCart(cart);
		ModelAndView andView = new ModelAndView();		
		//跳转
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("selectCartOfUser.do")
	public ModelAndView selectCartOfUser(User user){
		Cart cart = service.selectCartOfUser(user);
		System.out.println(user);
		System.out.println(cart);
		cart.init();
		ModelAndView andView = new ModelAndView();
		//传值
		andView.addObject("cart", cart);
		//跳转
		andView.setViewName("../front/cart.jsp");
		return andView;
	}
	@RequestMapping("selectRealCartOfUser.do")
	public ModelAndView selectRealCartOfUser(User user){
		Cart cart = service.selectRealCartOfUser(user);
		cart.init();
		ModelAndView andView = new ModelAndView();
		//传值
		andView.addObject("cart", cart);
		//跳转
		andView.setViewName("../front/order.jsp");
		return andView;
	}
}
