package com.dgaotech.dgfw.entity;

import java.io.Serializable;


public class ProductCategory extends BaseVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
    private String category;
    private int typeValue;
    private int isActive;
    private String optId;
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
	public int getTypeValue() {
		return typeValue;
	}
	public void setTypeValue(int typeValue) {
		this.typeValue = typeValue;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getOptId() {
		return optId;
	}
	public void setOptId(String optId) {
		this.optId = optId;
	}
}