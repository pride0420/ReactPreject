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

/**
 * 帳戶的controller
 */
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	public MemberServiceImpl ms;

	/**
	 * 新增帳號 並發信
	 * @param m
	 * @param bindingResult
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/addMember")
	public boolean addMember(@RequestBody Member m, BindingResult bindingResult) throws IOException {
		boolean x = ms.addMember(m);
		
		if (x) {
			Member mc = ms.queryUserName(m);
			ms.sendRegistrationEmail(mc.getEmail());
		}
		return x;
	}

	/**
	 * 登入
	 * @param m
	 * @return
	 */
	@PostMapping("/login")
	public Member queryLigin(@RequestBody Member m) {
		Member mc = ms.queryUser(m);
		return mc;

	}

	/**
	 * 更新帳號資料
	 * @param m
	 * @return
	 */
	@PostMapping("updateMember")
	public Member UpdateMember(@RequestBody Member m) {
		return ms.updateMember(m);
	}
	
	/**
	 * 註銷帳號
	 * @param memberId
	 */
	@PostMapping("deleteMember")
	public void deleteMember(Integer memberId) {
		ms.deleteMember(memberId);
	}

}
