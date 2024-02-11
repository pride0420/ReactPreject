package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Impl.CarServiceImpl;
import com.example.demo.vo.Car;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	public CarServiceImpl csi;

	@GetMapping("queryCar")
	public List<Car> queryCar(Integer memberId) {
		return csi.queryAll(memberId);
	}

	@PostMapping("updateCar")
	public void updateCar(Integer id, String item) {
		csi.updateCar(id, item);
	}

	@PostMapping("checkCar")
	public void checkCar(Integer memberId, String email, Car c,BindingResult bindingResult) throws IOException {
		csi.checkCar(memberId);
		csi.sendRegistrationEmail(email);

	}
}
