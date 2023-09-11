package com.naver.myhome3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController2_int {
	   /*
	    * 1. �������
	    * Command ��ü�� ���� �Ķ���͸� ó���ϴ� ���
	    * 
	    * @RequestParam(value="age") int age
	    * �Ķ���� age�� ������ ���� age�� �����϶�� �ǹ��Դϴ�.
	    * String���� �Ѿ�δ� �Ķ������ ���� �������� ���߾� ĳ���� �մϴ�.
	    * 
	    * int age = Integer.parseInt(request.getParameter("age"));
	    */
	@RequestMapping(value = "/param1.do", method = RequestMethod.POST)
	public String param1(@RequestParam(value = "age") int age, Model model , HttpServletRequest request) {		
		
		model.addAttribute("age", age);
		model.addAttribute("url", request.getRequestURI());
		
		return "param/list1";
	}
	
	/*
	 	2. @RequestParam(value="age")���� @RequestParam(value="age2")�� ����
	 	HTTP Status 400 - Bad Request Message
	 	Required int parameter 'age2' is not present
	 */
	@RequestMapping(value = "/param2.do", method = RequestMethod.POST)
	public String param2(@RequestParam(value = "age2") int age, Model model , HttpServletRequest request) {		
		
		model.addAttribute("age", age);
		model.addAttribute("url", request.getRequestURI());
		
		return "param/list1";
	}
	
	/*
	 	400���� �߻� �ذ��
	 	Optional int parameter 'age2' is present but cannot be translated into a null
	 	value due to being declared as a primitive type
	 	required = false �� 400 ������ �߻����� ������ �Ѿ�� ���� null�̶� �̰��� �⺻�� int������ ��ȯ�ϸ鼭 500 ���� �߻�
	 */
	@RequestMapping(value = "/param3.do", method = RequestMethod.POST)
	public String param3(@RequestParam(value = "age2", required = false) int age, Model model) {		
		
		model.addAttribute("age", age);
		
		return "param/list1";
	}

	
	/*
	 * �� �������� 400�� ������ ���������� 500���� �߻��߽��ϴ�.
	 * ���� ���� ��� - age2��� �Ķ���Ͱ� ���� ��� �⺻������ 10�� �����մϴ�.
	 * @RequestParam(value = "age2", defaultValue="10", required = false) int age, Model model )
	 */
	@RequestMapping(value = "/param4.do", method = RequestMethod.POST)
	public String param4(@RequestParam(value = "age2", defaultValue = "10" , required = false) int age, Model model) {		
		
		model.addAttribute("age", age);
		
		return "param/list1";
	}
	
	//int age : �Ķ���Ϳ� ���� �̸��� ������ ������ ��� �̿� ���� �ۼ��ϸ� �˴ϴ�.
	@RequestMapping(value = "/param5.do", method = RequestMethod.POST)
	public String param5(int age, Model model, HttpServletRequest request) {		
		
		model.addAttribute("age", age);
		model.addAttribute("url", request.getRequestURI());
		
		return "param/list1";
	}
	

}
