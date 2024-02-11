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
import com.example.demo.service.Impl.GoodChatServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.view.ChatView;

@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {
	private final static Logger log = LoggerFactory.getLogger(Chat.class);
	@Autowired
	public ChatServiceImpl csi;

	@Autowired
	public GoodChatServiceImpl gchsi;

	@PostMapping("/addChat")
	public void addChat(@RequestBody Chat c) {
		csi.addChat(c);
	}

	@GetMapping("/queryAll")
	public List<ChatView> queryAllChat(Integer memberId) {
		return csi.queryAllChat(memberId);
	}

	@GetMapping("/queryChat")
	public ChatView queryChat(Integer chatId) {
		return csi.queryChat(chatId);
	}

	@GetMapping("queryUserChat")
	public List<ChatView> queryUserChat(Integer memberId) {

		return csi.queryUserChat(memberId);
	}

	@PostMapping("deleteChat")
	public String deleteChat(Integer chatId) {
		csi.deleteChat(chatId);
		return "刪除成功";
	}
	
	@PostMapping("updateChat")
	public void updateChat(@RequestBody Chat c) {
		csi.updateChat(c);
	}
}
