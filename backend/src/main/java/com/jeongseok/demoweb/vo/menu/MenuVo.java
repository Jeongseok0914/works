package com.jeongseok.demoweb.vo.menu;

import com.jeongseok.demoweb.vo.BaseVo;

public class MenuVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private String menuId;

	private String title;

	private String parentId;

	private String name;

	private String path;

	private String noCache;

	private String icon;

	private String component;

	private String roles;

	private int level;

	private int sortSeq;

	private String useYn;

	private String sysCretDate;

	private String sysCretUserId;

	private String sysUpdtDate;

	private String sysUpdtUserId;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNoCache() {
		return noCache;
	}

	public void setNoCache(String noCache) {
		this.noCache = noCache;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSortSeq() {
		return sortSeq;
	}

	public void setSortSeq(int sortSeq) {
		this.sortSeq = sortSeq;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
