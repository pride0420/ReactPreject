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

@Service
public class MemberServiceImpl implements MemberService {

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Resource
	private JavaMailSender em;

	@Autowired
	private MemberMapper mm;

	@Override
	public Member queryUser(Member m) {
		Member mc = mm.queryUser(m);
		return mc;
	}

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

	public void sendRegistrationEmail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromEmail);
		msg.setTo(email);
		msg.setSubject("註冊成功");
		msg.setText("感謝註冊");

		em.send(msg);
	}

	@Override
	public Member queryUserName(Member m) {
		Member mc = mm.queryUserName(m);
		return mc;
	}

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

	@Override
	public void deleteMember(Integer memberId) {
		mm.deleteMember(memberId);
	}
}
