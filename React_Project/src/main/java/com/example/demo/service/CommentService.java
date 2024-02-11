package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Comment;

public interface CommentService {

	void addComment(Comment c);

	List<Comment> queryAllComment(Integer chatId, Integer memberId);
}
