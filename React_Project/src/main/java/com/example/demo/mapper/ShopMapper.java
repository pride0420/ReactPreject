package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Shop;

/***商城的Mapper***/
@Mapper
public interface ShopMapper {

	@Insert("insert into shopcar(memberId,porderId,num,sum) values(#{memberId},#{porderId},#{num},#{sum})")
	void addShop(Shop s);

	@Select("select * from shopcar where porderId=#{porderId} and memberId=#{memberId}")
	Shop queryPorderId(Integer porderId,Integer memberId);

	@Select("select sum(sum) from test.shopcar where memberId=#{memberId}")
	Integer querySum(Integer memberId);

	@Select("select * from shopcar where id=#{id}")
	Shop queryShopId(Integer id);

	@Update("update shopcar set num=#{num},sum=#{sum} where id=#{id}")
	void updateShop(Shop s);

	@Delete("delete from shopcar where id=#{id}")
	void deleteShop(Integer Id);
}
