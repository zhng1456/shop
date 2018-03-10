package com.hzyc.practice.models;

public class Comment {
	private int id;//ÆÀÂÛid
	private User user;
	private int goodId;
	private String value;//ÆÀÂÛÄÚÈÝ
	private String time;
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", goodId=" + goodId
				+ ", value=" + value + ", time=" + time + "]";
	}
	
	
	
}
