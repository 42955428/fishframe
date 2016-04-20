/**
 * 转账记录
 * @author fu
 * @version 1.0
 * @since 1.0
 */

package com.dgaotech.dgfw.entity;

import java.util.Date;

public class TradeLog {
	
	
	private Long id;
	private String fromRegId;
	private String toRegId;
	private int tradeBeans;
	
	private Date tradeDate;
	
	private String fromRegCode;
	private String toRegCode;
	private String fromRegName;
	private String toRegName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromRegId() {
		return fromRegId;
	}
	public void setFromRegId(String fromRegId) {
		this.fromRegId = fromRegId;
	}
	public String getToRegId() {
		return toRegId;
	}
	public void setToRegId(String toRegId) {
		this.toRegId = toRegId;
	}
	public int getTradeBeans() {
		return tradeBeans;
	}
	public void setTradeBeans(int tradeBeans) {
		this.tradeBeans = tradeBeans;
	}
	
	
	
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getFromRegCode() {
		return fromRegCode;
	}
	public void setFromRegCode(String fromRegCode) {
		this.fromRegCode = fromRegCode;
	}
	public String getToRegCode() {
		return toRegCode;
	}
	public void setToRegCode(String toRegCode) {
		this.toRegCode = toRegCode;
	}
	public String getFromRegName() {
		return fromRegName;
	}
	public void setFromRegName(String fromRegName) {
		this.fromRegName = fromRegName;
	}
	public String getToRegName() {
		return toRegName;
	}
	public void setToRegName(String toRegName) {
		this.toRegName = toRegName;
	}
	
	
	
	 
}

