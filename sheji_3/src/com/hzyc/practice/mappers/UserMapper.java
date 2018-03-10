package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;

public interface UserMapper {
	public List<User> selectUserAndOrder();//查询用户，及其对应的订单信息
	public List<User> selectUserAndGood();//查询用户及其购买的商品 
	public List<User> selectAllUser();//查询所有用户
	public void insertUser(User user);
	public Address selectAddressOfUser(User user);//查询某个用户的收货地址
}
