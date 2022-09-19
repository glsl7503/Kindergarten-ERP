package com.kindergarten.hi.payment.model.dto;

import java.sql.Date;

import com.kindergarten.hi.employee.model.dto.EmployeeDTO;




public class PaymentDTO {
	private int no;
	private String title;
	private java.sql.Date expeDate;
	private String price;
	private String dep;
	private java.sql.Date wDate;
	private String client;
	private String content;
	private String account;
	private String status;
	private int empNo;
	private String yN;
	private PaymentManagementHisDTO history;
	private EmployeeDTO employee;
	
	public PaymentDTO(int no, String title, Date expeDate, String price, String dep, Date wDate, String client,
			String content, String account, String status, int empNo, String yN, PaymentManagementHisDTO history,
			EmployeeDTO employee) {

		this.no = no;
		this.title = title;
		this.expeDate = expeDate;
		this.price = price;
		this.dep = dep;
		this.wDate = wDate;
		this.client = client;
		this.content = content;
		this.account = account;
		this.status = status;
		this.empNo = empNo;
		this.yN = yN;
		this.history = history;
		this.employee = employee;
	}
	public PaymentDTO() {

	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.sql.Date getExpeDate() {
		return expeDate;
	}
	public void setExpeDate(java.sql.Date expeDate) {
		this.expeDate = expeDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public java.sql.Date getwDate() {
		return wDate;
	}
	public void setwDate(java.sql.Date wDate) {
		this.wDate = wDate;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getyN() {
		return yN;
	}
	public void setyN(String yN) {
		this.yN = yN;
	}
	public PaymentManagementHisDTO getHistory() {
		return history;
	}
	public void setHistory(PaymentManagementHisDTO history) {
		this.history = history;
	}
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "PaymentDTO [no=" + no + ", title=" + title + ", expeDate=" + expeDate + ", price=" + price + ", dep="
				+ dep + ", wDate=" + wDate + ", client=" + client + ", content=" + content + ", account=" + account
				+ ", status=" + status + ", empNo=" + empNo + ", yN=" + yN + ", history=" + history + ", employee="
				+ employee + "]";
	}
	
	
	
	
	
	
}
