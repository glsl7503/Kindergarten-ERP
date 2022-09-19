package com.kindergarten.hi.lessons.model.dto;

public class ClassPersonnelDTO {
	private int cpIdx;				//반인원인덱스
	private int classIdx;			//반인덱스
	private int wonClassNo;			//학생번호
	
	private ClassKindDTO classKindDTO; //table 반
	
	public ClassPersonnelDTO() {}

	public ClassPersonnelDTO(int cpIdx, int classIdx, int wonClassNo, ClassKindDTO classKindDTO) {
		super();
		this.cpIdx = cpIdx;
		this.classIdx = classIdx;
		this.wonClassNo = wonClassNo;
		this.classKindDTO = classKindDTO;
	}

	public int getCpIdx() {
		return cpIdx;
	}

	public void setCpIdx(int cpIdx) {
		this.cpIdx = cpIdx;
	}

	public int getClassIdx() {
		return classIdx;
	}

	public void setClassIdx(int classIdx) {
		this.classIdx = classIdx;
	}

	public int getWonClassNo() {
		return wonClassNo;
	}

	public void setWonClassNo(int wonClassNo) {
		this.wonClassNo = wonClassNo;
	}

	public ClassKindDTO getClassKindDTO() {
		return classKindDTO;
	}

	public void setClassKindDTO(ClassKindDTO classKindDTO) {
		this.classKindDTO = classKindDTO;
	}

	@Override
	public String toString() {
		return "ClassPersonnelDTO [cpIdx=" + cpIdx + ", classIdx=" + classIdx + ", wonClassNo=" + wonClassNo
				+ ", classKindDTO=" + classKindDTO + "]";
	}
	
}
