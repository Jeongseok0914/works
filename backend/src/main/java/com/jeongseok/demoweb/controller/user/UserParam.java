package com.jeongseok.demoweb.controller.user;

import com.jeongseok.demoweb.vo.BaseVo;

public class UserParam extends BaseVo {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	private String userName;
	
	private String userPassword;

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
