package com.hzyc.practice.models;
//��Ʒʵ����
public class Good {
	private int id;//��Ʒid
	private String name;//��Ʒ����
	private int number;//��Ʒ�������
	private int cartNumber;//���ﳵ������
	private Type type;//��Ʒ���id
	private double price;//��Ʒ����
	private String pictureName;//��ӦͼƬ����
	private String description;//����
	private int cartFlag;//��Ʒ�ڹ��ﳵ���Ƿ�ѡ��
	private int flag;//��־
	private int featured;//��ɫ��Ʒ��ʶ
	
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
