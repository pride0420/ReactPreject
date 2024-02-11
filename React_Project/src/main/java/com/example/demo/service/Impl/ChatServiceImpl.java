package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ChatMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.GoodChatMapper;
import com.example.demo.service.ChatService;
import com.example.demo.vo.Chat;
import com.example.demo.vo.view.ChatView;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatMapper cm;

	@Autowired
	private GoodChatMapper gchm;

	@Autowired
	private CommentMapper ctm;

	@Override
	public void addChat(Chat c) {
		cm.addChat(c);
	}

	@Override
	public List<ChatView> queryAllChat(Integer memberId) {
		List<ChatView> l = queryGood(memberId);
		return l;
	}

	public List<ChatView> queryGood(Integer memberId) {
		List<ChatView> l = cm.queryAllChat();
		List<Chat> g = gchm.queryGoodChatMId(memberId);
		for (ChatView o : l) {
			o.setItem(false);
		}
		for (ChatView o : l) {
			o.setChatSum(ctm.queryCommentSum(o.getChatId()));
			for (Chat p : g) {
				if (p.getChatId() == o.getChatId() && o.getMemberId() == p.getMemberId()) {
					o.setItem(true);
				}
			}
		}
		return l;
	}

	@Override
	public ChatView queryChat(Integer chatId) {
		ChatView c = cm.queryChat(chatId);
		return c;
	}

	@Override
	public List<ChatView> queryUserChat(Integer memberId) {
		List<ChatView> l = cm.queryUserChat(memberId);
		return l;
	}

	@Override
	public void deleteChat(Integer chatId) {
		Chat c = cm.queryId(chatId);
		cm.deleteChat(c.getChatId());
	}

}
