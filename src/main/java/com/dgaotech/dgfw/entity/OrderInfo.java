package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 订单信息表entity
 * @author wing
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfo extends BaseVO implements Serializable {


	@Override
	public String toString() {
		return "OrderInfo [orderNo=" + orderNo + ", appUserMobile="
				+ appUserMobile + ", orderDate=" + orderDate + ", orderDate1="
				+ orderDate1 + ", deliveryDate=" + deliveryDate
				+ ", orderType=" + orderType + ", orderType1=" + orderType1
				+ ", orderStatus=" + orderStatus + ", orderStatus1="
				+ orderStatus1 + ", orderAmt=" + orderAmt + ", deliverType="
				+ deliverType + ", stationDesc=" + stationDesc + ", payMethod="
				+ payMethod + ", actualAmt=" + actualAmt + ", trainNo="
				+ trainNo + ", carriageNo=" + carriageNo + ", seatNo=" + seatNo
				+ ", trainSubNo=" + trainSubNo + ", detailList=" + detailList
				+ ", deliverAdress=" + deliverAdress + ", mealsGrpLeadId="
				+ mealsGrpLeadId + ", bureau=" + bureau + ", departureDate="
				+ departureDate + "]";
	}

	private static final long serialVersionUID = 1L;
	
	public OrderInfo(){
		super();
	}

	/**
	 * 订单号
	 */
	private String orderNo;
	
	/**
	 * 客户手机号
	 */
	private String appUserMobile;
	
	/**
	 * 订单日期
	 */
	private Timestamp orderDate;
	private String orderDate1;
	private String deliveryDate;
	
	private String passedTime;
	
	/**
	 * 订单类型
	 */
	private int orderType;
	
	/**
	 * 订单类型
	 */
	private String orderType1;
	
	/**
	 * 订单状态
	 */
	private int orderStatus;
	
	/**
	 * 订单状态
	 */
	private String orderStatus1;
	
	/**
	 * 订单金额
	 */
	private double orderAmt;
	
	/**
	 * 送货方式
	 */
	private String deliverType;
	
	/**
	 * 车次始到站描述
	 */
	private String stationDesc;
	
	/**
	 * 支付方式
	 */
	private int payMethod;
	
	/**
	 * 实际支付金额
	 */
	private double actualAmt;
	
	/**
	 * 车次
	 */
	private String trainNo;
	
	/**
	 * 车厢号
	 */
	private String carriageNo;
	
	/**
	 * 座位号
	 */
	private String seatNo;
	
	/**
	 * 车厢大小号
	 */
	private String trainSubNo;
	
	private List<OrderDetail> detailList;
	
	/**
	 * 送货地址
	 */
	private String deliverAdress;
	/**
	 * 预订单送货日期
	 */
	private Timestamp preOrderDate;
	private String preOrderDate1;
	/**
	 * 是否已配货标志
	 */
	private int assignedFlag;
	//0-未配货，1-配货中，2配货完毕 3-已收货
	private String assignedFlag1;
	/**
	 * To keep pre-order's no list.
	 */
	private String orderNoString;
	
	public String getDeliverAdress() {
		return this.carriageNo + "号车厢" + this.seatNo;
	}
	
	public void setDeliverAdress(String deliverAdress) {
		this.deliverAdress = deliverAdress;
	}
	/**
	 * 餐服长ID
	 */
	private String mealsGrpLeadId;
	
	/**
	 * 路局
	 */
	@JsonIgnore
	private String bureau;
	
	/**
	 * 发车日期
	 */
	private Date departureDate;
	
	
	private List<OrderDetail> productList;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAppUserMobile() {
		return appUserMobile;
	}

	public void setAppUserMobile(String appUserMobile) {
		this.appUserMobile = appUserMobile;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}

	public String getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}

	public String getStationDesc() {
		return stationDesc;
	}

	public void setStationDesc(String stationDesc) {
		this.stationDesc = stationDesc;
	}

	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}

	public double getActualAmt() {
		return actualAmt;
	}

	public void setActualAmt(double actualAmt) {
		this.actualAmt = actualAmt;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	/**
	 * @return the orderNoString
	 */
	public String getOrderNoString() {
		return orderNoString;
	}

	/**
	 * @param orderNoString the orderNoString to set
	 */
	public void setOrderNoString(String orderNoString) {
		this.orderNoString = orderNoString;
	}

	/**
	 * @return the detailList
	 */
	public List<OrderDetail> getDetailList() {
		return detailList;
	}

	/**
	 * @return the preOrderDate
	 */
	public Timestamp getPreOrderDate() {
		return preOrderDate;
	}

	/**
	 * @return the assignedFlag
	 */
	public int getAssignedFlag() {
		return assignedFlag;
	}

	/**
	 * @param preOrderDate the preOrderDate to set
	 */
	public void setPreOrderDate(Timestamp preOrderDate) {
		this.preOrderDate = preOrderDate;
	}

	/**
	 * @param assignedFlag the assignedFlag to set
	 */
	public void setAssignedFlag(int assignedFlag) {
		this.assignedFlag = assignedFlag;
	}

	/**
	 * @param detailList the detailList to set
	 */
	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	public String getCarriageNo() {
		return carriageNo;
	}

	public void setCarriageNo(String carriageNo) {
		this.carriageNo = carriageNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getTrainSubNo() {
		return trainSubNo;
	}

	public void setTrainSubNo(String trainSubNo) {
		this.trainSubNo = trainSubNo;
	}

	public String getMealsGrpLeadId() {
		return mealsGrpLeadId;
	}

	public void setMealsGrpLeadId(String mealsGrpLeadId) {
		this.mealsGrpLeadId = mealsGrpLeadId;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public List<OrderDetail> getProductList() {
		return productList;
	}

	public void setProductList(List<OrderDetail> productList) {
		this.productList = productList;
	}

	public String getOrderType1() {
		return orderType1;
	}

	public void setOrderType1(String orderType1) {
		this.orderType1 = orderType1;
	}

	public String getOrderStatus1() {
		return orderStatus1;
	}

	public void setOrderStatus1(String orderStatus1) {
		this.orderStatus1 = orderStatus1;
	}

	public String getOrderDate1() {
		return orderDate1;
	}

	public void setOrderDate1(String orderDate1) {
		this.orderDate1 = orderDate1;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the assignedFlag1
	 */
	public String getAssignedFlag1() {
		return assignedFlag1;
	}

	/**
	 * @param assignedFlag1 the assignedFlag1 to set
	 */
	public void setAssignedFlag1(String assignedFlag1) {
		this.assignedFlag1 = assignedFlag1;
	}

	/**
	 * @return the passedTime
	 */
	public String getPassedTime() {
		return passedTime;
	}

	/**
	 * @param passedTime the passedTime to set
	 */
	public void setPassedTime(String passedTime) {
		this.passedTime = passedTime;
	}

	/**
	 * @return the preOrderDate1
	 */
	public String getPreOrderDate1() {
		return preOrderDate1;
	}

	/**
	 * @param preOrderDate1 the preOrderDate1 to set
	 */
	public void setPreOrderDate1(String preOrderDate1) {
		this.preOrderDate1 = preOrderDate1;
	}


}
