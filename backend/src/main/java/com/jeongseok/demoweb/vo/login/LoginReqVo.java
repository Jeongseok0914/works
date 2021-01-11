package com.jeongseok.demoweb.vo.login;

import com.jeongseok.demoweb.vo.BaseVo;

import io.swagger.annotations.ApiParam;

public class LoginReqVo extends BaseVo {

	private static final long serialVersionUID = 1L;
	
	@ApiParam(value = "사용자 아이디", required = true)
	private String userId;
	
	@ApiParam(value = "사용자 비밀번호", required = true)
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
