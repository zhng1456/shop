package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.OrderMapper;
import com.hzyc.practice.models.Cart;
import com.hzyc.practice.models.Order;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.SaleInfo;
import com.hzyc.practice.models.TimeInfo;
import com.hzyc.practice.service.OrderServiceInterface;
@Service
public class OrderServiceImpl implements OrderServiceInterface{
	@Autowired
	private OrderMapper mapper;
	public void insertOrder(Cart cart) {
		// TODO Auto-generated method stub
		mapper.insertOrder(cart);
	}

	public void insertOrderDetail(Cart cart) {
		// TODO Auto-generated method stub
		mapper.insertOrderDetail(cart);
	}

	public int selectMaxOrderId() {
		// TODO Auto-generated method stub
		return mapper.selectMaxOrderId();
	}

	public void payOrder(int id) {
		// TODO Auto-generated method stub
		mapper.payOrder(id);
	}

	public List<Order> selectAllOrderAndUser(Page page) {
		// TODO Auto-generated method stub
		return mapper.selectAllOrderAndUser(page);
	}

	public List<SaleInfo> selectSalesByYear(int year) {
		// TODO Auto-generated method stub
		return mapper.selectSalesByYear(year);
	}

	public List<Order> selectOrderByTime(TimeInfo info) {
		// TODO Auto-generated method stub
		return mapper.selectOrderByTime(info);
	}

}
