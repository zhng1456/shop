package com.hzyc.practice.models;

public class Page {
	//当前页
	private int currentPage=1;
	//起始记录
	private int start;
	//每一页记录数
	private int perPage;
	//下一页页数
	private int next;
	//上一页页数
	private int back;
	//总记录数
	private int length;
	//总页数
	private int allPage;
	
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getBack() {
		return back;
	}
	public void setBack(int back) {
		this.back = back;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void init(){
		//计算start，用于拼接limit后的值
		start=(currentPage-1)*perPage;
		//计算总页数
		allPage = length%perPage==0?length/perPage:(length/perPage+1);
		//下一页的页数
		next=currentPage<allPage?currentPage+1:allPage;
		//上一页页数
		back=currentPage>1?currentPage-1:1;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", start=" + start
				+ ", perPage=" + perPage + ", next=" + next + ", back=" + back
				+ "]";
	}
	
}
