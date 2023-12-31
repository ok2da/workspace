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
	      logger.info("username은 로그인시 입력한 값 : " + username);
	      Member users = dao.isId(username);
	      
	      if(users == null) {
	         logger.info("username"+ username+"not found");
	         throw new UsernameNotFoundException("username "+username+" not found");
	      }

	
	
	//1. 구현할 메서드를 추가합니다.
	
	//2. 구현할 메서드를 오버라이딩 한 후 매개변수 username에 해당하는 로우를 데이터 베이스를 통해 구한 후 Member에 저장합니다.
	
	//GrantedAuthority : 인증 개체에 부여된 권한을 나타내기 위한 인터페이스로 이를 구현한 구현체는 생성자에 권한을 문자열로 넣어주면 됩니다.
	//SimpleGrantedAuthority : GrantedAuthority의 구현체입니다.
	//Collection<? extends GrantedAuthority> authorities
	Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
	
	roles.add(new SimpleGrantedAuthority(users.getAuth()));
	
	UserDetails user = new User(username, users.getPassword(), roles);
	
	return user;
	}
}
