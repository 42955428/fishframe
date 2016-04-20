package com.dgaotech.dgfw.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineInfo extends BaseVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3829554497202190070L;

	private String id;

    private String lineNo;

    //private String trainNo;
    
    //private int startFlag;

    private String bureau;

    private String optId;

    private Date optDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the lineNo
	 */
	public String getLineNo() {
		return lineNo;
	}

//	/**
//	 * @return the trainNo
//	 */
//	public String getTrainNo() {
//		return trainNo;
//	}
//
//	/**
//	 * @return the startFlag
//	 */
//	public int getStartFlag() {
//		return startFlag;
//	}

	/**
	 * @return the bureau
	 */
	public String getBureau() {
		return bureau;
	}

	/**
	 * @return the optid
	 */
	public String getOptId() {
		return optId;
	}

	/**
	 * @return the optdate
	 */
	public Date getOptDate() {
		return optDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

//	/**
//	 * @param trainNo the trainNo to set
//	 */
//	public void setTrainNo(String trainNo) {
//		this.trainNo = trainNo;
//	}
//
//	/**
//	 * @param startFlag the startFlag to set
//	 */
//	public void setStartFlag(int startFlag) {
//		this.startFlag = startFlag;
//	}

	/**
	 * @param bureau the bureau to set
	 */
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	/**
	 * @param optid the optid to set
	 */
	public void setOptId(String optId) {
		this.optId = optId;
	}

	/**
	 * @param optdate the optdate to set
	 */
	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}
}