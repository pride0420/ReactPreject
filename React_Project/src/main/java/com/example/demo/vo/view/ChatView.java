package com.example.demo.vo.view;

import java.sql.Timestamp;

public class ChatView {

	private Integer ChatId;
	private Integer memberId;
	private String name;
	private String content;
	private Timestamp firsttime;
	private boolean item;
	private Integer chatSum;

	public ChatView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getChatSum() {
		return chatSum;
	}

	public void setChatSum(Integer chatSum) {
		this.chatSum = chatSum;
	}

	public boolean getItem() {
		return item;
	}

	public void setItem(boolean item) {
		this.item = item;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getChatId() {
		return ChatId;
	}

	public void setChatId(Integer chatId) {
		ChatId = chatId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(Timestamp firsttime) {
		this.firsttime = firsttime;
	}

}
