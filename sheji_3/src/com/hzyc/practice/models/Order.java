package com.hzyc.practice.models;

import java.util.List;

//订单实体类
public class Order {
	private int id;//订单id
	private User user;//用户对象,保存该订单对应的用户
	private List<OrderDetail> dList;
	private String time;//创建订单的时间
	private int flag;//标志,0确认但未支付,1已经支付
	private double money;
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderDetail> getdList() {
		return dList;
	}
	public void setdList(List<OrderDetail> dList) {
		this.dList = dList;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", dList=" + dList
				+ ", time=" + time + ", flag=" + flag + "]";
	}
	
	
	
	
}
