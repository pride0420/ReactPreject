package com.example.demo.vo;

import java.sql.Timestamp;

public class Chat {
	private Integer id;// 借goodchat
	private Integer chatId;
	private Integer memberId;
	private String content;
	private Timestamp firsttime;

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chat(Integer memberId, String content) {
		super();
		this.memberId = memberId;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public Timestamp getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(Timestamp firsttime) {
		this.firsttime = firsttime;
	}

	public Chat(String content) {
		super();
		this.content = content;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}