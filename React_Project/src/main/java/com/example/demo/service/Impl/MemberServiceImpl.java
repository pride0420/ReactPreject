package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.service.MemberService;
import com.example.demo.vo.Chat;
import com.example.demo.vo.Member;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

/**
 * 帳戶的實作
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Resource
	private JavaMailSender em;

	@Autowired
	private MemberMapper mm;

	/**
	 * 確認帳號密碼
	 */
	@Override
	public Member queryUser(Member m) {
		Member mc = mm.queryUser(m);
		return mc;
	}

	/**
	 * 確認帳號有無重複後做新增
	 */
	@Override
	public boolean addMember(Member m) {
		Member mc = mm.queryUserName(m);

		boolean x = false;
		if (mc == null) {
			mm.addMember(m);
			x = true;
		}
		return x;
	}

	/**
	 * 新增成功後的信件發送
	 * @param email
	 */
	public void sendRegistrationEmail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromEmail);
		msg.setTo(email);
		msg.setSubject("飛龍");
		msg.setText("註冊成功，感謝註冊");

		em.send(msg);
	}

	/**
	 * 找出該帳號資料
	 */
	@Override
	public Member queryUserName(Member m) {
		Member mc = mm.queryUserName(m);
		return mc;
	}

	/**
	 * 更新帳號資料
	 */
	@Override
	public Member updateMember(Member m) {

		Member mc = mm.queryUser(m);
		mc.setName(m.getName());
		mc.setPassword(m.getPassword());
		mc.setPhone(m.getPhone());
		mc.setEmail(m.getEmail());
		mm.updateMember(mc);

		return mc;
	}

	/**
	 * 註銷帳號
	 */
	@Override
	public void deleteMember(Integer memberId) {
		mm.deleteMember(memberId);
	}
}
