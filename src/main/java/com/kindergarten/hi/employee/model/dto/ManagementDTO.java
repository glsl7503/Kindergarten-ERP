package com.kindergarten.hi.employee.model.dto;

import java.sql.Date;

public class ManagementDTO {


	private int no;
	private String mananame;
	private Date writedate;
	private String sort;
	private String pre;
	private String mainreason;
	private String noreason;
	private String pro_yn;
	private String del_yn;
	private int emp_no;
	
	public ManagementDTO() {}

	public ManagementDTO(int no, String mananame, Date writedate, String sort, String pre, String mainreason,
			String noreason, String pro_yn, String del_yn, int emp_no) {
		super();
		this.no = no;
		this.mananame = mananame;
		this.writedate = writedate;
		this.sort = sort;
		this.pre = pre;
		this.mainreason = mainreason;
		this.noreason = noreason;
		this.pro_yn = pro_yn;
		this.del_yn = del_yn;
		this.emp_no = emp_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMananame() {
		return mananame;
	}

	public void setMananame(String mananame) {
		this.mananame = mananame;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getMainreason() {
		return mainreason;
	}

	public void setMainreason(String mainreason) {
		this.mainreason = mainreason;
	}

	public String getNoreason() {
		return noreason;
	}

	public void setNoreason(String noreason) {
		this.noreason = noreason;
	}

	public String getPro_yn() {
		return pro_yn;
	}

	public void setPro_yn(String pro_yn) {
		this.pro_yn = pro_yn;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	@Override
	public String toString() {
		return "ManagementDTO [no=" + no + ", mananame=" + mananame + ", writedate=" + writedate + ", sort=" + sort
				+ ", pre=" + pre + ", mainreason=" + mainreason + ", noreason=" + noreason + ", pro_yn=" + pro_yn
				+ ", del_yn=" + del_yn + ", emp_no=" + emp_no + "]";
	}
	
	
}

	