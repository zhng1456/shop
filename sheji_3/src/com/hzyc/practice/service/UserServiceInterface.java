package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;

public interface UserServiceInterface {
	public List<User> selectUserAndOrder();//查询用户，及其对应的订单信息
	public List<User> selectUserAndGood();//查询用户及其购买的商品 
	public List<User> selectAllUser();//查询所有用户
	public void insertUser(User user);//插入用户
	public Address selectAddressOfUser(User user);//查询某个用户的收货地址
}
