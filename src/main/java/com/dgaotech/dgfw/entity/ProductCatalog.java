/**
 * 
 */
package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author zengr
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCatalog extends BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1759783959937548023L;
	
	private String id;
	private String category;
	private int typeValue;
	private String optId;
	
	private List<Product> productList;
	
	public ProductCatalog() {
		super();
	}
	
	public ProductCatalog(
			String id,
			String category,
			int typeValue,
			String optId
			) {
		super();
		this.id = id;
		this.category = category;
		this.typeValue = typeValue;
		this.optId = optId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the typeValue
	 */
	public int getTypeValue() {
		return typeValue;
	}

	/**
	 * @return the optId
	 */
	public String getOptId() {
		return optId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param typeValue the typeValue to set
	 */
	public void setTypeValue(int typeValue) {
		this.typeValue = typeValue;
	}

	/**
	 * @param optId the optId to set
	 */
	public void setOptId(String optId) {
		this.optId = optId;
	}

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
