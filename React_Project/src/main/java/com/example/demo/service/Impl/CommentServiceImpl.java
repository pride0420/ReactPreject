package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.GoodsCommentMapper;
import com.example.demo.service.CommentService;
import com.example.demo.vo.Comment;

/***留言的實作***/
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper cm;

	@Autowired
	private GoodsCommentMapper gcmp;

	/***新增留言***/
	@Override
	public void addComment(Comment c) {
		cm.addComment(c);
	}

	/***找出貼文底下的留言***/
	@Override
	public List<Comment> queryAllComment(Integer chatId, Integer memberId) {
		List<Comment> l = queryGood(chatId, memberId);
		return l;
	}
	
	/***找出貼文底下有按讚的留言 queryAllComment使用***/
	private List<Comment> queryGood(Integer chatId, Integer memberId) {
		List<Comment> l = cm.queryAllComment(chatId);
		List<Comment> g = gcmp.queryGoodComment(memberId, chatId);

		for (Comment o : l) {
			o.setItem(false);
		}
		for (Comment o : l) {
			for (Comment p : g) {
				if (o.getCommentId() == p.getCommentId()) {
					o.setItem(true);
				}
			}
		}
		return l;

	}

}
