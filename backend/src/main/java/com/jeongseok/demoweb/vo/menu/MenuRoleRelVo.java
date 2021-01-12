package com.jeongseok.demoweb.vo.menu;

import com.jeongseok.demoweb.vo.BaseVo;

public class MenuRoleRelVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private String roleId;

	private String menuId;

	private String sysCretDate;

	private String sysCretUserId;

	private String sysUpdtDate;

	private String sysUpdtUserId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getSysCretDate() {
		return sysCretDate;
	}

	public void setSysCretDate(String sysCretDate) {
		this.sysCretDate = sysCretDate;
	}

	public String getSysCretUserId() {
		return sysCretUserId;
	}

	public void setSysCretUserId(String sysCretUserId) {
		this.sysCretUserId = sysCretUserId;
	}

	public String getSysUpdtDate() {
		return sysUpdtDate;
	}

	public void setSysUpdtDate(String sysUpdtDate) {
		this.sysUpdtDate = sysUpdtDate;
	}

	public String getSysUpdtUserId() {
		return sysUpdtUserId;
	}

	public void setSysUpdtUserId(String sysUpdtUserId) {
		this.sysUpdtUserId = sysUpdtUserId;
	}
	
}
