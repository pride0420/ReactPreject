package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Porder;

@Mapper
public interface PorderMapper {

	@Select("select * from porder where id=1 or id=4 or id=7 or id=10")
	List<Porder> queryId();

	@Select("select * from porder where items=#{items}")
	List<Porder> queryItems(String items);

	@Select("select * from portfolio.porder where id=#{id}")
	Porder query(Integer id);

}
