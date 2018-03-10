package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.UserMapper;
import com.hzyc.practice.models.Address;
import com.hzyc.practice.models.User;
import com.hzyc.practice.service.UserServiceInterface;
@Service
public class UserServiceImpl implements UserServiceInterface {
	@Autowired
	private UserMapper mapper;
	public List<User> selectUserAndOrder() {
		// TODO Auto-generated method stub
		return mapper.selectUserAndOrder();
	}

	public List<User> selectUserAndGood() {
		// TODO Auto-generated method stub
		return mapper.selectUserAndGood();
	}

	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return mapper.selectAllUser();
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		mapper.insertUser(user);
	}

	public Address selectAddressOfUser(User user) {
		// TODO Auto-generated method stub
		return mapper.selectAddressOfUser(user);
	}

}
