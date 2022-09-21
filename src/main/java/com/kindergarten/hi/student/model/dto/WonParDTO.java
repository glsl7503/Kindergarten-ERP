package com.kindergarten.hi.student.model.dto;

public class WonParDTO {

	private int wonClassNo;
	private int ParentsNo;
	
	public WonParDTO() {}
	
	public WonParDTO(int wonClassNo, int parentsNo) {

		this.wonClassNo = wonClassNo;
		ParentsNo = parentsNo;
	}
	public int getWonClassNo() {
		return wonClassNo;
	}
	public void setWonClassNo(int wonClassNo) {
		this.wonClassNo = wonClassNo;
	}
	public int getParentsNo() {
		return ParentsNo;
	}
	public void setParentsNo(int parentsNo) {
		ParentsNo = parentsNo;
	}
	
	@Override
	public String toString() {
		return "WonParDTO [wonClassNo=" + wonClassNo + ", ParentsNo=" + ParentsNo + "]";
	}
}
