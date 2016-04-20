package com.dgaotech.dgfw.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.dgaotech.base.persistence.page.Page;
import com.dgaotech.dgfw.entity.OrderInfo;


@MyBatisRepository
public interface OrderDAO {

	void save(OrderInfo order);
	boolean update(OrderInfo order);
	boolean updateOrderStatus(OrderInfo order);
	boolean delete(String orderNo);
	boolean deleteDetail(String orderNo);
	OrderInfo findByOrderNo(OrderInfo order);
	int total(OrderInfo order);

	List<OrderInfo> findAll(OrderInfo order);
	/**
	 * After assigned for pre-Order, update the assignedFlag = 1 by orderNo;
	 * @param order
	 * @return
	 */
	int updatePreOrderAssignStatus(OrderInfo order);
	/**
	 * Get all unassigned pre-Order list by particular date. (equals departureDate I guess)
	 * @param order
	 * @return
	 */
	List<OrderInfo> findPreOrderForAssgin(OrderInfo order);
	
	Page getPage(Map map);
	
	public Page getPreOrderList(Map map);
	
	public Page getPreOrderDetail(Map map);
	
	public Page  getPreOrderDetail1(String OrderNo);
	
	@Select("select * from  order_info")
	public Page<OrderInfo> getOrderList();
}
