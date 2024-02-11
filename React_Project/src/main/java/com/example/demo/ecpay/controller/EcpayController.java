package com.example.demo.ecpay.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.ecpay.service.EcpayService;
import com.example.demo.service.Impl.ShopServiceImpl;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping("/shop")
public class EcpayController {

	@Autowired
	EcpayService ecpayService;
	
	@Autowired
	HttpSession session;
	@Autowired
	public ShopServiceImpl si;
	@PostMapping("/ecpayCheckout")
	
	public String ecpayCheckout() {
		Member m=(Member) session.getAttribute("M");
		int x=si.querySum(m.getMemberId());
		String aioCheckOutALLForm = ecpayService.ecpayCheckout(x);
        return aioCheckOutALLForm; // form表單
	} 

	@GetMapping("goecpay")
	public ModelAndView goEcpay() {
		ModelAndView mav=new ModelAndView("/js/shop/Ecpay.html");
		return mav;
	}
}

