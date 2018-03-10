package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.Order;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.SaleInfo;
import com.hzyc.practice.models.TimeInfo;

public interface OrderMapper {
	public void insertOrder(Cart cart);//插入订单
	public void insertOrderDetail(Cart cart);//插入订单详情
	public int selectMaxOrderId();
	public void payOrder(int id);
	public List<Order> selectAllOrderAndUser(Page page);//查询订单
	public List<SaleInfo> selectSalesByYear(int year);//查询该年每月销售额
	public List<Order> selectOrderByTime(TimeInfo info);//按时间查询
}
