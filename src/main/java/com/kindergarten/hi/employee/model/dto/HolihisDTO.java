package com.kindergarten.hi.employee.model.dto;

import java.sql.Date;

public class HolihisDTO {
	
	private String process;
	private Date time;
	private String holiNo;
	private Date inTime;
	
	public HolihisDTO() {
	}
	public HolihisDTO(String process, Date time, String holiNo, Date inTime) {
		super();
		this.process = process;
		this.time = time;
		this.holiNo = holiNo;
		this.inTime = inTime;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getHoliNo() {
		return holiNo;
	}
	public void setHoliNo(String holiNo) {
		this.holiNo = holiNo;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@Override
	public String toString() {
		return "HolihisDTO [process=" + process + ", time=" + time + ", holiNo=" + holiNo + ", inTime=" + inTime + "]";
	}
	
	
}
