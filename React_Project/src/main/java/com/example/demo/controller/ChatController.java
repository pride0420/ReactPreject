package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.ChatServiceImpl;
import com.example.demo.service.Impl.GoodsChatServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.view.ChatView;

/***貼文的controller***/
@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
	private final static Logger log = LoggerFactory.getLogger(Chat.class);
	@Autowired
	public ChatServiceImpl csi;

	@Autowired
	public GoodsChatServiceImpl gchsi;

	/***新增貼文***/
	@PostMapping("/addChat")
	public void addChat(@RequestBody Chat c) {
		csi.addChat(c);
	}
	
	/***查詢全部貼文***/
	@GetMapping("/queryAll")
	public List<ChatView> queryAllChat(Integer memberId) {
		return csi.queryAllChat(memberId);
	}
	
	/***用id查詢該則貼文***/
	@GetMapping("/queryChat")
	public ChatView queryChat(Integer chatId) {
		return csi.queryChat(chatId);
	}

	/***找出帳號發的貼文***/
	@GetMapping("queryUserChat")
	public List<ChatView> queryUserChat(Integer memberId) {

		return csi.queryUserChat(memberId);
	}

	/***刪除貼文***/
	@PostMapping("deleteChat")
	public String deleteChat(Integer chatId) {
		csi.deleteChat(chatId);
		return "刪除成功";
	}
	
	/***更新貼文內容***/
	@PostMapping("updateChat")
	public void updateChat(@RequestBody Chat c) {
		csi.updateChat(c);
	}
}
