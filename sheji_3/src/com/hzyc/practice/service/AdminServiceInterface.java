package com.hzyc.practice.service;

import java.util.List;

import com.hzyc.practice.models.Admin;

public interface AdminServiceInterface {
	public List<Admin> selectAdmin(Admin admin);//��ѯ���й���Ա
	public void addAdmin(Admin admin);//�������Ա��Ϣ
	public void updateAdmin(Admin admin);//����
	public void deleteAdmin(Admin admin);//ɾ��
}
