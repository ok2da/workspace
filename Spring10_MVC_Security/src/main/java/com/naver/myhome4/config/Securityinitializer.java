package com.naver.myhome4.config;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;


// ������ ���� ���� Ŭ������ �߰��ϴ� ������ ���������� DelegatingFilterProxy�� �������� ����մϴ�.
public class Securityinitializer extends AbstractSecurityWebApplicationInitializer {

	//��ť��Ƽ ���� �տ� ���� ���͵��� ���ʴ�� �߰��մϴ�.
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		insertFilters(servletContext, characterEncodingFilter);
		
		MultipartFilter multipartFilter = new MultipartFilter();
		multipartFilter.setMultipartResolverBeanName("multipartResolver");
		insertFilters(servletContext, multipartFilter);
		
	}

}
