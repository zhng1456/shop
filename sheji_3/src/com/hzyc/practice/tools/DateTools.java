package com.hzyc.practice.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

//时间日期工具类
public class DateTools {
	//获取date的字符串形式，用于向数据库中插入
	public String getStringDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	//传入一个图片完整的名称，返回时间的毫秒数+后缀
	public String createName(String originalName){
		Date date = new Date();
		String name = date.getTime()+originalName.substring(originalName.lastIndexOf("."));
		return name;
	}
}
