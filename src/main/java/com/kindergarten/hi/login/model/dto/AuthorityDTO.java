package com.kindergarten.hi.login.model.dto;

public class AuthorityDTO {

    private int authNum;											// 권한코드
    private String authName;										// 권한명
    private String authExpl;										// 권한설명

    public AuthorityDTO() {
    }

	public AuthorityDTO(int authNum, String authName, String authExpl) {
		super();
		this.authNum = authNum;
		this.authName = authName;
		this.authExpl = authExpl;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthExpl() {
		return authExpl;
	}

	public void setAuthExpl(String authExpl) {
		this.authExpl = authExpl;
	}

	@Override
	public String toString() {
		return "AuthorityDTO [authNum=" + authNum + ", authName=" + authName + ", authExpl=" + authExpl + "]";
	}
}
