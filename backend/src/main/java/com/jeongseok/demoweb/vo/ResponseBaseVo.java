package com.jeongseok.demoweb.vo;


public class ResponseBaseVo extends BaseVo {

	private static final long serialVersionUID = 1L;

	private int resultCd;
	private String resultMsg;

	private Object data = new Object();

	public ResponseBaseVo() {
		this.resultCd = 200;
		this.resultMsg = "default";
		this.data = "";
	}

	public int getResultCd() {
		return resultCd;
	}

	public void setResultCd(int resultCd) {
		this.resultCd = resultCd;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
