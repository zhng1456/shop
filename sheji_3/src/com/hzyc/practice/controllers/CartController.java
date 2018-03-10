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
		//��������cart����userId��goodId����Ϣ,cartNumberĬ��Ϊ1
		//��Ҫ���жϣ����ﳵ���Ƿ������˴���Ʒ
		int flag = 0;
		if(service.isHaveGoodOfCart(cart)>0){
			flag=1;
		}
		//�У�������+1
		if(flag>0){
			service.cartNumberAdd1(cart);
		}
		else{
		//û�������
		service.insertCart(cart);
		}
		//��ֵ
		ModelAndView andView = new ModelAndView();
		
		
		//��ת
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("goodOfCartSub1.do")
	public ModelAndView goodOfCartSub1(SimpleCart cart){
		//���ﳵ��Ӧ��Ʒ-1
		service.cartNumberSub1(cart);
		//��ֵ
		ModelAndView andView = new ModelAndView();		
		//��ת
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("deleteGoodOfCart.do")
	public String deleteGoodOfCart(SimpleCart cart){
		service.removreGoodOfCart(cart);
		//��ֵ
				//ModelAndView andView = new ModelAndView();		
				//��ת
				//andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
				return "selectCartOfUser.do?id="+cart.getUserId();
	}
	@RequestMapping("confirmGoodOfCart.do")
	public ModelAndView confirmGoodOfCart(SimpleCart cart){
		service.confirmGoodOfCart(cart);
		ModelAndView andView = new ModelAndView();		
		//��ת
		andView.setViewName("selectCartOfUser.do?id="+cart.getUserId());
		return andView;
	}
	@RequestMapping("cancelGoodOfCart.do")
	public ModelAndView cancelGoodOfCart(SimpleCart cart){
		service.cancelGoodOfCart(cart);
		ModelAndView andView = new ModelAndView();		
		//��ת
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
		//��ֵ
		andView.addObject("cart", cart);
		//��ת
		andView.setViewName("../front/cart.jsp");
		return andView;
	}
	@RequestMapping("selectRealCartOfUser.do")
	public ModelAndView selectRealCartOfUser(User user){
		Cart cart = service.selectRealCartOfUser(user);
		cart.init();
		ModelAndView andView = new ModelAndView();
		//��ֵ
		andView.addObject("cart", cart);
		//��ת
		andView.setViewName("../front/order.jsp");
		return andView;
	}
}
