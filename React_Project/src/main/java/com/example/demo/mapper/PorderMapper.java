package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Porder;

/***商品的Mapper***/
@Mapper
public interface PorderMapper {

	@Select("select * from porder where porderId=1 or porderId=4 or porderId=7 or porderId=10")
	List<Porder> queryId();

	@Select("select * from porder where items=#{items}")
	List<Porder> queryItems(String items);

	@Select("select * from porder where porderId=#{porderId}")
	Porder query(Integer porderId);

}
