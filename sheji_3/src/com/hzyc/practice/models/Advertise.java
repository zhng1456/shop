package com.hzyc.practice.models;
//����ͼƬ��
public class Advertise {
	private int id;//���id
	private String name;//ͼƬ����
	
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

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", name=" + name + "]";
	}
	
}
