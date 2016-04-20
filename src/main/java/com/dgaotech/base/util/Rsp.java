package com.dgaotech.base.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rsp {
	
	//返回参数：{"draw":3,"recordsTotal":57,"recordsFiltered":57,"data":[]} 
	//draw 当前页，recordsTotal，recordsFiltered 记录总条数（用于计算页数） 

	
	/**
	 * 返回状态
	 */
	private String status;
	/**
	 * 返回时间戳
	 */
	private String syncTime;
	/**
	 * 返回信息
	 */
	private String msg;
	
	/**
	 * Current page;
	 */
	private int draw;
	
	/**
	 * Seared records count.
	 */
	private int recordsTotal;
	/**
	 * Unknown field but the plugin-in needed.
	 */
	private int recordsFiltered;
	/**
	 * 返回数据
	 */
	private Object data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
	

}
