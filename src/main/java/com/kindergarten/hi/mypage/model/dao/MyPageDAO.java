package com.kindergarten.hi.mypage.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kindergarten.hi.employee.model.dto.EmplAuthDTO;
import com.kindergarten.hi.employee.model.dto.EmployeeDTO;

@Mapper
public interface MyPageDAO {

	String pwdCheckBySelect(String id);

	int newPwdUpdate(String newpwd, String userId);

	int updatePersonal(EmployeeDTO employeeDTO, int empNo);

	int updateAuthNum(EmplAuthDTO emplAuthDTO, int empNo);

	String selectMemberById(String userId);

}
