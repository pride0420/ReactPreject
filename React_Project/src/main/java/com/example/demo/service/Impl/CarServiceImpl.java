package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.CarMapper;
import com.example.demo.mapper.PorderMapper;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.service.CarService;
import com.example.demo.vo.Car;
import com.example.demo.vo.Porder;
import com.example.demo.vo.Shop;

import jakarta.annotation.Resource;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper cm;

	@Autowired
	private ShopMapper sm;

	@Autowired
	private PorderMapper pm;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Resource
	private JavaMailSender em;

	@Override
	public List<Car> queryAll(Integer memberId) {
		List<Car> l = cm.queryAll(memberId);
		return l;
	}

	@Override
	public void updateCar(Integer id, String item) {
		Shop s = sm.queryShopId(id);
		Porder p = pm.query(s.getPorderId());
		if (item.equals("add")) {
			s.setNum(s.getNum() + 1);
			s.setSum(p.getAmount() * s.getNum());
			sm.updateShop(s);
		} else if (item.equals("reduced")) {
			s.setNum(s.getNum() - 1);
			if (s.getNum() != 0) {
				s.setSum(p.getAmount() * s.getNum());
				sm.updateShop(s);
			} else {
				sm.deleteShop(id);
			}
		} else {
			sm.deleteShop(id);
		}
	}

	@Override
	public void checkCar(Integer memberId) {
		cm.checkCar(memberId);
	}

	public void sendRegistrationEmail(String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromEmail);
		msg.setTo(email);
		msg.setSubject("飛鳥");
		msg.setText("結帳成功，感謝購買");

		em.send(msg);
	}

}
