package com.kindergarten.hi.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.mypage.model.dao.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService{

	private final MyPageDAO myPageDAO;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MyPageServiceImpl(MyPageDAO myPageDAO, BCryptPasswordEncoder passwordEncoder) {
		this.myPageDAO = myPageDAO;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public int pwdCheck(String id, String pwd) {
		
		String pwdEncode = myPageDAO.pwdCheckBySelect(id);
		
		boolean r = passwordEncoder.matches(pwd, pwdEncode);
		int result = 0;
		if(r == true) {
			result = 1;
		}
		
		return result;
	}

	@Override
	@Transactional
	public int newPwdUpdate(String newpwd, String userId) {
		
		int result = myPageDAO.newPwdUpdate(newpwd, userId);
		
		return result;
	}

	@Override
	@Transactional
	public int updatePersonal(EmployeeDTO employeeDTO, EmplAuthDTO emplAuthDTO, int empNo) {

		int result = myPageDAO.updatePersonal(employeeDTO, empNo);
		
		if(result > 0) {
			
			int result2 = myPageDAO.updateAuthNum(emplAuthDTO, empNo);
		}
		
		return result;
	}

	@Override
	public boolean selectMemberById(String userId) {

        String result = myPageDAO.selectMemberById(userId);

        return result != null? true : false;
    }
	
}
