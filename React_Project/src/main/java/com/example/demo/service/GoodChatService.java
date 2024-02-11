package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Chat;

public interface GoodChatService {

	String addGoodChat(Chat c);

	List<Chat> queryGoodChatMId(Integer memberId);

}
