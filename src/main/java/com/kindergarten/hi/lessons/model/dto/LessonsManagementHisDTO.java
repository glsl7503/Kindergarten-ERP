package com.kindergarten.hi.lessons.model.dto;

import java.sql.Date;

public class LessonsManagementHisDTO {
	private String process;			//처리구분
	private Date time;			//처리시간
	private int lpIdx;			//수업계획서인덱스
	private Date inTime;			//등록시간
	
	public LessonsManagementHisDTO() {}

	public LessonsManagementHisDTO(String process, Date time, int lpIdx, Date inTime) {
		super();
		this.process = process;
		this.time = time;
		this.lpIdx = lpIdx;
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

	public int getLpIdx() {
		return lpIdx;
	}

	public void setLpIdx(int lpIdx) {
		this.lpIdx = lpIdx;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	@Override
	public String toString() {
		return "LessonsManagementHisDTO [process=" + process + ", time=" + time + ", lpIdx=" + lpIdx + ", inTime="
				+ inTime + "]";
	}
	
}
