package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Good;
import com.hzyc.practice.models.GoodAndType;
import com.hzyc.practice.models.Page;
import com.hzyc.practice.models.Type;


public interface GoodMapper {
	public int insertGood(Good good);
	public List<Good> selectAllGood();//查询所有商品
	public Good selectGoodById(int id);
	public List<Good> selectGoodByName(String name);//根据name模糊查询
	public void updateGood(Good good);//更新商品
	public void downGood(Good good);//下架商品
	public List<Good> selectPageGood(Page page);//分页查询
	public int selectAllLength();//总记录数
	public List<Good> selectGoodByType(Type type);//根据类别查找商品
	public int selectGoodByTypeLength(Type type);//查询某一类别商品的总数量，用于分页的计算
	public List<Good> selectLatestGood();//查询最新的商品，在主页显示
	public List<Good> selectFeaturedGood();//查询特色商品
	public void setGoodFeatured(Good good);//设置某商品为特色商品
	public void cancelGoodFeatured(Good good);//取消设置
	public List<Good> selectGoodByNameAndType(GoodAndType gat);
}
