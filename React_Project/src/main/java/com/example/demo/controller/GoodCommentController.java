package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.GoodCommentServiceImpl;
import com.example.demo.vo.Comment;

@CrossOrigin
@RestController
@RequestMapping("goodComment")
public class GoodCommentController {

	@Autowired
	public GoodCommentServiceImpl gi;

	@PostMapping("addGoodComment")
	public String addGoodComment(@RequestBody Comment c) {
		return gi.addGoodComment(c);
	}
}
