package com.jeongseok.demoweb.vo;

import java.util.List;

import com.jeongseok.demoweb.vo.menu.MenuVo;

public class SessionVo {
	
	private String userId;
	
	private String roleId;
	
	private String userName;
	
	private List<MenuVo> menuList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<MenuVo> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVo> menuList) {
		this.menuList = menuList;
	}
	
}
