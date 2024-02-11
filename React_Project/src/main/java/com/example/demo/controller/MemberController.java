package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.MemberServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	public MemberServiceImpl ms;

	@Autowired
	public HttpSession session;

	@PostMapping("/addMember")
	public boolean addMember(@RequestBody Member m, BindingResult bindingResult) throws IOException {
		boolean x = ms.addMember(m);
		Member mc = ms.queryUserName(m);
		if (x) {
			ms.sendRegistrationEmail(mc.getEmail());
		}
		return x;
	}

	@PostMapping("/login")
	public Member queryLigin(@RequestBody Member m) {
		Member mc = ms.queryUser(m);
		return mc;

	}

	@PostMapping("updateMember")
	public Member UpdateMember(@RequestBody Member m) {
		return ms.updateMember(m);
	}

	@PostMapping("deleteMember")
	public void deleteMember(Integer memberId) {
		ms.deleteMember(memberId);
	}

}
