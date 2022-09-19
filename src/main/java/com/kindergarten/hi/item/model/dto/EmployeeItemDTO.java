package com.kindergarten.hi.item.model.dto;

import java.sql.Date;

public class EmployeeItemDTO {

	private int no;
    private String id;
    private String name;
    private java.sql.Date birth;
    private String pwd;
    private java.sql.Date endate;
    private String emall;
    private String addre;
    private String phone;
    private String salary;
    private String resign;
    private java.sql.Date restgndate;
    
	public EmployeeItemDTO() {}

	public EmployeeItemDTO(int no, String id, String name, Date birth, String pwd, Date endate, String emall,
			String addre, String phone, String salary, String resign, Date restgndate) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.pwd = pwd;
		this.endate = endate;
		this.emall = emall;
		this.addre = addre;
		this.phone = phone;
		this.salary = salary;
		this.resign = resign;
		this.restgndate = restgndate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
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

	public java.sql.Date getBirth() {
		return birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public java.sql.Date getEndate() {
		return endate;
	}

	public void setEndate(java.sql.Date endate) {
		this.endate = endate;
	}

	public String getEmall() {
		return emall;
	}

	public void setEmall(String emall) {
		this.emall = emall;
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

	public java.sql.Date getRestgndate() {
		return restgndate;
	}

	public void setRestgndate(java.sql.Date restgndate) {
		this.restgndate = restgndate;
	}

	@Override
	public String toString() {
		return "EmployeeItemDTO [no=" + no + ", id=" + id + ", name=" + name + ", birth=" + birth + ", pwd=" + pwd
				+ ", endate=" + endate + ", emall=" + emall + ", addre=" + addre + ", phone=" + phone + ", salary="
				+ salary + ", resign=" + resign + ", restgndate=" + restgndate + "]";
	}

	
    
}


