package com.dgaotech.dgfw.dao;

import java.util.HashMap;
import java.util.List;

import com.dgaotech.dgfw.entity.OrderDetail;

/**
 * 订单详情相关接口
 * @author Wing 
 * (Hello, Wing, I modified you code.)
 *
 */
public interface OrderDetailDAO {
	
	/**
	 * 插入订单详情
	 * @param orderDetail
	 */
	public void saveOrderDetail(OrderDetail orderDetail);
	
	public boolean update(OrderDetail orderDetail);
	
	public boolean delete(String orderNo);
	
	public List<OrderDetail> findOrderDetail(String orderNo);
	
	public List<OrderDetail> loadAllPreOrderDetail(HashMap<?, ?> para);
	
	//public List<AssignDetail> loadAllPreOrderDetailToAssign(HashMap<?, ?> para);
}
