package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.GoodAndType;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;


public interface GoodMapper {
	public int insertGood(Good good);
	public List<Good> selectAllGood();//��ѯ������Ʒ
	public Good selectGoodById(int id);
	public List<Good> selectGoodByName(String name);//����nameģ����ѯ
	public void updateGood(Good good);//������Ʒ
	public void downGood(Good good);//�¼���Ʒ
	public List<Good> selectPageGood(Page page);//��ҳ��ѯ
	public int selectAllLength();//�ܼ�¼��
	public List<Good> selectGoodByType(Type type);//������������Ʒ
	public int selectGoodByTypeLength(Type type);//��ѯĳһ�����Ʒ�������������ڷ�ҳ�ļ���
	public List<Good> selectLatestGood();//��ѯ���µ���Ʒ������ҳ��ʾ
	public List<Good> selectFeaturedGood();//��ѯ��ɫ��Ʒ
	public void setGoodFeatured(Good good);//����ĳ��ƷΪ��ɫ��Ʒ
	public void cancelGoodFeatured(Good good);//ȡ������
	public List<Good> selectGoodByNameAndType(GoodAndType gat);
}
