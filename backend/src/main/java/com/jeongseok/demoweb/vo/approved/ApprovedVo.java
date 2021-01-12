package com.jeongseok.demoweb.vo.approved;

import com.jeongseok.demoweb.vo.BaseVo;

public class ApprovedVo extends BaseVo {
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	
	private String content;
	
	private String status;
	
	private String delYn;
	
	private String approvedUserId;
	
	private String sysCretDate;

	private String sysCretUserId;

	private String sysUpdtDate;

	private String sysUpdtUserId;

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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(String approvedUserId) {
		this.approvedUserId = approvedUserId;
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
