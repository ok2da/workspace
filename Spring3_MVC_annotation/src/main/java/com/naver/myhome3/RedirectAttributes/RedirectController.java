package com.naver.myhome3.RedirectAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	/*
	 * http://localhost:8088/myhome/first 실행 후
	 * => http://localhost:8088/myhome/go?attr=addAttribute
	 * 		addFlachAttribute로 보낸 데이터 출력하는 방법 : ${flash}=addFlashAttribute
	 * 		addAttribute로 보낸 데이터 출력하는 방법 : ${param.attr}=addAttribute
	 * => 새로고침
	 *      addFlashAttribute로 보낸 데이터 출력하는 방법 : ${flash }=
	 *    	addAttribute로 보낸 데이터 출력하는 방법 : ${param.attr]=addAttribute
	 *    
	 *    addFalshAttribute()는 일회성으로 데이터를 전달합니다.
	 * 
	 */
	
	@RequestMapping(value="/first")
	public String first(RedirectAttributes rattr) {
		rattr.addFlashAttribute("flash", "addFlashAttribute");
		rattr.addAttribute("attr", "addAttribute");
		return "redirect:/go";		//redirect로 이동해라
									//http://localhost:8088/myhome/go
	}
	
	@RequestMapping(value="/go")
	public String redirect() {
		return "redirect2/go"; // 뷰페이지 정보
	}
	
	@RequestMapping(value="/redirectForm")
	public String redirectForm() {
		return "redirect2/loginForm";
	}
	
	@RequestMapping(value="/redirect.do")
	public String redirect_idcheck(String id, String pass, RedirectAttributes rattr) {
		int result = 1; // 아이디 일치하지 않는 경우
		if(id.equals("java") && pass.equals("java")) {
			result = 2; // 아이디 비번 일치
		}else if(id.equals("java")) {
			result = -1; // 비번 잘못된 경우
		}
		
		if(result == -1 || result == 1) {
			rattr.addFlashAttribute("result", result); // http://localhost:8088/myhome/redirect
//			rattr.addAttribute("result", result); // http://localhost:8088/myhome/redirect?result=1
//			addAttribute로 담으면 로그인에 실패해도 result=1 이 남아서 새로고침하면 실패시 출력되는 alert 창 뜸			
			return "redirect:redirectForm";
		}
		return "redirect2/success";
	}
}
