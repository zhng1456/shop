package com.hzyc.practice.models;
//收获地址实体类
public class Address {
	private String province;
	private String city;
	private String address;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city
				+ ", address=" + address + "]";
	}
	
}
