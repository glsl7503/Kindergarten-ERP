package com.kindergarten.hi.item.model.dto;

import java.sql.Date;

public class TraderItemDTO {
	
	private int traderIdx;
	private String traderName;
	private String traderPhone;
	private String traderPic;
	private String traderYn;
	private java.sql.Date traderRegistration;
	private java.sql.Date traderModify;
	
	
	public TraderItemDTO() {
		
	}


	public TraderItemDTO(int traderIdx, String traderName, String traderPhone, String traderPic, String traderYn,
			Date traderRegistration, Date traderModify) {
		super();
		this.traderIdx = traderIdx;
		this.traderName = traderName;
		this.traderPhone = traderPhone;
		this.traderPic = traderPic;
		this.traderYn = traderYn;
		this.traderRegistration = traderRegistration;
		this.traderModify = traderModify;
	}


	public int getTraderIdx() {
		return traderIdx;
	}


	public void setTraderIdx(int traderIdx) {
		this.traderIdx = traderIdx;
	}


	public String getTraderName() {
		return traderName;
	}


	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}


	public String getTraderPhone() {
		return traderPhone;
	}


	public void setTraderPhone(String traderPhone) {
		this.traderPhone = traderPhone;
	}


	public String getTraderPic() {
		return traderPic;
	}


	public void setTraderPic(String traderPic) {
		this.traderPic = traderPic;
	}


	public String getTraderYn() {
		return traderYn;
	}


	public void setTraderYn(String traderYn) {
		this.traderYn = traderYn;
	}


	public java.sql.Date getTraderRegistration() {
		return traderRegistration;
	}


	public void setTraderRegistration(java.sql.Date traderRegistration) {
		this.traderRegistration = traderRegistration;
	}


	public java.sql.Date getTraderModify() {
		return traderModify;
	}


	public void setTraderModify(java.sql.Date traderModify) {
		this.traderModify = traderModify;
	}


	@Override
	public String toString() {
		return "TraderItemDTO [traderIdx=" + traderIdx + ", traderName=" + traderName + ", traderPhone=" + traderPhone
				+ ", traderPic=" + traderPic + ", traderYn=" + traderYn + ", traderRegistration=" + traderRegistration
				+ ", traderModify=" + traderModify + "]";
	}
	
	
	
	

}
