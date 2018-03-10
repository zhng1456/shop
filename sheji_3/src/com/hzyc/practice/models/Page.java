package com.hzyc.practice.models;

public class Page {
	//��ǰҳ
	private int currentPage=1;
	//��ʼ��¼
	private int start;
	//ÿһҳ��¼��
	private int perPage;
	//��һҳҳ��
	private int next;
	//��һҳҳ��
	private int back;
	//�ܼ�¼��
	private int length;
	//��ҳ��
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
		//����start������ƴ��limit���ֵ
		start=(currentPage-1)*perPage;
		//������ҳ��
		allPage = length%perPage==0?length/perPage:(length/perPage+1);
		//��һҳ��ҳ��
		next=currentPage<allPage?currentPage+1:allPage;
		//��һҳҳ��
		back=currentPage>1?currentPage-1:1;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", start=" + start
				+ ", perPage=" + perPage + ", next=" + next + ", back=" + back
				+ "]";
	}
	
}
