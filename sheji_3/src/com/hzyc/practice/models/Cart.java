package com.hzyc.practice.models;

import java.util.List;

//购物车类
public class Cart {
	private int id;//id
	private User user;//一个购物车对应一个用户
	private List<Good> goodList;//一个购物车中有多个商品
	private double total;//总价钱
	private double realTotal;//根据用户是否选中来计算
	private int orderId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getRealTotal() {
		return realTotal;
	}
	public void setRealTotal(double realToal) {
		this.realTotal = realToal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Good> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	//初始化，计算总价钱
	public void init(){
		for(int i=0;i<goodList.size();++i){
			Good good = goodList.get(i);
			double tempPrice = good.getPrice()*good.getCartNumber();
			total+=tempPrice;
			//只有当选中时，才加到realToal中
			if(good.getCartFlag()==1){
				realTotal+=tempPrice;
			}
		}
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", goodList=" + goodList
				+ ", total=" + total + ", realTotal=" + realTotal + "]";
	}


}
