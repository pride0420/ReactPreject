package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Chat;
import com.example.demo.vo.view.ChatView;

@Mapper
public interface ChatMapper {

	@Insert("insert into chat(memberId,content) values(#{memberId},#{content})")
	void addChat(Chat c);

	@Select("select * from chat where chatId=#{chatId}")
	Chat queryId(Integer chatId);

	@Select("select * from chatview order by chatId desc")
	List<ChatView> queryAllChat();

	@Select("select * from chatview where chatId=#{chatId}")
	ChatView queryChat(Integer chatId);

	@Select("select * from chatview where memberId=#{memberId} order by chatId desc")
	List<ChatView> queryUserChat(Integer memberId);
	
	@Update("update chat set content=#{content} where chatId=#{chatId}")
	void updateChat(Chat c);

	@Delete("delete from chat where chatId=#{chatId}")
	void deleteChat(Integer chatId);
}
