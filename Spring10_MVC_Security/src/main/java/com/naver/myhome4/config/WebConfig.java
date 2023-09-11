package com.naver.myhome4.config;


import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/*
 * AbstractAnnotationConfigDispatcherServletInitializer를 상속받은 클래스로
 * 내부적으로 AbstractAnnotationConfigDispatcherServletInitializer는
 * DispatcherServlet과 ContextLoaderListener를 생성합니다.
 * 
 * DispatcherServlet는 컨트롤러, 뷰 리졸버, 핸들러 매핑과 같은 웹 컴포넌트가 포함된 빈을 로딩하며,
 * ContextLoaderListener는 애플리케이션 내의 그 외의 다른 빈을 로딩합니다.
 */

//web.xml 역할
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//CharacterEncodingFilter 제거합니다.
	
	/*
	 * ContextLoaderListener가 생성한 애플리케이션 컨텍스트를 설정하는 데 사용됩니다.
	 * Class<?>[]
	 * <?> : 제네릭을 사용하는 코드에서 타입 매개 변수를 꺽쇠 괄호 속 물음표로 표현하면 어떤 타입이든지 가능합니다.
	 */
	protected Class<?>[] getRootConfigClasses() { // 기존의 root-context.xml 대신 사용
		return new Class[] {RootConfig.class, Security_Config.class};
	}
	
	//DispatcherServlet이 애플리케이션 컨텍스트를 ServletConfig 설정 클래스(java 설정)에서 정의된 빈으로 로딩하도록 되어 있습니다.
	protected Class<?>[] getServletConfigClasses() {	//servlet-context.xml 설정 부분
		return new Class[] {ServletConfig.class};	
	}
	
	// DispatcherServlet이 매핑되기 위한 패스 설정합니다.
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//404
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

}
