package com.kindergarten.hi.student.model.dto;

public class ParentsDTO {
	
	private int no;
	private String name;
	private String phone;
	private String choice;
	
	public ParentsDTO() {}

	public ParentsDTO(int no, String name, String phone, String choice) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.choice = choice;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "ParentsDTO [no=" + no + ", name=" + name + ", phone=" + phone + ", choice=" + choice + "]";
	}
	
	
	
	

}
