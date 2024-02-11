package com.example.demo.vo;

import java.sql.Timestamp;

public class Comment {

	private Integer commentId;
	private Integer memberId;
	private Integer chatId;
	private String comment;
	private Timestamp firsttime;

	private String name;
	private boolean item;

	public Comment(Integer memberId, Integer chatId, String comment) {
		super();
		this.memberId = memberId;
		this.chatId = chatId;
		this.comment = comment;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean getItem() {
		return item;
	}

	public void setItem(boolean item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(Timestamp firsttime) {
		this.firsttime = firsttime;
	}

}