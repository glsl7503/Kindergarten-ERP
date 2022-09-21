package com.kindergarten.hi.mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.login.model.dto.UserImpl;
import com.kindergarten.hi.mypage.model.service.MyPageService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final MyPageService myPageService;
	private final BCryptPasswordEncoder pwEncoding;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public MyPageController(MyPageService myPageService, BCryptPasswordEncoder pwEncoding, PasswordEncoder passwordEncoder) {
		
		this.myPageService = myPageService;
		this.pwEncoding = pwEncoding;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/gomypage")
	public String goMypage() {
		
		return "mypage/mypage";
	}
	
	@GetMapping("/pwdupdate")
	public String gopwdupdate() {
		
		return "mypage/pwdupdate";
	}
	
	@PostMapping("/pwdupdate2")
	public String gopwdupdate2(HttpServletRequest request,@AuthenticationPrincipal UserImpl user, RedirectAttributes rttr) {  
		
		String userId = user.getEmpId();
		
		String newpwd = passwordEncoder.encode(request.getParameter("newpwd"));
		
		myPageService.newPwdUpdate(newpwd, userId);
		
		return "redirect:/main";
	}
	
	@GetMapping("/personaldataupdate")
	public String gopersonaldataupdate() {
		
		return "mypage/personaldataupdate";
	}
	
	@PostMapping("/personaldataupdate2")
	public String gopersonaldataupdate2(@AuthenticationPrincipal UserImpl user, HttpServletRequest request, @ModelAttribute EmployeeDTO employeeDTO,@ModelAttribute EmplAuthDTO emplAuthDTO, RedirectAttributes rttr) {
		
		int empNo = user.getEmpNo();
		String address = request.getParameter("zipcode") + " " + employeeDTO.getAddre() + " " + request.getParameter("addre2") + " " + request.getParameter("addre3");
		System.out.println(address);
		int value = Integer.parseInt(request.getParameter("value"));
		String phone = request.getParameter("phone");
		System.out.println(phone);
//		employeeDTO.setPhone(employeeDTO.getPhone().replace("-", ""));
		System.out.println(value);
		emplAuthDTO.setAuthNum(value);
		
		employeeDTO.setAddre(address);
		employeeDTO.setPhone(phone);
		System.out.println(employeeDTO);
		System.out.println(emplAuthDTO);
		System.out.println(employeeDTO.getPwd());
		System.out.println(employeeDTO.getId());
		System.out.println(value);
		employeeDTO.setEmail(employeeDTO.getEmail()+"@"+request.getParameter("email2"));
		int result = myPageService.updatePersonal(employeeDTO, emplAuthDTO, empNo);
		rttr.addFlashAttribute("message", "개인정보 수정에 성공하였습니다.");
		
		return "redirect:/main";
	}
	
	@PostMapping(value = "/pwd/check", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public int pwdCheck(HttpServletRequest request, @AuthenticationPrincipal UserImpl user) {
		
		String pwd = request.getParameter("pwd");
		String id = request.getParameter("id");
		
		System.out.println("pwd > " + pwd );
		System.out.println("id > " + id );
		
		int result = myPageService.pwdCheck(id, pwd);
//		
		System.out.println("reuslt > " + result);
		
//		user.put("pwd", pwEncoding.encode(params.getString("pwd")));
		
//		new_user_info.put("pwd", passwordEncoder.encode(params.getString("pwd")));
		/*
		 * 
		 * 
		 * sekect pwd from emp where idx = 15
		 * 
		 * Stirng slect pwd = adasdsadasfnuqe219749gsdbkh338 t1y3o
		 * 
		 * boolean ispw = pwEncoding.matches(pw, ori_pw);
		 */
		
		String data = "";
		return result;
	}

//    @PostMapping(value = "/idDupCheck", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public ResponseEntity<String> checkDuplication(@RequestBody EmployeeDTO employeeDTO) throws JsonProcessingException {
//
//        String result = "사용 가능한 아이디 입니다.";
//        log.info("[MemberController] Request Check ID : " + employeeDTO.getId());
//
//        if("".equals(employeeDTO.getId())) {
//            result = "아이디를 입력해 주세요";
//        } else if(myPageService.selectMemberById(employeeDTO.getId())) {
//            result = "중복된 아이디가 존재합니다.";
//        }
//
//        log.info("[MemberController] checkDuplication ==========================================================");
//
//        return ResponseEntity.ok(result);
//    }
	
}
