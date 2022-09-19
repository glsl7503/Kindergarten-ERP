package com.kindergarten.hi.employee.model.dto;

import java.sql.Date;


public class EmployeeDTO {
	
	private Integer no;
	private String id;
	private String name;
	private Date birth;
	private String pwd;
	private Date endate;
	private String email;
	private String addre;
	private String phone;
	private String salary;
	private String resign;
	private Date resigndate;
	
	public EmployeeDTO() {}

	public EmployeeDTO(Integer no, String id, String name, Date birth, String pwd, Date endate, String email,
			String addre, String phone, String salary, String resign, Date resigndate) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.pwd = pwd;
		this.endate = endate;
		this.email = email;
		this.addre = addre;
		this.phone = phone;
		this.salary = salary;
		this.resign = resign;
		this.resigndate = resigndate;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getEndate() {
		return endate;
	}

	public void setEndate(Date endate) {
		this.endate = endate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddre() {
		return addre;
	}

	public void setAddre(String addre) {
		this.addre = addre;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getResign() {
		return resign;
	}

	public void setResign(String resign) {
		this.resign = resign;
	}

	public Date getResigndate() {
		return resigndate;
	}

	public void setResigndate(Date resigndate) {
		this.resigndate = resigndate;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [no=" + no + ", id=" + id + ", name=" + name + ", birth=" + birth + ", pwd=" + pwd
				+ ", endate=" + endate + ", email=" + email + ", addre=" + addre + ", phone=" + phone + ", salary="
				+ salary + ", resign=" + resign + ", resigndate=" + resigndate + "]";
	}

	
}
