package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.Admin;

public interface AdminServiceInterface {
	public List<Admin> selectAdmin(Admin admin);//查询所有管理员
	public void addAdmin(Admin admin);//插入管理员信息
	public void updateAdmin(Admin admin);//更新
	public void deleteAdmin(Admin admin);//删除
}
