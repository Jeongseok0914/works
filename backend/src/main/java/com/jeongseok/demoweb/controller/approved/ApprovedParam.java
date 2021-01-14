package com.jeongseok.demoweb.controller.approved;

import com.jeongseok.demoweb.vo.BaseVo;

public class ApprovedParam extends BaseVo {
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	
	private String content;
	
	private String status;
	
	private String approvedUserId;
	
	private String sysCretUserId;
	
	private int page;
	
	private int limit;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(String approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	public String getSysCretUserId() {
		return sysCretUserId;
	}

	public void setSysCretUserId(String sysCretUserId) {
		this.sysCretUserId = sysCretUserId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
