package com.dgaotech.base.util;
/**
 * Action类操作结束后，保存的提示信息类
 * @author fujin
 *
 */
public class MessageVO {
	private String gotoUrl;//跳转地址
	private String code;//java错误码
	private String message;
	private boolean flag;

	/**
	 * @return the gotoUrl
	 */
	public String getGotoUrl() {
		return gotoUrl;
	}
	/**
	 * @param gotoUrl the gotoUrl to set
	 */
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
