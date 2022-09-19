package com.kindergarten.hi.student.model.dto;

public class ClassDTO {
	
	private int no;
	private String name;
	private int empno;
	private StudentDTO student;
	
	public ClassDTO() {}

	public ClassDTO(int no, String name, int empno, StudentDTO student) {		
		this.no = no;
		this.name = name;
		this.empno = empno;
		this.student = student;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "ClassDTO [no=" + no + ", name=" + name + ", empno=" + empno + ", student=" + student + "]";
	}
	
	

}
