package com.kindergarten.hi.mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindergarten.hi.lessons.model.service.LessonsService;
import com.kindergarten.hi.mypage.model.service.MyPageService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/*
	 * private final MyPageService myPageService;
	 * 
	 * @Autowired public MyPageController(MyPageService myPageService) {
	 * this.myPageService = myPageService; }
	 */
	
	@GetMapping("/gomypage")
	public String goMypage() {
		
		return "mypage/mypage";
	}
	
	@GetMapping("/pwdupdate")
	public String gopwdupdate() {
		
		return "mypage/pwdupdate";
	}
	
	@GetMapping("/personaldataupdate")
	public String gopersonaldataupdate() {
		
		return "mypage/personaldataupdate";
	}
	
//	@PostMapping(value = "/pwd/check", produces = "application/json; charset=UTF-8")
//	@ResponseBody
//	public String pwdCheck(HttpServletRequest request) {
//		
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("pwd > " + pwd );
//		
//		/*
//		 * @Autowired BCryptPasswordEncoder pwEncoding; pwEncoding.encode(pwd);
//		 * new_user_info.put("pw", passwordEncoder.encode(params.getString("pw")));
//		 * 
//		 * sekect pwd from emp where idx = 15
//		 * 
//		 * Stirng slect pwd = adasdsadasfnuqe219749gsdbkh338 t1y3o
//		 * 
//		 * boolean ispw = pwEncoding.matches(pw, ori_pw);
//		 */
//		
//		String data = "";
//		return data;
//	}


}
