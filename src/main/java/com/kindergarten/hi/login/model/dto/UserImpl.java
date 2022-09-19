package com.kindergarten.hi.login.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/* 스프링 시큐리티의 principal 객체에서 더 구체적인 정보를 얻기 위해 확장된 User객체 생성용 클래스 */
public class UserImpl extends User {

	private int empNo;
	private String empId;
	private String empName;
	private java.util.Date empBirth;
	private String empPwd;
	private java.util.Date empEndate;
	private String empEmail;
	private String empAddre;
	private String empPhone;
	private String empSalary;
	private String empResign;
	private java.util.Date empResigndate;

    private List<LoginEmployeeRoleDTO> loginEmployeeRoleList;		// 회원별권한리스트

    public UserImpl(String empName, String empPwd, Collection<? extends GrantedAuthority> authorities) {
        super(empName, empPwd, authorities);
    }

    /* mapper 객체를 전달받아 필드를 다 초기화해주는 메소드 작성 */
    public void setDetails(LoginEmployeeDTO loginEmployee){

        this.empNo = loginEmployee.getEmpNo();
        this.empId = loginEmployee.getEmpId();
        this.empName = loginEmployee.getEmpName();
        this.empBirth = loginEmployee.getEmpBirth();
        this.empPwd = loginEmployee.getEmpPwd();
        this.empEndate = loginEmployee.getEmpEndate();
        this.empEmail = loginEmployee.getEmpEmail();
        this.empAddre = loginEmployee.getEmpAddre();
        this.empPhone = loginEmployee.getEmpPhone();
        this.empSalary = loginEmployee.getEmpSalary();
        this.empResign = loginEmployee.getEmpResign();
        this.empResigndate = loginEmployee.getEmpResigndate();
        this.loginEmployeeRoleList = loginEmployee.getLoginEmployeeRoleList();
    }

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public java.util.Date getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(java.util.Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public java.util.Date getEmpEndate() {
		return empEndate;
	}

	public void setEmpEndate(java.util.Date empEndate) {
		this.empEndate = empEndate;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpAddre() {
		return empAddre;
	}

	public void setEmpAddre(String empAddre) {
		this.empAddre = empAddre;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpResign() {
		return empResign;
	}

	public void setEmpResign(String empResign) {
		this.empResign = empResign;
	}

	public java.util.Date getEmpResigndate() {
		return empResigndate;
	}

	public void setEmpResigndate(java.util.Date empResigndate) {
		this.empResigndate = empResigndate;
	}

	public List<LoginEmployeeRoleDTO> getLoginEmployeeRoleList() {
		return loginEmployeeRoleList;
	}

	public void setLoginEmployeeRoleList(List<LoginEmployeeRoleDTO> loginEmployeeRoleList) {
		this.loginEmployeeRoleList = loginEmployeeRoleList;
	}

	@Override
	public String toString() {
		return "UserImpl [empNo=" + empNo + ", empId=" + empId + ", empName=" + empName + ", empBirth=" + empBirth
				+ ", empPwd=" + empPwd + ", empEndate=" + empEndate + ", empEmail=" + empEmail + ", empAddre="
				+ empAddre + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empResign=" + empResign
				+ ", empResigndate=" + empResigndate + ", loginEmployeeRoleList=" + loginEmployeeRoleList + "]";
	}

	
}
