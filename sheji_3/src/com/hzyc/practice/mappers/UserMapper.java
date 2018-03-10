package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;

public interface UserMapper {
	public List<User> selectUserAndOrder();//��ѯ�û��������Ӧ�Ķ�����Ϣ
	public List<User> selectUserAndGood();//��ѯ�û����乺�����Ʒ 
	public List<User> selectAllUser();//��ѯ�����û�
	public void insertUser(User user);
	public Address selectAddressOfUser(User user);//��ѯĳ���û����ջ���ַ
}
