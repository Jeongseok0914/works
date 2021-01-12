package com.jeongseok.demoweb.vo.role;

import com.jeongseok.demoweb.vo.BaseVo;

public class RoleVo extends BaseVo {

	private static final long serialVersionUID = 1L;
	
	private String roleId;
	
	private String roleName;
	
	private String useYn;
	
	private String roleDesc;
	
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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
