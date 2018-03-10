package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;

public interface TypeMapper {
	public List<Type> selectTypeById(Type type);//id
	public void addType(Type type);//����һ��������Ϣ
	public int deleteType(Type type);//ɾ������
	public void updateType(Type type);//�޸�����
	public void deleteMulType(List<Integer> list);//����ɾ������
	public List<Type> selectPageType(Page page);//��ҳ��ѯ
}
