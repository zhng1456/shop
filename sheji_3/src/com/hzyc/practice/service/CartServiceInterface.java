package com.hzyc.practice.service;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.SimpleCart;
import com.hzyc.practice.models.User;

public interface CartServiceInterface {
	public void insertCart(SimpleCart cart);
	public Cart selectCartOfUser(User user);
	public Cart selectRealCartOfUser(User user);//��ѯѡ�е���Ʒ
	public int isHaveGoodOfCart(SimpleCart cart);//�ж���Ʒ�Ƿ����ڹ��ﳵ
	public void cartNumberAdd1(SimpleCart cart);//+1
	public void cartNumberSub1(SimpleCart cart);//��Ӧ���ﳵ��Ʒ-1
	public void removreGoodOfCart(SimpleCart cart);//ɾ����Ӧ���ﳵ��Ʒ
	public void confirmGoodOfCart(SimpleCart cart);//ѡ�ж�Ӧ����Ʒ
	public void cancelGoodOfCart(SimpleCart cart);//ȡ��ѡ�ж�Ӧ����Ʒ
	public void removreGoodOfCartAfterOrder(Cart cart);//ȷ�϶�����ɾ�����ﳵ�ж�Ӧ��Ʒ
}

