package com.kindergarten.hi.login.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/gologin")
	public String goLogin() {
		
		return "login/login";
	}
	
	@GetMapping("/idsearch")
	public String goIdsearch() {
		
		return "login/idsearch";
	}
	
	@GetMapping("/pwdsearch")
	public String goPwdsearch() {
		
		return "login/pwdsearch";
	}
	
	@PostMapping(value = "/emailSendAjax", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String emailSendAjax(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		System.out.println("email :: " + email);
		
		// 이메일 처리 로직
		// SMTP 서버 => Google, naver
		SimpleMailMessage message = new SimpleMailMessage();
		Random random = new Random();
		int authCode = random.nextInt(8888)+1111;
		
		message.setTo(email);
		message.setSubject("안녕하세요. 테스트입니다~");
		message.setText("인증코드는 "+authCode+"입니다.");
		
		mailSender.send(message);
		
		String successYn = "Y";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successYn", successYn);
		map.put("authCode", authCode);
		
		return new Gson().toJson(map);
	}
	
//	@PostMapping("/idsearch2")
//	public String goIdsearch2() {
//		
//	}
}
