package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Car;

public interface CarService {

	List<Car> queryAll(Integer memberId);

	void updateCar(Integer id, String item);

	void checkCar(Integer memberId);
}
