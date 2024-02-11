package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Member;

@Mapper
public interface MemberMapper {

	@Insert("insert into test.member(username,password,name,email,phone) "
			+ "values(#{username},#{password},#{name},#{email},#{phone})")
	void addMember(Member m);

	@Select("select * from member where username=#{username} and password=#{password}")
	Member queryUser(Member m);

	@Select("select * from member where username=#{username}")
	Member queryUserName(Member m);

	@Update("update member set name=#{name},password=#{password},phone=#{phone},email=#{email} where memberId=#{memberId}")
	void updateMember(Member m);

	@Delete("delete from member where memberId=#{memberId}")
	void deleteMember(Integer memberId);
}
