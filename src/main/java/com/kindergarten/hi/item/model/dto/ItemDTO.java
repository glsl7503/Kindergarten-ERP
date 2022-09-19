package com.kindergarten.hi.item.model.dto;

import java.sql.Date;



public class ItemDTO {
	
	private String name;
	private String category;
	private int number;
	private int price;
	private Date regdate;
	private Date update;
	private int empNo;
	private int itemNo;
	private int traderIdx;
	
	private TraderItemDTO traderitem; 
	private EmployeeItemDTO employee;
	
	public ItemDTO() {}
	

	public ItemDTO(String name, String category, int number, int price, Date regdate, Date update, int empNo,
			int itemNo, int traderIdx, TraderItemDTO traderitem, EmployeeItemDTO employee) {
		super();
		this.name = name;
		this.category = category;
		this.number = number;
		this.price = price;
		this.regdate = regdate;
		this.update = update;
		this.empNo = empNo;
		this.itemNo = itemNo;
		this.traderIdx = traderIdx;
		this.traderitem = traderitem;
		this.employee = employee;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public Date getUpdate() {
		return update;
	}


	public void setUpdate(Date update) {
		this.update = update;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}


	public int getTraderIdx() {
		return traderIdx;
	}


	public void setTraderIdx(int traderIdx) {
		this.traderIdx = traderIdx;
	}


	public TraderItemDTO getTraderitem() {
		return traderitem;
	}


	public void setTraderitem(TraderItemDTO traderitem) {
		this.traderitem = traderitem;
	}


	public EmployeeItemDTO getEmployee() {
		return employee;
	}


	public void setEmployee(EmployeeItemDTO employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "ItemDTO [name=" + name + ", category=" + category + ", number=" + number + ", price=" + price
				+ ", regdate=" + regdate + ", update=" + update + ", empNo=" + empNo + ", itemNo=" + itemNo
				+ ", traderIdx=" + traderIdx + ", traderitem=" + traderitem + ", employee=" + employee + "]";
	}

	

}
