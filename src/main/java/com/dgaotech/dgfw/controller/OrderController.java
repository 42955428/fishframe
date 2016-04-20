package com.dgaotech.dgfw.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dgaotech.base.persistence.page.Page;
import com.dgaotech.base.util.Constants;
import com.dgaotech.dgfw.entity.OrderInfo;
import com.dgaotech.dgfw.service.IOrderService;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseActionController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping(value = "/list")
	public String show(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "/order/order_list";
	}

	@RequestMapping(value = "/listAjax")
	public void list(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map obj = new HashMap();
	
		try {
			// 获取请求次数
			String draw = "0";
			draw = request.getParameter("draw");
			Map map = new HashMap();
			String start = getRequestParameter(request, "start", "0");
			String pageSize = getRequestParameter(request, "length", "10");
			Page page = new Page();
			page.setCurrentResult(Integer.parseInt(start));
			page.setPageSize(Integer.parseInt(pageSize));
			map.put("page", page);
			map.put("appUserMobile", getRequestParameter(request, "extra_search", "0"));
			Page<OrderInfo> orderInfo = orderService.getPage(map);
			System.out.println(orderInfo.size());
			page = orderService.getPage(map);
			
			obj.put("draw", draw);
			obj.put("start", start);
			obj.put("length", page.getPageSize());
			obj.put("recordsTotal", page.getTotal());
			obj.put("recordsFiltered", page.getTotal());
			obj.put("data", page.getResult());
			obj.put(Constants.JSON_RETURN_CODE, Constants.CODE_SUCESS);
			obj.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_SUCCESS);
		} catch (Exception ex) {
			handleException(obj, ex);
		}
		write(response, new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(obj));
	}

	@RequestMapping(value = "/preOrderList")
	public String showList() {
		return "/preorder/preorder_list";
	}
	
	@RequestMapping(value = "/getPreOrderlist")
	public void preOrderList(HttpServletRequest request, HttpServletResponse response) {
		Map obj = new HashMap();
		try {
			// 获取请求次数
			String draw = "0";
			draw = request.getParameter("draw");
			Map map = new HashMap();
			String start = getRequestParameter(request, "start", "0");
			String pageSize = getRequestParameter(request, "length", "10");
			Page page = new Page();
			page.setCurrentResult(Integer.parseInt(start));
			page.setPageSize(Integer.parseInt(pageSize));
			map.put("page", page);
			String userId = getRequestParameter(request, "userId", "");// 获取用户ID			
			String trainNo = getRequestParameter(request, "trainNo", "");// 获取用户车次		
			String orderDate = getRequestParameter(request, "time", "");
			if(orderDate==null ||orderDate.equals("")){		
			 }else{
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			date= formatter.parse(orderDate);
			map.put("orderDate", orderDate);
			}			
			map.put("userId", userId);
			map.put("trainNo", trainNo);			
			page = orderService.getPreOrderList(map);
			obj.put("draw", draw);
			obj.put("start", start);
			obj.put("length", page.getPageSize());
			obj.put("recordsTotal", page.getTotal());
			obj.put("recordsFiltered", page.getTotal());
			obj.put("data", page.getResult());
			obj.put(Constants.JSON_RETURN_CODE, Constants.CODE_SUCESS);
			obj.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_SUCCESS);
		} catch (Exception ex) {
			handleException(obj, ex);
		}
		write(response, new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(obj));
	}

	@RequestMapping(value = "/preOrderDetail/{orderNo}") 
	public ModelAndView showList(@PathVariable("orderNo") String orderNo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("orderNo",orderNo);
		mv.setViewName("/preorder/preorderdetail");
		return mv;
	}
	

	

	@RequestMapping(value = "/getPreOrderDetail")
	public void preOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		Map obj = new HashMap();
		try {
			// 获取请求次数
			String draw = "0";
			draw = request.getParameter("draw");
			Map map = new HashMap();
			String start = getRequestParameter(request, "start", "0");
			String pageSize = getRequestParameter(request, "length", "10");
			Page page = new Page();
			page.setCurrentResult(Integer.parseInt(start));
			page.setPageSize(Integer.parseInt(pageSize));
			map.put("page", page);
			String orderNo= getRequestParameter(request, "orderNo", "");
			map.put("orderId", orderNo);
			page = orderService.getPreOrderDetail(map);
			obj.put("draw", draw);
			obj.put("start", start);
			obj.put("length", page.getPageSize());
			obj.put("recordsTotal", page.getTotal());	
			obj.put("recordsFiltered", page.getTotal());	
			obj.put("data", page.getResult());
			obj.put(Constants.JSON_RETURN_CODE, Constants.CODE_SUCESS);
			obj.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_SUCCESS);
		} catch (Exception ex) {
			handleException(obj, ex);
		}
		write(response, new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(obj));
	}

}
