package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.Order;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.SaleInfo;
import com.hzyc.practice.models.TimeInfo;

public interface OrderMapper {
	public void insertOrder(Cart cart);//���붩��
	public void insertOrderDetail(Cart cart);//���붩������
	public int selectMaxOrderId();
	public void payOrder(int id);
	public List<Order> selectAllOrderAndUser(Page page);//��ѯ����
	public List<SaleInfo> selectSalesByYear(int year);//��ѯ����ÿ�����۶�
	public List<Order> selectOrderByTime(TimeInfo info);//��ʱ���ѯ
}
