package com.hzyc.practice.models;

import java.util.List;

//����ʵ����
public class Order {
	private int id;//����id
	private User user;//�û�����,����ö�����Ӧ���û�
	private List<OrderDetail> dList;
	private String time;//����������ʱ��
	private int flag;//��־,0ȷ�ϵ�δ֧��,1�Ѿ�֧��
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
