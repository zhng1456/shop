package com.hzyc.practice.models;
//����Աʵ����
public class Admin {
	private int id;//����Աid
	private String username;//�û���
	private String password;//����
	private String email;//����
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}
	
}
