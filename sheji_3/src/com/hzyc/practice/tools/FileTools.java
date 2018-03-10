package com.hzyc.practice.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileTools {
	//����������д��path·���£��ļ���Ϊname
	public void writeFromInput(InputStream input,String path,String name){
		try {
			//System.out.println(path+name);
			FileOutputStream output = new FileOutputStream(path+File.separator+name);
			byte[] buffer = new byte[1024];
			int length=0;
			while((length=input.read(buffer))!=-1){
				output.write(buffer, 0, length);
			}
			output.close();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
