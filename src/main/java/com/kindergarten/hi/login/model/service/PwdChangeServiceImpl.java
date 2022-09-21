package com.kindergarten.hi.login.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kindergarten.hi.employee.model.dto.EmployeeDTO;
import com.kindergarten.hi.login.model.dao.LoginDAO;

@Service
public class PwdChangeServiceImpl implements PwdChangeService {

	private LoginDAO loginDAO;

    @Autowired
    public PwdChangeServiceImpl(LoginDAO loginDAO){

        this.loginDAO = loginDAO;
    }
	
	@Override
	@Transactional
	public int pwdchange(EmployeeDTO employeeDTO) {
		System.out.println("sev : " + employeeDTO);
		int result = loginDAO.pwdchange(employeeDTO);
		
		return result;
	}
}
