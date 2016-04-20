package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dgaotech.dgfw.entity.BaseVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainStock extends BaseVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4350424330872747239L;
	private String productCode;
	private String productName;
	private int productType;
	private int stockNum;
	private String trainNo;
	private String mealsGrpLeadId;
	private String trainSubNo;
	
	private BigDecimal price;
	private String unit;
	private int isSale;
	
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the productType
	 */
	public int getProductType() {
		return productType;
	}
	/**
	 * @return the stockNum
	 */
	public int getStockNum() {
		return stockNum;
	}
	/**
	 * @return the trainNo
	 */
	public String getTrainNo() {
		return trainNo;
	}
	/**
	 * @return the mealsGrpLeadId
	 */
	public String getMealsGrpLeadId() {
		return mealsGrpLeadId;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(int productType) {
		this.productType = productType;
	}
	/**
	 * @param stockNum the stockNum to set
	 */
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	/**
	 * @param trainNo the trainNo to set
	 */
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	/**
	 * @param mealsGrpLeadId the mealsGrpLeadId to set
	 */
	public void setMealsGrpLeadId(String mealsGrpLeadId) {
		this.mealsGrpLeadId = mealsGrpLeadId;
	}
	/**
	 * @return the trainSubNo
	 */
	public String getTrainSubNo() {
		return trainSubNo;
	}
	/**
	 * @param trainSubNo the trainSubNo to set
	 */
	public void setTrainSubNo(String trainSubNo) {
		this.trainSubNo = trainSubNo;
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getIsSale() {
		return isSale;
	}
	public void setIsSale(int isSale) {
		this.isSale = isSale;
	}
}