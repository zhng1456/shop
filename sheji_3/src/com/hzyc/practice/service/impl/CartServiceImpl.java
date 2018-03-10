package com.hzyc.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.CartMapper;
import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.SimpleCart;
import com.hzyc.practice.models.User;
import com.hzyc.practice.service.CartServiceInterface;
@Service
public class CartServiceImpl implements CartServiceInterface {
	@Autowired
	private CartMapper mapper;
	public void insertCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.insertCart(cart);
	}
	public Cart selectCartOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectCartOfUser(user);
	}
	public int isHaveGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		return mapper.isHaveGoodOfCart(cart);
	}
	public void cartNumberAdd1(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cartNumberAdd1(cart);
	}
	public void cartNumberSub1(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cartNumberSub1(cart);
	}
	public void removreGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.removreGoodOfCart(cart);
	}
	public void confirmGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.confirmGoodOfCart(cart);
	}
	public void cancelGoodOfCart(SimpleCart cart) {
		// TODO Auto-generated method stub
		mapper.cancelGoodOfCart(cart);
	}
	public Cart selectRealCartOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectRealCartOfUser(user);
	}
	public void removreGoodOfCartAfterOrder(Cart cart) {
		// TODO Auto-generated method stub
		mapper.removreGoodOfCartAfterOrder(cart);
	}
}
