package com.hzyc.practice.models;
//订单详情的实体类
//一个订单可以有多个商品，在订单详情表中反映
public class OrderDetail {
	private int id;//详情id
	private int orderId;// 订单id
	private Good good;//对应的商品,其中cartNumber即购买数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", good="
				+ good + "]";
	}
	
}
