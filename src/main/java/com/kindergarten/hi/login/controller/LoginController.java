package com.kindergarten.hi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/gologin")
	public String goLogin() {
		
		return "login/login";
	}
	
//	@GetMapping("/idsearch")
//	public String goIdsearch() {
//		
//		
//		
//		return "login/idsearch";
//	}
}
