package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Member;

@Mapper
public interface MemberMapper {
	
	List<Member> selectMembers();
	void selectById(Integer id);
	void addMember(Member member);
	void deleteMember(Integer id);
	
	

}
