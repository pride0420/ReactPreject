package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.GoodCommentMapper;
import com.example.demo.service.GoodCommentService;
import com.example.demo.vo.Comment;

@Service
public class GoodCommentServiceImpl implements GoodCommentService {

	@Autowired
	private GoodCommentMapper gcmp;

	@Override
	public String addGoodComment(Comment c) {

		Integer x = gcmp.queryCommentId(c);
		if (x != null) {
			gcmp.deleteGoodComment(x);
			return "已取消";
		} else {
			gcmp.addGoodComment(c);
			return "已收藏";
		}
	}

}
