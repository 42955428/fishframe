package com.dgaotech.dgfw.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author wing
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategoryContent {

	/**
	 * 商品类别ID
	 */
	private String id;
	
	/**
	 * 商品类别名称
	 */
	private String category;
	
	/**
	 * 商品类别值
	 */
	private int typeValue;
	
	/**
	 * 商品详细信息列表
	 */
	
	private List<Product> productList = new ArrayList<Product>();

	public int getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(int typeValue) {
		this.typeValue = typeValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
