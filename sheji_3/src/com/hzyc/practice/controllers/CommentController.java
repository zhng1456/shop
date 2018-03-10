package com.hzyc.practice.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzyc.practice.models.Comment;
import com.hzyc.practice.service.CommentServiceInterface;

@Controller
@RequestMapping("CommentController")
public class CommentController {
	@Autowired
	private CommentServiceInterface service;
	@RequestMapping("insertComment.do")
	public void insertComment(Comment comment,HttpServletResponse response){
		//根据传入的comment判断能否评论
		List<Integer> flagList = service.canComment(comment);
		int flag=0;
		for(int i=0;i<flagList.size();++i){
			if(flagList.get(i)==1){
				flag=1;
				break;
			}
		}
		try {
			PrintWriter out = response.getWriter();
			if(flag==1){
				//可以评论
				//插入
				service.insertCommet(comment);
				out.println(1);
			}
			else{
				out.println(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
