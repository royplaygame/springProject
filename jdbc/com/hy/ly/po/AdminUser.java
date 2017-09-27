package com.hy.ly.po;

public class AdminUser {

	private Integer adminNo;
	private String adminName;
	private String adminPwd;
	public Integer getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public AdminUser(Integer adminNo, String adminName, String adminPwd) {
		super();
		this.adminNo = adminNo;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	public AdminUser() {
		super();
	}
	@Override
	public String toString() {
		return "AdminUser [adminNo=" + adminNo + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}
	
	
}
