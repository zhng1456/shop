package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.TypeMapper;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;
import com.hzyc.practice.service.TypeServiceInterface;
@Service
public class TypeServiceImpl implements TypeServiceInterface {
	@Autowired
	private TypeMapper mapper;
	public List<Type> selectTypeById(Type type) {
		// TODO Auto-generated method stub
		return mapper.selectTypeById(type);
	}

	public void addType(Type type) {
		// TODO Auto-generated method stub
		mapper.addType(type);
	}

	public int deleteType(Type type) {
		// TODO Auto-generated method stub
		return mapper.deleteType(type);
	}

	public void updateType(Type type) {
		// TODO Auto-generated method stub
		mapper.updateType(type);
	}

	public void deleteMulType(List<Integer> list) {
		// TODO Auto-generated method stub
		mapper.deleteMulType(list);
	}

	public List<Type> selectPageType(Page page) {
		// TODO Auto-generated method stub
		return mapper.selectPageType(page);
	}

}
