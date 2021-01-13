package com.jeongseok.demoweb.controller.login;

import com.jeongseok.demoweb.vo.BaseVo;

public class LoginParam extends BaseVo {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	private String userPassword;

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
	
}
