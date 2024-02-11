package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.ShopServiceImpl;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	public ShopServiceImpl ssi;

	@Autowired
	public HttpSession session;

	@PostMapping("addShop")
	public void addShop(Integer id, Integer memberId) {
		ssi.addShop(id, memberId);
	}

	@GetMapping("querySum")
	public Integer querySum(Integer memberId) {

		return ssi.querySum(memberId);
	}
}
