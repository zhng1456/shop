package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;

public interface TypeMapper {
	public List<Type> selectTypeById(Type type);//id
	public void addType(Type type);//插入一条种类信息
	public int deleteType(Type type);//删除种类
	public void updateType(Type type);//修改种类
	public void deleteMulType(List<Integer> list);//批量删除种类
	public List<Type> selectPageType(Page page);//分页查询
}
