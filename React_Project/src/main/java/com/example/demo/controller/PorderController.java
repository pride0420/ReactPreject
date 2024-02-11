package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.PorderServiceImpl;
import com.example.demo.vo.Porder;

@CrossOrigin
@RestController
@RequestMapping("/porder")
public class PorderController {

	@Autowired
	public PorderServiceImpl psi;

	@GetMapping("/queryId")
	public List<Porder> queryId() {
		return psi.queryId();
	}

	@GetMapping("queryItems")
	public List<Porder> queryItems(String items) {
		return psi.queryItems(items);
	}
}
