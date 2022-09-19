package com.kindergarten.hi.item.model.dto;

import java.sql.Date;

import com.kindergarten.hi.employee.model.dto.EmployeeDTO;

public class ItemManagementHisDTO {

	private int processIn;
	private java.sql.Date time;
	private int processOut;
	private int processNo;
	private int empNo;
	
	private EmployeeDTO employee;

	public ItemManagementHisDTO() {
	
	}

	public ItemManagementHisDTO(int processIn, Date time, int processOut, int processNo, int empNo,
			EmployeeDTO employee) {
		super();
		this.processIn = processIn;
		this.time = time;
		this.processOut = processOut;
		this.processNo = processNo;
		this.empNo = empNo;
		this.employee = employee;
	}

	public int getProcessIn() {
		return processIn;
	}

	public void setProcessIn(int processIn) {
		this.processIn = processIn;
	}

	public java.sql.Date getTime() {
		return time;
	}

	public void setTime(java.sql.Date time) {
		this.time = time;
	}

	public int getProcessOut() {
		return processOut;
	}

	public void setProcessOut(int processOut) {
		this.processOut = processOut;
	}

	public int getProcessNo() {
		return processNo;
	}

	public void setProcessNo(int processNo) {
		this.processNo = processNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ItemManagementHisDTO [processIn=" + processIn + ", time=" + time + ", processOut=" + processOut
				+ ", processNo=" + processNo + ", empNo=" + empNo + ", employee=" + employee + "]";
	}

	
	
	
	
}
