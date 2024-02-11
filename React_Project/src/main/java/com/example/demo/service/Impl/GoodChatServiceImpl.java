package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.GoodChatMapper;
import com.example.demo.service.GoodChatService;
import com.example.demo.vo.Chat;

@Service
public class GoodChatServiceImpl implements GoodChatService {

	@Autowired
	private GoodChatMapper gchm;

	@Override
	public String addGoodChat(Chat c) {
		Chat ch = gchm.queryGoodId(c);
		if (ch == null) {
			gchm.addGoodChat(c);
			return "已收藏";
		} else {
			gchm.deleteGoodChat(ch.getId());
			return "已取消";
		}
	}

	@Override
	public List<Chat> queryGoodChatMId(Integer memberId) {
		List<Chat> l = gchm.queryGoodChatMId(memberId);
		return l;
	}

}
