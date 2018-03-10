package com.hzyc.practice.models;

public class SaleInfo {
	private String m;//月份
	private int orderNumber;//该月订单数
	private double monthTotal;//该月销售额
	
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getMonthTotal() {
		return monthTotal;
	}
	public void setMonthTotal(double monthTotal) {
		this.monthTotal = monthTotal;
	}
	
}
