package com.hzyc.practice.models;
//���������ʵ����
//һ�����������ж����Ʒ���ڶ���������з�ӳ
public class OrderDetail {
	private int id;//����id
	private int orderId;// ����id
	private Good good;//��Ӧ����Ʒ,����cartNumber����������
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
