package com.hzyc.practice.models;
//商品实体类
public class Good {
	private int id;//商品id
	private String name;//商品名称
	private int number;//商品库存数量
	private int cartNumber;//购物车中数量
	private Type type;//商品类别id
	private double price;//商品单价
	private String pictureName;//对应图片名称
	private String description;//描述
	private int cartFlag;//商品在购物车中是否被选中
	private int flag;//标志
	private int featured;//特色商品标识
	
	public int getFeatured() {
		return featured;
	}
	public void setFeatured(int featured) {
		this.featured = featured;
	}
	public int getCartFlag() {
		return cartFlag;
	}
	public void setCartFlag(int cartFlag) {
		this.cartFlag = cartFlag;
	}
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", number=" + number
				+ ", cartNumber=" + cartNumber + ", type=" + type + ", price="
				+ price + ", pictureName=" + pictureName + ", description="
				+ description + ", flag=" + flag + "]";
	}
	
	
}
