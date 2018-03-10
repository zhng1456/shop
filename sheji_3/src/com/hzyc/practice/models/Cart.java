package com.hzyc.practice.models;

import java.util.List;

//���ﳵ��
public class Cart {
	private int id;//id
	private User user;//һ�����ﳵ��Ӧһ���û�
	private List<Good> goodList;//һ�����ﳵ���ж����Ʒ
	private double total;//�ܼ�Ǯ
	private double realTotal;//�����û��Ƿ�ѡ��������
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
	//��ʼ���������ܼ�Ǯ
	public void init(){
		for(int i=0;i<goodList.size();++i){
			Good good = goodList.get(i);
			double tempPrice = good.getPrice()*good.getCartNumber();
			total+=tempPrice;
			//ֻ�е�ѡ��ʱ���żӵ�realToal��
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
