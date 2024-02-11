package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.GoodChatServiceImpl;
import com.example.demo.vo.Chat;

@CrossOrigin
@RestController
@RequestMapping("/goodchat")
public class GoodChatController {

	@Autowired
	public GoodChatServiceImpl gchsi;

	@PostMapping("addGoodChat")
	public String addGoodChat(@RequestBody Chat c) {
		return gchsi.addGoodChat(c);

	}

}
