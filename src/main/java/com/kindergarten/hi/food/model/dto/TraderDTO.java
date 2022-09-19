package com.kindergarten.hi.food.model.dto;

import java.sql.Date;

public class TraderDTO {
	
	private int traderIdx;                // 거래업체 인덱스 
	private String traderName;   		   // 거래업체 회사명 
	private String traderPhone;			   // 연락처 
	private String traderPic;			   // 담당자 
	private String traderYn;			   // 상태여부 
	private Date traderRegistration;       // 등록일 
	private Date traderModify;			   // 수정일 	
	private int rnum;					   // 
	
	public TraderDTO() {}

	public TraderDTO(int traderIdx, String traderName, String traderPhone, String traderPic, String traderYn,
			Date traderRegistration, Date traderModify, int rnum) {
		super();
		this.traderIdx = traderIdx;
		this.traderName = traderName;
		this.traderPhone = traderPhone;
		this.traderPic = traderPic;
		this.traderYn = traderYn;
		this.traderRegistration = traderRegistration;
		this.traderModify = traderModify;
		this.rnum = rnum;
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

	public Date getTraderRegistration() {
		return traderRegistration;
	}

	public void setTraderRegistration(Date traderRegistration) {
		this.traderRegistration = traderRegistration;
	}

	public Date getTraderModify() {
		return traderModify;
	}

	public void setTraderModify(Date traderModify) {
		this.traderModify = traderModify;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "TraderDTO [traderIdx=" + traderIdx + ", traderName=" + traderName + ", traderPhone=" + traderPhone
				+ ", traderPic=" + traderPic + ", traderYn=" + traderYn + ", traderRegistration=" + traderRegistration
				+ ", traderModify=" + traderModify + ", rnum=" + rnum + "]";
	}

	
	
}
