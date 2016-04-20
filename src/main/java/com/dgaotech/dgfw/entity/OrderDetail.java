package com.dgaotech.dgfw.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetail extends BaseVO implements Serializable {

	
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(String orderNo, String productCode, String productName,
			int productType, int productNum, double price, String unit,
			double amount) {
		super();
		this.orderNo = orderNo;
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.productNum = productNum;
		this.price = price;
		this.unit = unit;
		this.amount = amount;
	}

	private static final long serialVersionUID = -3930317032638563298L;
	
	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 商品编码
	 */
	private String productCode;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 商品类型
	 */
	private int productType;
	
	/**
	 * 商品数量
	 */
	private int productNum;
	
	/**
	 * 商品单价
	 */
	private double price;
	
	/**
	 * 商品单位
	 */
	private String unit;
	
	/**
	 * 商品总价
	 */
	private double amount;
	
	private int isPreOrder;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the isPreOrder
	 */
	public int getIsPreOrder() {
		return isPreOrder;
	}

	/**
	 * @param isPreOrder the isPreOrder to set
	 */
	public void setIsPreOrder(int isPreOrder) {
		this.isPreOrder = isPreOrder;
	}
	
}
