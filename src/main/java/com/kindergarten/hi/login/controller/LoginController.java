package com.kindergarten.hi.login.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.kindergarten.hi.common.util.SessionUtil;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.login.model.service.LoginService;
import com.kindergarten.hi.login.model.service.PwdChangeService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private LoginService loginService;
	private PwdChangeService pwdChangeService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;


	@Autowired
	public LoginController(LoginService loginService,PwdChangeService pwdChangeService, PasswordEncoder passwordEncoder) {
		this.loginService = loginService;
		this.pwdChangeService = pwdChangeService;
		this.passwordEncoder = passwordEncoder;
	}

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
	
	@PostMapping("/pwdchange")
	public String pwdchange(@ModelAttribute EmployeeDTO employeeDTO, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) {
		System.out.println(employeeDTO);
		System.out.println(employeeDTO.getPwd());
		employeeDTO.setPwd(passwordEncoder.encode(employeeDTO.getPwd()));
		employeeDTO.setEmail(employeeDTO.getEmail() + "@" + request.getParameter("email2"));
		employeeDTO.setNo(0);
		System.out.println(employeeDTO);
		int result = pwdChangeService.pwdchange(employeeDTO);
		
		// 회원정보 수정후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 정보 수정에 성공하셨습니다. 다시 로그인해주세요.");

//		employeeDTO.setEmail(employeeDTO.getEmail() + "@" + request.getParameter("email2"));
//		System.out.println("employeeDTO :: " + employeeDTO);
		return "redirect:/";
	}
	
//	@PostMapping("/idsearch2")
//	public String goIdsearch2() {
//		
//	}
}
