package com.kindergarten.hi.employee.model.dto;

import java.sql.Date;

public class HolidayDTO {

	private int holiNo;                  // HOLI_NO       휴가서번호
	private String holiReason;			 // HOLI_REASON   사유 
	private String holiSort; 			 // HOLI_SORT     휴가분류 
	private String holiPeriod;			 // HOLI_PERIOD   휴가기간
	private Date holiWriDate;			 // HOLI_WRI_DATE 작성일
	private String holiDelYn;            // HOLI_DEL_YN   삭제여부
	private String holiOrder;			 // HOLI_ORDER    특이사항
	private String holiSubmit;			 // HOLI_SUBMIT   제출여부
	private String holiYn;				 // 승인여부
	private HolihisDTO holihisDto;
	private String process;
	private int rnum;
	
	public HolidayDTO() {}

	public HolidayDTO(int holiNo, String holiReason, String holiSort, String holiPeriod, Date holiWriDate,
			String holiDelYn, String holiOrder, String holiSubmit, String holiYn, HolihisDTO holihisDto, String process,
			int rnum) {
		super();
		this.holiNo = holiNo;
		this.holiReason = holiReason;
		this.holiSort = holiSort;
		this.holiPeriod = holiPeriod;
		this.holiWriDate = holiWriDate;
		this.holiDelYn = holiDelYn;
		this.holiOrder = holiOrder;
		this.holiSubmit = holiSubmit;
		this.holiYn = holiYn;
		this.holihisDto = holihisDto;
		this.process = process;
		this.rnum = rnum;
	}

	public int getHoliNo() {
		return holiNo;
	}

	public void setHoliNo(int holiNo) {
		this.holiNo = holiNo;
	}

	public String getHoliReason() {
		return holiReason;
	}

	public void setHoliReason(String holiReason) {
		this.holiReason = holiReason;
	}

	public String getHoliSort() {
		return holiSort;
	}

	public void setHoliSort(String holiSort) {
		this.holiSort = holiSort;
	}

	public String getHoliPeriod() {
		return holiPeriod;
	}

	public void setHoliPeriod(String holiPeriod) {
		this.holiPeriod = holiPeriod;
	}

	public Date getHoliWriDate() {
		return holiWriDate;
	}

	public void setHoliWriDate(Date holiWriDate) {
		this.holiWriDate = holiWriDate;
	}

	public String getHoliDelYn() {
		return holiDelYn;
	}

	public void setHoliDelYn(String holiDelYn) {
		this.holiDelYn = holiDelYn;
	}

	public String getHoliOrder() {
		return holiOrder;
	}

	public void setHoliOrder(String holiOrder) {
		this.holiOrder = holiOrder;
	}

	public String getHoliSubmit() {
		return holiSubmit;
	}

	public void setHoliSubmit(String holiSubmit) {
		this.holiSubmit = holiSubmit;
	}

	public String getHoliYn() {
		return holiYn;
	}

	public void setHoliYn(String holiYn) {
		this.holiYn = holiYn;
	}

	public HolihisDTO getHolihisDto() {
		return holihisDto;
	}

	public void setHolihisDto(HolihisDTO holihisDto) {
		this.holihisDto = holihisDto;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "HolidayDTO [holiNo=" + holiNo + ", holiReason=" + holiReason + ", holiSort=" + holiSort
				+ ", holiPeriod=" + holiPeriod + ", holiWriDate=" + holiWriDate + ", holiDelYn=" + holiDelYn
				+ ", holiOrder=" + holiOrder + ", holiSubmit=" + holiSubmit + ", holiYn=" + holiYn + ", holihisDto="
				+ holihisDto + ", process=" + process + ", rnum=" + rnum + "]";
	}

	
}
