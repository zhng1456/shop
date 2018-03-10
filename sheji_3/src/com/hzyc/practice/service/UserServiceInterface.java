package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;

public interface UserServiceInterface {
	public List<User> selectUserAndOrder();//��ѯ�û��������Ӧ�Ķ�����Ϣ
	public List<User> selectUserAndGood();//��ѯ�û����乺�����Ʒ 
	public List<User> selectAllUser();//��ѯ�����û�
	public void insertUser(User user);//�����û�
	public Address selectAddressOfUser(User user);//��ѯĳ���û����ջ���ַ
}
