package com.kindergarten.hi.login.model.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kindergarten.hi.login.model.dao.LoginDAO;
import com.kindergarten.hi.login.model.dto.AuthorityDTO;
import com.kindergarten.hi.login.model.dto.LoginEmployeeDTO;
import com.kindergarten.hi.login.model.dto.LoginEmployeeRoleDTO;
import com.kindergarten.hi.login.model.dto.UserImpl;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginDAO loginDAO;

    @Autowired
    public LoginServiceImpl(LoginDAO loginDAO){

        this.loginDAO = loginDAO;
    }

    /* 사용자가 입력한 아이디를 토대로 해당 회원을 조회한 후 UserDetails 객체 타입의 User객체를 만들어서
    *  반환하는 메소드
    * */
    @Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {

        LoginEmployeeDTO loginEmployee = loginDAO.findLoginEmployeeById(empId);

        /* 사용자가 입력한 아이디로 조회가 안될 경우 NPE(NullPointerException) 방지를 위해 빈 MemberDTO 객체를 생성 */
        if(loginEmployee == null){
        	loginEmployee = new LoginEmployeeDTO();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(loginEmployee.getLoginEmployeeRoleList() != null) {
            List<LoginEmployeeRoleDTO> roleList = loginEmployee.getLoginEmployeeRoleList();

            for(int i = 0; i < roleList.size(); i++) {

                AuthorityDTO authority = roleList.get(i).getAuthority();
                authorities.add(new SimpleGrantedAuthority(authority.getAuthName()));
            }
        }

        UserImpl user = new UserImpl(loginEmployee.getEmpId(), loginEmployee.getEmpPwd(), authorities);
        user.setDetails(loginEmployee);
        return user;
    }

	
}
