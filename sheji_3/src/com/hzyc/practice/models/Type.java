package com.hzyc.practice.models;

public class Type {
	private int id;//��Ʒ����id
	private String name;//��������
	private Page page;//��ҳ
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
