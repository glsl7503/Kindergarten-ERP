package com.kindergarten.hi.payment.model.dto;

import java.sql.Date;

public class PaymentManagementHisDTO {
	private int expeNo;
	private String process;
	private java.sql.Date processTime;
	private java.sql.Date submitTime;
	public PaymentManagementHisDTO(int expeNo, String process, Date processTime, Date submitTime) {

		this.expeNo = expeNo;
		this.process = process;
		this.processTime = processTime;
		this.submitTime = submitTime;
	}
	public PaymentManagementHisDTO() {

	}
	public int getExpeNo() {
		return expeNo;
	}
	public void setExpeNo(int expeNo) {
		this.expeNo = expeNo;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public java.sql.Date getProcessTime() {
		return processTime;
	}
	public void setProcessTime(java.sql.Date processTime) {
		this.processTime = processTime;
	}
	public java.sql.Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(java.sql.Date submitTime) {
		this.submitTime = submitTime;
	}
	@Override
	public String toString() {
		return "PaymentManagementHisDTO [expeNo=" + expeNo + ", process=" + process + ", processTime=" + processTime
				+ ", submitTime=" + submitTime + "]";
	}
	
	
}
