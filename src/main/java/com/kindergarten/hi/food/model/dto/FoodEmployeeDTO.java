package com.kindergarten.hi.food.model.dto;

import java.sql.Date;

public class FoodEmployeeDTO {
	private int empNo;                     //직원번호
	private String empId;				   //아이디
	private String empName;				   //이름
	private Date empBirth;				   //생일
	private String empPwd;				   //비밀번호
	private String empEndate;			   //입사일
	private String empEmail;			   //이메일
	private String empAddre;			   //주소
	private String empPhone;			   //전화번호
	private String empSalary;			   //급여
	private String empResign;			   //퇴사여부
	private Date empResignDate;			   //퇴사일
	
	public FoodEmployeeDTO() {}

	public FoodEmployeeDTO(int empNo, String empId, String empName, Date empBirth, String empPwd, String empEndate,
			String empEmail, String empAddre, String empPhone, String empSalary, String empResign, Date empResignDate) {
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
		this.empResignDate = empResignDate;
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

	public Date getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpEndate() {
		return empEndate;
	}

	public void setEmpEndate(String empEndate) {
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

	public Date getEmpResignDate() {
		return empResignDate;
	}

	public void setEmpResignDate(Date empResignDate) {
		this.empResignDate = empResignDate;
	}

	@Override
	public String toString() {
		return "LesEmployeeDTO [empNo=" + empNo + ", empId=" + empId + ", empName=" + empName + ", empBirth=" + empBirth
				+ ", empPwd=" + empPwd + ", empEndate=" + empEndate + ", empEmail=" + empEmail + ", empAddre="
				+ empAddre + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empResign=" + empResign
				+ ", empResignDate=" + empResignDate + "]";
	}
	
}
