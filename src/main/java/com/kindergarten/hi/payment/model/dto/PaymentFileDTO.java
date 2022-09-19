package com.kindergarten.hi.payment.model.dto;

public class PaymentFileDTO {
	private int no;
	private String originName;
	private String mainPath;
	private String savedName;
	private int expeNo;
	public PaymentFileDTO(int no, String originName, String mainPath, String savedName, int expeNo) {

		this.no = no;
		this.originName = originName;
		this.mainPath = mainPath;
		this.savedName = savedName;
		this.expeNo = expeNo;
	}
	
	public PaymentFileDTO() {

	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getMainPath() {
		return mainPath;
	}
	public void setMainPath(String mainPath) {
		this.mainPath = mainPath;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public int getExpeNo() {
		return expeNo;
	}
	public void setExpeNo(int expeNo) {
		this.expeNo = expeNo;
	}
	@Override
	public String toString() {
		return "PaymentFileDTO [no=" + no + ", originName=" + originName + ", mainPath=" + mainPath + ", savedName="
				+ savedName + ", expeNo=" + expeNo + "]";
	}
	
	
}
