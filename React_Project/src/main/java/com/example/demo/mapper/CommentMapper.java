package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Comment;

/***留言的Mapper***/
@Mapper
public interface CommentMapper {

	@Insert("insert into comment(memberId,chatId,comment)" + "values(#{memberId},#{chatId},#{comment})")
	void addComment(Comment c);

	@Select("select * from commentview where chatId=#{chatId} order by commentId desc")
	List<Comment> queryAllComment(Integer chatId);

	@Select("select count(*) from comment where chatId=#{chatId}")
	Integer queryCommentSum(Integer chatId);

}
