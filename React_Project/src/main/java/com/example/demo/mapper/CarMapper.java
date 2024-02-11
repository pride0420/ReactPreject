package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Car;

@Mapper
public interface CarMapper {

	@Select("select * from car where memberId=#{memberId}")
	List<Car> queryAll(Integer memberId);

	@Delete("delete from shopcar where memberId=#{memberId}")
	void checkCar(Integer memberId);
}