package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.CommentServiceImpl;
import com.example.demo.vo.Comment;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	public CommentServiceImpl cmsi;

	@PostMapping("addComment")
	public String addComment(@RequestBody Comment c) {
		cmsi.addComment(c);
		return "add";
	}

	@GetMapping("queryAllComment")
	public List<Comment> queryAllComment(Integer chatId, Integer memberId) {
		return cmsi.queryAllComment(chatId, memberId);
	}

}
