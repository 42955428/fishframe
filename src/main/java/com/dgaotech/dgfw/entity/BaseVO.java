package com.dgaotech.dgfw.entity;

import java.io.Serializable;

import com.dgaotech.base.util.DateUtil;


public class BaseVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2387175633055478042L;


	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String sort="";//排序字段
	public String dir="";//顺序、倒序
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	
	protected static final String TIME_FORMAT = "HH:mm:ss";
	
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	
	public static String date2String(java.util.Date date,String dateFormat) {
		return DateUtil.format(date,dateFormat);
	}
	
	public static <T extends java.util.Date> T string2Date(String dateString,String dateFormat,Class<T> targetResultType) {
		return DateUtil.parse(dateString,dateFormat,targetResultType);
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	
	private String userId;
	private String userName;
	private String roleId;
	private String trainNo;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

}
