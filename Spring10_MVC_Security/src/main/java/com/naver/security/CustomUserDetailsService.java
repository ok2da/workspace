package com.naver.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.naver.myhome4.domain.Member;
import com.naver.myhome4.mybatis.mapper.MemberMapper;


public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private MemberMapper dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      logger.info("username�� �α��ν� �Է��� �� : " + username);
	      Member users = dao.isId(username);
	      
	      if(users == null) {
	         logger.info("username"+ username+"not found");
	         throw new UsernameNotFoundException("username "+username+" not found");
	      }

	
	
	//1. ������ �޼��带 �߰��մϴ�.
	
	//2. ������ �޼��带 �������̵� �� �� �Ű����� username�� �ش��ϴ� �ο츦 ������ ���̽��� ���� ���� �� Member�� �����մϴ�.
	
	//GrantedAuthority : ���� ��ü�� �ο��� ������ ��Ÿ���� ���� �������̽��� �̸� ������ ����ü�� �����ڿ� ������ ���ڿ��� �־��ָ� �˴ϴ�.
	//SimpleGrantedAuthority : GrantedAuthority�� ����ü�Դϴ�.
	//Collection<? extends GrantedAuthority> authorities
	Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
	
	roles.add(new SimpleGrantedAuthority(users.getAuth()));
	
	UserDetails user = new User(username, users.getPassword(), roles);
	
	return user;
	}
}
