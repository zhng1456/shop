package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.AdminMapper;
import com.hzyc.practice.models.Admin;
import com.hzyc.practice.service.AdminServiceInterface;
@Service
public class AdminServiceImpl implements AdminServiceInterface {
	@Autowired
	private AdminMapper mapper;
	public List<Admin> selectAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return mapper.selectAdmin(admin);
	}

	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		mapper.addAdmin(admin);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		mapper.updateAdmin(admin);
	}
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		mapper.deleteAdmin(admin);
	}
}
