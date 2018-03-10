package com.hzyc.practice.mappers;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.SimpleCart;
import com.hzyc.practice.models.User;

public interface CartMapper {
	public void insertCart(SimpleCart cart);//插入购物车 
	public Cart selectCartOfUser(User user);//查询
	public Cart selectRealCartOfUser(User user);//查询选中的商品
	public int isHaveGoodOfCart(SimpleCart cart);//判断商品是否已在购物车
	public void cartNumberAdd1(SimpleCart cart);//对应购物车商品+1
	public void cartNumberSub1(SimpleCart cart);//对应购物车商品-1
	public void removreGoodOfCart(SimpleCart cart);//删除对应购物车商品
	public void confirmGoodOfCart(SimpleCart cart);//选中对应的商品
	public void cancelGoodOfCart(SimpleCart cart);//取消选中对应的商品
	public void removreGoodOfCartAfterOrder(Cart cart);//确认订单后，删除购物车中对应商品
}
