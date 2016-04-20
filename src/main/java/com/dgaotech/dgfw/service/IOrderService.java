package com.dgaotech.dgfw.service;


import java.util.List;
import java.util.Map;

import com.dgaotech.base.persistence.page.Page;
import com.dgaotech.dgfw.entity.OrderInfo;



public interface IOrderService  {


	public Page<OrderInfo> getPage(Map map);

	public Page getPreOrderList(Map map);

	public Page getPreOrderDetail(Map map);
	
	public Map getPreOrderDetail1(String start,String pageSize,String OrderNo);

	

}
