package com.kindergarten.hi.student.model.dto;

import java.sql.Date;
import java.util.List;

public class StudentDTO {
	private String name;
	private int wClass;
	private java.sql.Date birth;
	private String resident;
	private String phone;
	private int no;
	private java.sql.Date admission;
	private String exit;
	private String spac;
	private String adderss;
	private int empNo;
	private Employee1DTO employee;
	private ClassDTO classDTO;
	private ParentsDTO parents;
	private List<AttendanceDTO> attendence;
	
	public StudentDTO() {}

	public StudentDTO(String name, int wClass, Date birth, String resident, String phone, int no, Date admission,
			String exit, String spac, String adderss, int empNo, Employee1DTO employee, ClassDTO classDTO,
			ParentsDTO parents, List<AttendanceDTO> attendence) {
		super();
		this.name = name;
		this.wClass = wClass;
		this.birth = birth;
		this.resident = resident;
		this.phone = phone;
		this.no = no;
		this.admission = admission;
		this.exit = exit;
		this.spac = spac;
		this.adderss = adderss;
		this.empNo = empNo;
		this.employee = employee;
		this.classDTO = classDTO;
		this.parents = parents;
		this.attendence = attendence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getwClass() {
		return wClass;
	}

	public void setwClass(int wClass) {
		this.wClass = wClass;
	}

	public java.sql.Date getBirth() {
		return birth;
	}

	public void setBirth(java.sql.Date birth) {
		this.birth = birth;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public java.sql.Date getAdmission() {
		return admission;
	}

	public void setAdmission(java.sql.Date admission) {
		this.admission = admission;
	}

	public String getExit() {
		return exit;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}

	public String getSpac() {
		return spac;
	}

	public void setSpac(String spac) {
		this.spac = spac;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Employee1DTO getEmployee() {
		return employee;
	}

	public void setEmployee(Employee1DTO employee) {
		this.employee = employee;
	}

	public ClassDTO getClassDTO() {
		return classDTO;
	}

	public void setClassDTO(ClassDTO classDTO) {
		this.classDTO = classDTO;
	}

	public ParentsDTO getParents() {
		return parents;
	}

	public void setParents(ParentsDTO parents) {
		this.parents = parents;
	}

	public List<AttendanceDTO> getAttendence() {
		return attendence;
	}

	public void setAttendence(List<AttendanceDTO> attendence) {
		this.attendence = attendence;
	}

	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", wClass=" + wClass + ", birth=" + birth + ", resident=" + resident
				+ ", phone=" + phone + ", no=" + no + ", admission=" + admission + ", exit=" + exit + ", spac=" + spac
				+ ", adderss=" + adderss + ", empNo=" + empNo + ", employee=" + employee + ", classDTO=" + classDTO
				+ ", parents=" + parents + ", attendence=" + attendence + "]";
	}
	

	
}
