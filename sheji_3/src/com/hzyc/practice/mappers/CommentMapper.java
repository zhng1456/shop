package com.hzyc.practice.mappers;

import java.util.List;

import com.hzyc.practice.models.Comment;
import com.hzyc.practice.models.Good;

public interface CommentMapper {
	public void insertCommet(Comment comment);//�������
	public List<Comment> selectCommentByGood(Good good);//��ѯĳ����Ʒ������
	public List<Integer> canComment(Comment comment);//�ж��ܷ�����
}
