package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Train extends BaseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4285193021931457126L;
	private String id;
	private String trainNo;
	private int isSingle;
	private int isStartFlag;
	private String lineId;
	private String lineNo;
	private String bureau;
	private String startStation;
	private String endStation;
	private String startDate;
	private String endDate;
	private int spanDays;
	private Timestamp actualStartDate;
	private Timestamp actualEndDate;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the trainNo
	 */
	public String getTrainNo() {
		return trainNo;
	}
	/**
	 * @return the isSingle
	 */
	public int getIsSingle() {
		return isSingle;
	}
	/**
	 * @return the lineNo
	 */
	public String getLineNo() {
		return lineNo;
	}
	/**
	 * @return the bureau
	 */
	public String getBureau() {
		return bureau;
	}
	/**
	 * @return the startStation
	 */
	public String getStartStation() {
		return startStation;
	}
	/**
	 * @return the endStation
	 */
	public String getEndStation() {
		return endStation;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @return the actualStartDate
	 */
	public Timestamp getActualStartDate() {
		return actualStartDate;
	}
	/**
	 * @return the actualEndDate
	 */
	public Timestamp getActualEndDate() {
		return actualEndDate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param trainNo the trainNo to set
	 */
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	/**
	 * @param isSingle the isSingle to set
	 */
	public void setIsSingle(int isSingle) {
		this.isSingle = isSingle;
	}
	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	/**
	 * @param bureau the bureau to set
	 */
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
	/**
	 * @param startStation the startStation to set
	 */
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	/**
	 * @param endStation the endStation to set
	 */
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @param actualStartDate the actualStartDate to set
	 */
	public void setActualStartDate(Timestamp actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	/**
	 * @param actualEndDate the actualEndDate to set
	 */
	public void setActualEndDate(Timestamp actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	
	/**
	 * @return the lineId
	 */
	public String getLineId() {
		return lineId;
	}
	/**
	 * @param lineId the lineId to set
	 */
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	
	/**
	 * @return the spanDays
	 */
	public int getSpanDays() {
		return spanDays;
	}
	/**
	 * @param spanDays the spanDays to set
	 */
	public void setSpanDays(int spanDays) {
		this.spanDays = spanDays;
	}
	/**
	 * @return the isStartFlag
	 */
	public int getIsStartFlag() {
		return isStartFlag;
	}
	/**
	 * @param isStartFlag the isStartFlag to set
	 */
	public void setIsStartFlag(int isStartFlag) {
		this.isStartFlag = isStartFlag;
	}

}