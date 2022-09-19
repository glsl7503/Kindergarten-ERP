package com.kindergarten.hi.food.model.dto;

import java.sql.Date;

public class FoodDTO {

	private int stockIdx;                  // STOCK_IDX 음식품목 인덱스 
	private String stockTitle;             // STOCK_TITLE 음식명 
	private int stockCount;                // STOCK_COUNT 개수 
	private Date stockRegistration;        // STOCK_REGISTRATION 등록일 
	private Date stockModify;              // STOCK_MODIFY 수정일 
	private int traderIdx;                 // TRADER_IDX 거래업체 인덱스 
	private int empNo;                     // EMP_NO 직원번호 
	private int rnum;
	
	public FoodDTO() {}

	public FoodDTO(int stockIdx, String stockTitle, int stockCount, Date stockRegistration, Date stockModify,
			int traderIdx, int empNo, int rnum) {
		super();
		this.stockIdx = stockIdx;
		this.stockTitle = stockTitle;
		this.stockCount = stockCount;
		this.stockRegistration = stockRegistration;
		this.stockModify = stockModify;
		this.traderIdx = traderIdx;
		this.empNo = empNo;
		this.rnum = rnum;
	}

	public int getStockIdx() {
		return stockIdx;
	}

	public void setStockIdx(int stockIdx) {
		this.stockIdx = stockIdx;
	}

	public String getStockTitle() {
		return stockTitle;
	}

	public void setStockTitle(String stockTitle) {
		this.stockTitle = stockTitle;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getStockRegistration() {
		return stockRegistration;
	}

	public void setStockRegistration(Date stockRegistration) {
		this.stockRegistration = stockRegistration;
	}

	public Date getStockModify() {
		return stockModify;
	}

	public void setStockModify(Date stockModify) {
		this.stockModify = stockModify;
	}

	public int getTraderIdx() {
		return traderIdx;
	}

	public void setTraderIdx(int traderIdx) {
		this.traderIdx = traderIdx;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "FoodDTO [stockIdx=" + stockIdx + ", stockTitle=" + stockTitle + ", stockCount=" + stockCount
				+ ", stockRegistration=" + stockRegistration + ", stockModify=" + stockModify + ", traderIdx="
				+ traderIdx + ", empNo=" + empNo + ", rnum=" + rnum + "]";
	}
	
	
	
}
