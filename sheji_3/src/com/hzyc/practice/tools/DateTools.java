package com.hzyc.practice.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

//ʱ�����ڹ�����
public class DateTools {
	//��ȡdate���ַ�����ʽ�����������ݿ��в���
	public String getStringDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	//����һ��ͼƬ���������ƣ�����ʱ��ĺ�����+��׺
	public String createName(String originalName){
		Date date = new Date();
		String name = date.getTime()+originalName.substring(originalName.lastIndexOf("."));
		return name;
	}
}
