package com.kindergarten.hi.notice.model.dto;

import java.util.Date;

import com.kindergarten.hi.employee.model.dto.EmployeeDTO;

public class NoticeDTO {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private java.util.Date noticeEnrolldate;
	private java.util.Date noticeUpdatedate;
	private String viewCount;
	private int no;
	private NoticeEmployeeDTO employeeDTO;

	public NoticeDTO() {
	}

	public NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, Date noticeEnrolldate,
			Date noticeUpdatedate, String viewCount, int no, NoticeEmployeeDTO employeeDTO) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeEnrolldate = noticeEnrolldate;
		this.noticeUpdatedate = noticeUpdatedate;
		this.viewCount = viewCount;
		this.no = no;
		this.employeeDTO = employeeDTO;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public java.util.Date getNoticeEnrolldate() {
		return noticeEnrolldate;
	}

	public void setNoticeEnrolldate(java.util.Date noticeEnrolldate) {
		this.noticeEnrolldate = noticeEnrolldate;
	}

	public java.util.Date getNoticeUpdatedate() {
		return noticeUpdatedate;
	}

	public void setNoticeUpdatedate(java.util.Date noticeUpdatedate) {
		this.noticeUpdatedate = noticeUpdatedate;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public NoticeEmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(NoticeEmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeEnrolldate=" + noticeEnrolldate + ", noticeUpdatedate=" + noticeUpdatedate + ", viewCount="
				+ viewCount + ", no=" + no + ", employeeDTO=" + employeeDTO + "]";
	}

	
}
