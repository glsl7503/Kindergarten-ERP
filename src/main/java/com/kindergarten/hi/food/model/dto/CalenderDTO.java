package com.kindergarten.hi.food.model.dto;

import java.sql.Date;
import java.util.Objects;

public class CalenderDTO {

	private int id;                           // 월별 식단표 인덱스 
	private String title; 					  // 내용	
	private String start; 					  // 날짜 	
	private String end;						  // 끝나는 날짜 	
	private Date foodRegistration;  		  // 등록일 
	private Date foodModify; 				  // 수정일 	
	private String foodStatus;  			  // 승인여부 
	private int foodCategoryIdx;			  // 카테고리 인덱스
	private int empNo;						  // 직원번호 
	
	
	public CalenderDTO() {}

	public CalenderDTO(int id, String title, String start, String end, Date foodRegistration, Date foodModify,
			String foodStatus, int foodCategoryIdx, int empNo) {
		super();
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.foodRegistration = foodRegistration;
		this.foodModify = foodModify;
		this.foodStatus = foodStatus;
		this.foodCategoryIdx = foodCategoryIdx;
		this.empNo = empNo;
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

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Date getFoodRegistration() {
		return foodRegistration;
	}

	public void setFoodRegistration(Date foodRegistration) {
		this.foodRegistration = foodRegistration;
	}

	public Date getFoodModify() {
		return foodModify;
	}

	public void setFoodModify(Date foodModify) {
		this.foodModify = foodModify;
	}

	public String getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}

	public int getFoodCategoryIdx() {
		return foodCategoryIdx;
	}

	public void setFoodCategoryIdx(int foodCategoryIdx) {
		this.foodCategoryIdx = foodCategoryIdx;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "CalenderDTO [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end
				+ ", foodRegistration=" + foodRegistration + ", foodModify=" + foodModify + ", foodStatus=" + foodStatus
				+ ", foodCategoryIdx=" + foodCategoryIdx + ", empNo=" + empNo + "]";
	}

	
}
