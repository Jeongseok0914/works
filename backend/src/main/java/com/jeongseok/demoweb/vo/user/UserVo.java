package com.jeongseok.demoweb.vo.user;


import com.jeongseok.demoweb.vo.BaseVo;

public class UserVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String userPassword;
	
	private String userName;
	
	private String sysCretDate;
	
	private String sysUpdtDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSysCretDate() {
		return sysCretDate;
	}

	public void setSysCretDate(String sysCretDate) {
		this.sysCretDate = sysCretDate;
	}

	public String getSysUpdtDate() {
		return sysUpdtDate;
	}

	public void setSysUpdtDate(String sysUpdtDate) {
		this.sysUpdtDate = sysUpdtDate;
	}

}
