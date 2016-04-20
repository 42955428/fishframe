package com.dgaotech.dgfw.entity;

import com.dgaotech.base.util.Constants;


/**
 * 创建类时默认为0000
 * @author HANX
 *
 */
public class ResultMessage {

	private String code =null;
	private String message = null;
	private String gotoUrl = null;//跳转地址
	

	public ResultMessage() {}
	public ResultMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGotoUrl() {
		return gotoUrl;
	}
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	
}
