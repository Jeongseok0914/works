package com.jeongseok.demoweb.vo.login;


import com.jeongseok.demoweb.vo.BaseVo;

public class LoginSelectVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String userName;
	
	private String sysCretDate;
	
	private String sysUpdtDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
