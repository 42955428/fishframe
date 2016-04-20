package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 用户
 * 
 * @author Wing
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseVO implements Serializable {

	private static final long serialVersionUID = 8729685362073893763L;

	public Product() {

	}

	public Product(String productId, String productCode, String productName,
			String productType, String imgName, String bigImg, String smallImg,
			String brand, String unit, BigDecimal price, int maxQty,
			BigDecimal memberPrice, int isApp, int isSale, String optId,
			String optName, Timestamp optDate, String sales, String weight,
			String address) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.imgName = imgName;
		this.bigImg = bigImg;
		this.smallImg = smallImg;
		this.brand = brand;
		this.unit = unit;
		this.price = price;
		this.maxQty = maxQty;
		this.memberPrice = memberPrice;
		this.isApp = isApp;
		this.isSale = isSale;
		this.optId = optId;
		this.optName = optName;
		this.optDate = optDate;
		this.sales = sales;
		this.weight = weight;
		this.address = address;
	}
	
	private ProductCatalog productCatalog;

	/**
	 * 商品ID
	 */
	private String productId;

	/**
	 * 商品编码
	 */
	private String productCode;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品类别
	 */
	private String productType;

	/**
	 * 图片名称
	 */
	private String imgName;

	/**
	 * 大图
	 */
	private String bigImg;

	/**
	 * 小图
	 */
	private String smallImg;

	/**
	 * 品牌
	 */
	private String brand;

	/**
	 * 商品单位
	 */
	private String unit;

	/**
	 * 商品单价
	 */
	private BigDecimal price;

	/**
	 * 商品数量(最大库存)
	 */
	private int maxQty;

	/**
	 * 商品会员价
	 */
	private BigDecimal memberPrice;

	/**
	 * app用户是否可见(1可见,0不可见)
	 */
	private int isApp;

	/**
	 * 商品是否可售(1可售,0不可售)
	 */
	private int isSale;

	/**
	 * 操作员ID
	 */
	private String optId;

	/**
	 * 操作员姓名
	 */
	private String optName;

	/**
	 * 商品新增时间(系统自动生成)
	 */
	private Timestamp optDate;

	/**
	 * 商品月销量
	 */
	private String sales;

	/**
	 * 商品净含量
	 */
	private String weight;

	/**
	 * 商品产地
	 */
	private String address;

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public BigDecimal getMemberPrice() {
		return memberPrice;
	}

	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}

	public int getIsApp() {
		return isApp;
	}

	public void setIsApp(int isApp) {
		this.isApp = isApp;
	}

	public int getIsSale() {
		return isSale;
	}

	public void setIsSale(int isSale) {
		this.isSale = isSale;
	}

	public String getOptId() {
		return optId;
	}

	public void setOptId(String optId) {
		this.optId = optId;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public Timestamp getOptDate() {
		return optDate;
	}

	public void setOptDate(Timestamp optDate) {
		this.optDate = optDate;
	}

	/**
	 * @return the productCatalog
	 */
	public ProductCatalog getProductCatalog() {
		return productCatalog;
	}

	/**
	 * @param productCatalog the productCatalog to set
	 */
	public void setProductCatalog(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}

}
