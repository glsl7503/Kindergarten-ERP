package com.kindergarten.hi.employee.model.dto;

public class EmplAuthDTO {

	private EmployeeDTO employeeDTO;
	private int authNum;
	
	public EmplAuthDTO() {
		
	}

	public EmplAuthDTO(EmployeeDTO employeeDTO, int authNum) {
		super();
		this.employeeDTO = employeeDTO;
		this.authNum = authNum;
	}

	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	@Override
	public String toString() {
		return "EmplAuthDTO [employeeDTO=" + employeeDTO + ", authNum=" + authNum + "]";
	}

	
}
