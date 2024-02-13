package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Comment;

/***留言按讚的Mapper***/
@Mapper
public interface GoodsCommentMapper {

	@Insert("insert into goodcomment(memberId,chatId,commentId)" + "values(#{memberId},#{chatId},#{commentId})")
	void addGoodComment(Comment c);

	@Select("select * from goodcomment where memberId=#{memberId} and chatId=#{chatId}")
	List<Comment> queryGoodComment(Integer memberId, Integer chatId);

	@Select("select id from goodcomment where memberId=#{memberId} and commentId=#{commentId}")
	Integer queryCommentId(Comment c);

	@Delete("delete from goodcomment where id=#{id}")
	void deleteGoodComment(Integer id);
}
