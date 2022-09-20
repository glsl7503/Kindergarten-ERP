package com.kindergarten.hi.mypage.model.service;

import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;

public interface MyPageService {

	int pwdCheck(String id, String pwd);

	int newPwdUpdate(String newpwd, String userId);

	int updatePersonal(EmployeeDTO employeeDTO, EmplAuthDTO emplAuthDTO, int empNo);

	boolean selectMemberById(String id);
}
