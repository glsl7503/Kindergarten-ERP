package com.kindergarten.hi.login.model.dao;

import com.kindergarten.hi.login.model.dto.LoginEmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {

    LoginEmployeeDTO findLoginEmployeeById(String empId);
}
