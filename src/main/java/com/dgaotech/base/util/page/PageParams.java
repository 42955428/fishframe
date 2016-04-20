package com.dgaotech.base.util.page;

/**
 * 
 * <p>Datetime   ： Aug 6, 2008 11:20:13 AM<p/>
 * <p>Title      :  PageOracle.java</p>
 * <p>Description:  分页标签</p>
 * <p>Copyright  :  Copyright (c) 2008</p>
 * <p>Company    :  北京海特网联信息技术有限公司</p>
 *
 * @author  <a href="mailto:feng_zhiyong2005@yahoo.com.cn">Feng Zhiyong</a>
 *
 */
public class PageParams{
	
	private Integer pageSize;
	private Integer pageNo;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	

}
