package com.hzyc.practice.models;

import java.util.List;

//用户实体类
public class User {
	private int id;// 用户id
	private String personName;//联系人姓名
	private String username;// 用户名
	private String password;// 密码
	private String sex;// 性别
	private String tel;// 电话
	private int pId;//省份id
	private int cId;//城市id
	private String address;//具体的地址
	private List<Order> orderList;// 一个用户对应的多个订单
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", sex=" + sex + ", tel=" + tel + ", orderList="
				+ orderList + "]";
	}
}
