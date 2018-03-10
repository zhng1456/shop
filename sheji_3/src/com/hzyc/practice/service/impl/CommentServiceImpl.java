package com.hzyc.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzyc.practice.mappers.CommentMapper;
import com.hzyc.practice.models.Comment;
import com.hzyc.practice.models.Good;
import com.hzyc.practice.service.CommentServiceInterface;
@Service
public class CommentServiceImpl implements CommentServiceInterface{
	@Autowired
	CommentMapper mapper;
	public void insertCommet(Comment comment) {
		// TODO Auto-generated method stub
		mapper.insertCommet(comment);
	}
	public List<Comment> selectCommentByGood(Good good) {
		// TODO Auto-generated method stub
		return mapper.selectCommentByGood(good);
	}
	public List<Integer> canComment(Comment comment) {
		// TODO Auto-generated method stub
		return mapper.canComment(comment);
	}
	
}
