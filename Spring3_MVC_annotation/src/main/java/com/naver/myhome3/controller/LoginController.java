package com.naver.myhome3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome3.model.BbsBean;

/*
 	1. @Controller �ֳ����̼��� ����� ��Ʈ�ѷ� Ŭ������ �̿��ؼ� Ư�� ��û URL�� ó���մϴ�.
 	2. @Component�� ����� @Controller�� @Controller�� ���� Ŭ������ ��ü�� �޸𸮿� �����ϴ� ����� �����մϴ�.
 	3. �ܼ��� ��ü�� �����ϴ� �Ϳ� ��ġ�� �ʰ� DispatcherServlet�� �ν��ϴ� Contoroller��ü�� ����� �ݴϴ�.
 	4. ������ �����̳ʴ� @Controller�� ����� ��ü�� �ڵ����� Controller ��ü�� �ν��մϴ�.
 */
@Controller
public class LoginController {
	/*
	 	1. @RequestMapping �ֳ����̼��� ����ؼ� �޼��忡 ó���� ��û ��θ� �����մϴ�.
	 		value="��û ���", method�� ���� ��� �����մϴ�.
	 		
	 	2. @RequestMapping �ڿ��� �ݵ�� �޼��尡 ���;� �ϰ� �ڵ� ȣ�� �˴ϴ�.
	 	
	 	3. �޼��� �̸��� �ٸ� �޼���� �ߺ����� �ʰԸ� �ۼ��մϴ�.
	 	
	 	4. post��İ� get����� ��� ������ ��쿡��
	 		method={RequestMethod.POST, RequestMethod.GET} �Ǵ� �����մϴ�.	
	 */
	//http://localhost:8088/myhome/login
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "login/loginForm"; // WEB-INF/views/login/loginForm.jsp �̰����� �̵��ض�
	}
	
	/*
	 	ModelAndView �̿��ؼ� ������ ���� ���
	 		�� ���������� Model ��ü�� ��Ʈ�ѷ����� ������ �����͸� ��Ƽ� jsp �������� �����ϴ� ������ �մϴ�.
	 		�� �������� request.setAttribute()�� ������ ������ �մϴ�.
	 		�� ������ �����Ϳ� View ������ ������ �Ѳ����� ������ �� �ִ� ��ü�� ModelAndView�Դϴ�.
	 		�� ModelAndView���� �����͸� ������ �� ����ϴ� �޼���� addOvject(String, Object)�Դϴ�.
	 */
	
	//@RequestMapping(value = "/login_ok1.do",method = RequestMethod.POST)
	public ModelAndView login_ok(HttpServletRequest request, ModelAndView mv) {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		BbsBean bbs = new BbsBean();
		bbs.setId(id);
		bbs.setPass(pass);
		
		mv.setViewName("login/list"); //WEB-INF/views/login/list.jsp
		mv.addObject("bkey" , bbs);
		
		/*
		 	addObject�� ù ��° �Ű������� Ű(Key), �� ��° �Ű������� ��(Value)�� �ǹ��մϴ�.
		 	bbs�� id�� ��й�ȣ�� ����Ǿ� �ִ� VO ��ü �Դϴ�.
		 	ModelAndView�� ���� ������ ���� WEB-INF/views/login/list.jsp���� EL�� ��Ÿ�� �� �ֽ��ϴ�.
		 	ID : ${bkey.id} <br>
		    ��й�ȣ : ${bkey.pass} <br>
        */
		return mv;
		/*
		 	��ȯ���� ModelAndView, String�� ��� �⺻�� ������ ����̶� �ּҰ� ������� �ʰ�
		 	View��ü(jsp)�� ����� Ȯ���� �� �ֽ��ϴ�.
		 	
		 	WEB-INF/views/login/list.jsp�� ������ �������� �������Ǿ� �ּҴ�
		 	http://localhost:8088/myhome/login_ok1.do�� ��Ÿ���ϴ�.
		 	�����̷�Ʈ�� ���ϸ� 'redirect:'��� ���λ縦 ���Դϴ�.
		*/
	}
	
	/*
	 	Model �̿��ؼ� ������ ���� ���
	 	�� View�������� ���� ������ ��ȯ�� String�� ��Ÿ���ϴ�.
	 		���� ���� ����� ����ϴ�.
	 */
	@RequestMapping(value = "/login_ok1.do",method = RequestMethod.POST)
	public String login_ok1(HttpServletRequest request, Model mv) {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		BbsBean bbs = new BbsBean();
		bbs.setId(id);
		bbs.setPass(pass);
		
		mv.addAttribute("bkey" , bbs);

		return "login/list";

	}
}
