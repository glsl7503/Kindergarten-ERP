package com.kindergarten.hi.login.model.dto;

import java.util.Date;
import java.util.List;

public class LoginEmployeeDTO {

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

    public LoginEmployeeDTO() {

    }

	public LoginEmployeeDTO(int empNo, String empId, String empName, Date empBirth, String empPwd, Date empEndate,
			String empEmail, String empAddre, String empPhone, String empSalary, String empResign, Date empResigndate,
			List<LoginEmployeeRoleDTO> loginEmployeeRoleList) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empName = empName;
		this.empBirth = empBirth;
		this.empPwd = empPwd;
		this.empEndate = empEndate;
		this.empEmail = empEmail;
		this.empAddre = empAddre;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empResign = empResign;
		this.empResigndate = empResigndate;
		this.loginEmployeeRoleList = loginEmployeeRoleList;
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
		return "LoginEmployeeDTO [empNo=" + empNo + ", empId=" + empId + ", empName=" + empName + ", empBirth=" + empBirth
				+ ", empPwd=" + empPwd + ", empEndate=" + empEndate + ", empEmail=" + empEmail + ", empAddre="
				+ empAddre + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empResign=" + empResign
				+ ", empResigndate=" + empResigndate + ", loginEmployeeRoleList=" + loginEmployeeRoleList + "]";
	}
}
