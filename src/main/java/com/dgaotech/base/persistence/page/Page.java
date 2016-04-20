package com.dgaotech.base.persistence.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <p>分页信息。</p>
 * <p>继承ArrayList是因为如果BaseMapper.getPage方法的返回类型是Page，而mybatis有如下判断：</p>
 * <pre>
 * if (List.class.isAssignableFrom(method.getReturnType())) {
 *    returnsList = true;//即只有返回List才执行selectList。
 * }
 * </pre>
 */
public class Page<T> extends ArrayList<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 465693204068562470L;

	/**每页显示几条*/
	private int pageSize = 20;
	
	/**总条数*/
	private int totalNums = 0; 
	
	/**当前页*/
	private int pageNo = 0; 
	
	/**当前记录起始索引*/
	private int currentResult = 0; 

	/**存放结果集*/
	private List<T> result = new ArrayList<T>();

	/**
	 * 
	 * <p>获取结果集</p>
	 *
	 * @return
	 */
	public List<T> getResult() {
		if (result == null) {
			return new ArrayList<T>();
		}
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 
	 * <p>
	 * 获取总页数
	 * </p>
	 * 
	 * @return
	 */
	public int getTotalPage() {
		if (totalNums % pageSize == 0) {
			return totalNums / pageSize;
		}
		return totalNums / pageSize + 1;
	}

	/**
	 * 
	 * <p>
	 * 获取总条数
	 * </p>
	 * 
	 * @return
	 */
	public int getTotal() {
		return totalNums;
	}

	/**
	 * 
	 * <p>
	 * 设置总条数
	 * </p>
	 * 
	 * @param total
	 */
	public void setTotal(int total) {
		this.totalNums = total;
	}

//	public int getPageNo() {
//		if (pageNo <= 0) {
//			pageNo = 1;
//		}
//		if (pageNo > getTotalPage()) {
//			pageNo = getTotalPage();
//		}
//		return pageNo;
//	}

	
//
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}

	/**
	 * 
	 * @Description
	 * 取当前页数
	 * @param Jul 17, 201411:46:10 AM
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int size) {
		if (size == 0) {
			size = 10;
		}
		this.pageSize = size;
	}

//	public int getCurrentResult() {
//		currentResult = (getPageNo() - 1) * getPageSize();
//		if (currentResult < 0) {
//			currentResult = 0;
//		}
//		return currentResult;
//	}
	
	public int getCurrentResult() {
		
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
}