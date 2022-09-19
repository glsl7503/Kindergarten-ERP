package com.kindergarten.hi.student.model.dto;

public class AttendanceDTO {
	
	private int no;
	private int age;
	private int semester;
	private int total;
	private int att;
	private int non;
	private int late;
	private int sick;
	private int classno;
	
	public AttendanceDTO() {}

	public AttendanceDTO(int no, int age, int semester, int total, int att, int non, int late, int sick, int classno) {
		super();
		this.no = no;
		this.age = age;
		this.semester = semester;
		this.total = total;
		this.att = att;
		this.non = non;
		this.late = late;
		this.sick = sick;
		this.classno = classno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getNon() {
		return non;
	}

	public void setNon(int non) {
		this.non = non;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getSick() {
		return sick;
	}

	public void setSick(int sick) {
		this.sick = sick;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	@Override
	public String toString() {
		return "AttendanceDTO [no=" + no + ", age=" + age + ", semester=" + semester + ", total=" + total + ", att="
				+ att + ", non=" + non + ", late=" + late + ", sick=" + sick + ", classno=" + classno + "]";
	}
	
	
	

}
