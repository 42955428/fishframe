package com.dgaotech.dgfw.utils;

import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * ajax请求页面返回的对象
 * @BackstageResult.java
 */
public class BackstageResult {
	private String str;
	private boolean status;
	private int statusValue;
	private Object msg;
	private Map fieldErrors;
	
	private String backUrl;
	public BackstageResult() {
	}
    
	public BackstageResult(String str, boolean status, int statusValue,
			Object msg, Map fieldErrors) {
		super();
		this.str = str;
		this.status = status;
		this.statusValue = statusValue;
		this.msg = msg;
		this.fieldErrors = fieldErrors;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public BackstageResult(boolean status, Object msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	public BackstageResult(int statusValue, Object msg) {
		super();
		this.statusValue = statusValue;
		this.msg = msg;
	}
	
	public BackstageResult(boolean status,int statusValue, Object msg) {
		super();
		this.status = status;
		this.statusValue = statusValue;
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
	public Map getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Map fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, true, true);
	}

	public int getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(int statusValue) {
		this.statusValue = statusValue;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
}
