package com.kindergarten.hi.notice.model.dto;

public class NoticeEmployeeDTO {

	private String empName;

	public NoticeEmployeeDTO() {
	}

	public NoticeEmployeeDTO(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empName=" + empName + "]";
	}
	
	
}
