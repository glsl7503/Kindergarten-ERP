package com.kindergarten.hi.login.model.dto;

public class LoginEmployeeRoleDTO {

    private int memberNo;				// 회원번호
    private int authorityCode;			// 권한코드

    private AuthorityDTO authority;		// 회원보유권한

    public LoginEmployeeRoleDTO() {
    }

    public LoginEmployeeRoleDTO(int memberNo, int authorityCode, AuthorityDTO authority) {
        this.memberNo = memberNo;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public AuthorityDTO getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityDTO authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "LoginEmployeeRoleDTO{" +
                "memberNo=" + memberNo +
                ", authorityCode=" + authorityCode +
                ", authority=" + authority +
                '}';
    }
}
