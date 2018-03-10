package com.hzyc.practice.models;

import java.util.List;

//�û�ʵ����
public class User {
	private int id;// �û�id
	private String personName;//��ϵ������
	private String username;// �û���
	private String password;// ����
	private String sex;// �Ա�
	private String tel;// �绰
	private int pId;//ʡ��id
	private int cId;//����id
	private String address;//����ĵ�ַ
	private List<Order> orderList;// һ���û���Ӧ�Ķ������
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
