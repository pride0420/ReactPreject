package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.GoodCommentMapper;
import com.example.demo.service.CommentService;
import com.example.demo.vo.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper cm;

	@Autowired
	private GoodCommentMapper gcmp;

	@Override
	public void addComment(Comment c) {
		cm.addComment(c);
	}

	@Override
	public List<Comment> queryAllComment(Integer chatId, Integer memberId) {
		List<Comment> l = queryGood(chatId, memberId);
		return l;
	}

	private List<Comment> queryGood(Integer chatId, Integer memberId) {
		List<Comment> l = cm.queryAllComment(chatId);
		List<Comment> g = gcmp.queryGoodComment(memberId, chatId);

		for (Comment o : l) {
			o.setItem(false);
		}
		for (Comment o : l) {
			for (Comment p : g) {
				if (o.getMemberId() == p.getMemberId() && o.getCommentId() == p.getCommentId()) {
					o.setItem(true);
				}
			}
		}
		return l;

	}

}
