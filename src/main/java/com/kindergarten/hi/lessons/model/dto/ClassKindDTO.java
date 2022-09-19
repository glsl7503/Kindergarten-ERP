package com.kindergarten.hi.lessons.model.dto;

public class ClassKindDTO {
	private int classIdx;			//반인덱스
	private String className;		//반명
	private int empNo;			    //직원번호
	
	private LesEmployeeDTO lesEmployeeDTO;	// table 직원
	
	public ClassKindDTO() {}

	public ClassKindDTO(int classIdx, String className, int empNo, LesEmployeeDTO lesEmployeeDTO) {
		super();
		this.classIdx = classIdx;
		this.className = className;
		this.empNo = empNo;
		this.lesEmployeeDTO = lesEmployeeDTO;
	}

	public int getClassIdx() {
		return classIdx;
	}

	public void setClassIdx(int classIdx) {
		this.classIdx = classIdx;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public LesEmployeeDTO getLesEmployeeDTO() {
		return lesEmployeeDTO;
	}

	public void setLesEmployeeDTO(LesEmployeeDTO lesEmployeeDTO) {
		this.lesEmployeeDTO = lesEmployeeDTO;
	}

	@Override
	public String toString() {
		return "ClassKindDTO [classIdx=" + classIdx + ", className=" + className + ", empNo=" + empNo
				+ ", lesEmployeeDTO=" + lesEmployeeDTO + "]";
	}
	
}
