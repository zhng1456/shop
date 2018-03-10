package com.hzyc.practice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.GoodAndType;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;
public interface GoodServiceInterface {
	public int insertGood(Good good);
	public List<Good> selectAllGood();//��ѯ������Ʒ
	public Good selectGoodById(int id);
	public List<Good> selectGoodByName(String name);
	public void updateGood(Good good,MultipartFile file,HttpServletRequest request);//����
	public void downGood(Good good);//�¼���Ʒ
	public List<Good> selectPageGood(Page page);//��ҳ
	public int selectAllLength();//�ܼ�¼��
	public List<Good> selectGoodByType(Type type);
	public int selectGoodByTypeLength(Type type);//��ѯĳһ�����Ʒ�������������ڷ�ҳ�ļ���
	public List<Good> selectLatestGood();
	public List<Good> selectFeaturedGood();//��ѯ��ɫ��Ʒ
	public void setGoodFeatured(Good good);//����ĳ��ƷΪ��ɫ��Ʒ
	public void cancelGoodFeatured(Good good);//ȡ������
	public List<Good> selectGoodByNameAndType(GoodAndType gat);
}
