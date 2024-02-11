package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Shop;

public interface ShopService {

	void addShop(Integer id, Integer memberId);

	Integer querySum(Integer memberId);

}
