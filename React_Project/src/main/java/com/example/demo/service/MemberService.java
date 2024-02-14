package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Chat;
import com.example.demo.vo.Member;

/**
 * 帳戶的service
 */
public interface MemberService {

	boolean addMember(Member m);

	Member queryUser(Member m);
	
	Member queryUserName(Member m);

	Member updateMember(Member m);

	void deleteMember(Integer memberId);
}
