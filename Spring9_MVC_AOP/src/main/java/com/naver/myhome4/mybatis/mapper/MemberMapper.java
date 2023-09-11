package com.naver.myhome4.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.naver.myhome4.domain.Member;

public interface MemberMapper {
	
	public Member isId(String id);
	
	public int insert(Member m);
	
	public int update(Member m);
	
	public void delete(String id);
	
	public int getSearchListCount(Map<String, Object> map);
	
	public List<Member> getSearchList(Map<String, Object> map);
}
