package com.kindergarten.hi.employee.model.dto;

import java.util.Date;

public class CalenderEmployeeDTO {
	private int id;
	private String title;
	private Date start;
	private Date end;
	private int no;
	
	public CalenderEmployeeDTO() {}

	public CalenderEmployeeDTO(int id, String title, Date start, Date end, int no) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.no = no;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "CalenderEmployeeDTO [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + ", no=" + no
				+ "]";
	}

}