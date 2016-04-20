package com.dgaotech.dgfw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaotech.base.persistence.page.Page;
import com.dgaotech.dgfw.dao.OrderDAO;
import com.dgaotech.dgfw.entity.OrderDetail;
import com.dgaotech.dgfw.entity.OrderInfo;
import com.dgaotech.dgfw.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDAO orderDAO;

	public Page<OrderInfo> getPage(Map map) {

		return orderDAO.getPage(map);
//		return orderDAO.getOrderList();
	}

	public Page getPreOrderList(Map map) {

		return orderDAO.getPreOrderList(map);
	}

	public Page getPreOrderDetail(Map map) {

		return orderDAO.getPreOrderDetail(map);
	}
	
	public Map getPreOrderDetail1(String start,String pageSize,String OrderNo) {
			List<OrderDetail> DetailList = new ArrayList<OrderDetail>();
			Page p= new Page();
			Map m = new HashMap();
			p.setCurrentResult(Integer.parseInt(start));
			p.setPageSize(Integer.parseInt(pageSize));
	        m.put("page", p);
	        m.put("OrderNo", OrderNo);      
	        p = orderDAO.getPreOrderDetail1(OrderNo);
	        m.put("data", p.getResult());
	        m.put("start", start);
			m.put("length", p.getPageSize());
			m.put("recordsTotal", p.getTotal());
			m.put("recordsFiltered", p.getTotal());		
		return m;
	}

	

}
