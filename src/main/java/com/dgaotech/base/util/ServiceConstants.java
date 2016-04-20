package com.dgaotech.base.util;

/**
 * Mobile 服务常量类
 * @author yumingt
 *
 */
public class ServiceConstants {
	
	public static String ROLE_TYPE_ADMIN = "3";
	public static String ROLE_TYPE_CWZ = "1";
	public static String ROLE_TYPE_JSY = "2";
	
	/**
	 * Order type.
	 */
	public static int ORDET_TYPE_MEMMBER = 1; //会员
	public static int ORDET_TYPE_CASH = 2; //现金
	public static int ORDET_TYPE_APP = 3; //线上
	public static int ORDET_TYPE_LOST = 4; //丢失
	public static int ORDET_TYPE_DAMAGE = 5;//损失
	public static int ORDET_TYPE_FREE = 6;//免单
	public static int ORDET_TYPE_PREORDER = 7;//预订单
	
	public static int ORDET_STATUS_UNNORMAL = 9; // '异常订单'
	public static int ORDET_STATUS_UNPAY = 0; // '待支付'
	public static int ORDET_STATUS_UNHANDLE = 1; // '待处理'
	public static int ORDET_STATUS_DELIVERY = 2; // '配送中'
	public static int ORDET_STATUS_UNDELIVERY = 3; // '未送达'
	public static int ORDET_STATUS_FINISHED = 4; // '已送达'
	public static int ORDET_STATUS_EXPIRED = 5; // '订单过期'
	public static int ORDET_STATUS_CANCEL = 6; // '订单取消'
	
	//type:1表示新增 detail，2表示删除detail，3表示更新detail
	public static final String addDetail = "1";
	public static final String deleteDetail = "2";
	public static final String updateDetail = "3";
	
	//配货单状态
	public static final String NEW_CREATE = "0";
	public static final String COMFIRMED = "1";
	public static final String RECEIVED = "2";
	
	/**
	 *  Return success code to html;
	 */
	public final static String SUCCESS = "SUCCESS";
	/**
	 * return fail code to html.
	 */
	public final static String FAIL = "FAIL";
	/**
	 * 
	 */
	public final static int ERRCODE_EXCEPTION = 1;
	
	/**
	 * Server side's version.
	 */
	public final static String VERSION = "/admin.service/http/v1.0";
	
	/**
	 * 客户信息完整性
	 * @author yumingt
	 *
	 */
	public static class CustomerInfoCompletion {
		/**
		 * 客户信息完整
		 */
		public final static int YES = 1;
		
		/**
		 * 客户信息不完整
		 */
		public final static int NO = 0;

		
		
	}
}
