package com.naver.myhome4.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
 * AbstractAnnotationConfigDispatcherServletInitializer�� ��ӹ��� Ŭ������
 * ���������� AbstractAnnotationConfigDispatcherServletInitializer��
 * DispatcherServlet�� ContextLoaderListener�� �����մϴ�.
 * 
 * DispatcherServlet�� ��Ʈ�ѷ�, �� ������, �ڵ鷯 ���ΰ� ���� �� ������Ʈ�� ���Ե� ���� �ε��ϸ�,
 * ContextLoaderListener�� ���ø����̼� ���� �� ���� �ٸ� ���� �ε��մϴ�.
 */

//web.xml ����
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//�Ķ���� ���ڵ� ���� ����(�ѱ� ����)
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return new Filter[] {filter};
	}
	
	/*
	 * ContextLoaderListener�� ������ ���ø����̼� ���ؽ�Ʈ�� �����ϴ� �� ���˴ϴ�.
	 * Class<?>[]
	 * <?> : ���׸��� ����ϴ� �ڵ忡�� Ÿ�� �Ű� ������ ���� ��ȣ �� ����ǥ�� ǥ���ϸ� � Ÿ���̵��� �����մϴ�.
	 */
	protected Class<?>[] getRootConfigClasses() { // ������ root-context.xml ��� ���
		return new Class[] {RootConfig.class};
	}
	
	//DispatcherServlet�� ���ø����̼� ���ؽ�Ʈ�� ServletConfig ���� Ŭ����(java ����)���� ���ǵ� ������ �ε��ϵ��� �Ǿ� �ֽ��ϴ�.
	protected Class<?>[] getServletConfigClasses() {	//servlet-context.xml ���� �κ�
		return new Class[] {ServletConfig.class};	
	}
	
	// DispatcherServlet�� ���εǱ� ���� �н� �����մϴ�.
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//404
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

}
