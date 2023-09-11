package com.naver.myhome3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * @EnableWebMvc : Spring Mvc �� ������ �� �ʿ��� �� �������� �ڵ����� ���ݴϴ�.
 * WebMvcConfigurer : @EnableWebMvc�� ���� Ȱ��ȭ�� Spring MVC�� ����
 * 						Java ��� ������ ����� �����ϱ� ���� �ݹ� �޼ҵ带 �����մϴ�.
 */
@EnableWebMvc
@ComponentScan(basePackages= {"com.naver.myhome3"})
public class ServletConfig implements WebMvcConfigurer{ // ������ servlet-context.xml���� ������ �͵���
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	//<resources mapping="/resources/**" location="/resources/" />
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}