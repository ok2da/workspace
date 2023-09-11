package com.naver.myhome3.RedirectAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	/*
	 * http://localhost:8088/myhome/first ���� ��
	 * => http://localhost:8088/myhome/go?attr=addAttribute
	 * 		addFlachAttribute�� ���� ������ ����ϴ� ��� : ${flash}=addFlashAttribute
	 * 		addAttribute�� ���� ������ ����ϴ� ��� : ${param.attr}=addAttribute
	 * => ���ΰ�ħ
	 *      addFlashAttribute�� ���� ������ ����ϴ� ��� : ${flash }=
	 *    	addAttribute�� ���� ������ ����ϴ� ��� : ${param.attr]=addAttribute
	 *    
	 *    addFalshAttribute()�� ��ȸ������ �����͸� �����մϴ�.
	 * 
	 */
	
	@RequestMapping(value="/first")
	public String first(RedirectAttributes rattr) {
		rattr.addFlashAttribute("flash", "addFlashAttribute");
		rattr.addAttribute("attr", "addAttribute");
		return "redirect:/go";		//redirect�� �̵��ض�
									//http://localhost:8088/myhome/go
	}
	
	@RequestMapping(value="/go")
	public String redirect() {
		return "redirect2/go"; // �������� ����
	}
	
	@RequestMapping(value="/redirectForm")
	public String redirectForm() {
		return "redirect2/loginForm";
	}
	
	@RequestMapping(value="/redirect.do")
	public String redirect_idcheck(String id, String pass, RedirectAttributes rattr) {
		int result = 1; // ���̵� ��ġ���� �ʴ� ���
		if(id.equals("java") && pass.equals("java")) {
			result = 2; // ���̵� ��� ��ġ
		}else if(id.equals("java")) {
			result = -1; // ��� �߸��� ���
		}
		
		if(result == -1 || result == 1) {
			rattr.addFlashAttribute("result", result); // http://localhost:8088/myhome/redirect
//			rattr.addAttribute("result", result); // http://localhost:8088/myhome/redirect?result=1
//			addAttribute�� ������ �α��ο� �����ص� result=1 �� ���Ƽ� ���ΰ�ħ�ϸ� ���н� ��µǴ� alert â ��			
			return "redirect:redirectForm";
		}
		return "redirect2/success";
	}
}
