package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Chat;

@Mapper
public interface GoodChatMapper {

	@Insert("insert into goodchat(memberId,chatId) values(#{memberId},#{chatId})")
	void addGoodChat(Chat c);

	@Select("select * from test.goodchat where memberId=#{memberId}")
	List<Chat> queryGoodChatMId(Integer memberId);

	@Select("select *from goodchat where memberId=#{memberId} and chatId=#{chatId}")
	Chat queryGoodId(Chat c);

	@Delete("delete from goodchat where id=#{id}")
	void deleteGoodChat(Integer id);

}
