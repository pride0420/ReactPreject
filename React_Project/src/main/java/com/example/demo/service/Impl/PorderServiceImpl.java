package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PorderMapper;
import com.example.demo.service.PorderService;
import com.example.demo.vo.Porder;

@Service
public class PorderServiceImpl implements PorderService {

	@Autowired
	private PorderMapper pm;

	@Override
	public List<Porder> queryId() {
		List<Porder> l = pm.queryId();
		return l;
	}

	@Override
	public List<Porder> queryItems(String items) {
		List<Porder> l = pm.queryItems(items);
		return l;
	}

}
