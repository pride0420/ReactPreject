package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Chat;
import com.example.demo.vo.view.ChatView;

public interface ChatService {

	void addChat(Chat c);

	List<ChatView> queryAllChat(Integer memberId);

	ChatView queryChat(Integer chatId);

	List<ChatView> queryUserChat(Integer memberId);

	void deleteChat(Integer chatId);
}
