/**
 * <p>datetime： 2008 Sep 12, 2008 8:53:11 AM <p/>
 * <p>Title:Constants.java</p>
 * <p>Description:医学会项目(HC)</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: 信息技术有限公司</p>
 *
 * @author Jason Feng
 * @version 1.0
 */
package com.dgaotech.base.util;

public final class Constants {

	/*返回页面的json key 值*/
	public static final String JSON_RETURN_CODE = "code";
	public static final String JSON_RERUTN_MESSAGE = "message";
	public static final String CODE_SUCESS = "0000";
	public static final String CODE_PARAMETER_ERROR = "400";
	public static final String CODE_LOGOUT = "401";
	public static final String CODE_SYSTEM_ERROR = "500";
	
	public static final String MESSAGE_SUCCESS = "操作成功！";
	public static final String MESSAGE_LOGOUT = "登录信息丢失！";
	public static final String MESSAGE_SYSTEM = "系统繁忙，请稍后重试！";
	
	public final static String LOG_LEVEL_WARN="重要";
	public final static String LOG_LEVEL_INFO="一般";
	public final static String LOG_LEVEL_ERR="错误";
	
	public final static String LOG_TYPE_BACK="后台";
	public final static String LOG_TYPE_FRONT="前台";
	//保存登录会员session
	public final static String LOING_MEMBER_SESSION="member";
	public final static String LOGIN_USERNAME = "username";
	

	public static final String PAGE_MESSAGE = "message";
	
	
	public static final long cashBase = 900;
	public static final long seedBase = 900;
	public static final long cash_ztj = 160;
	public static final long cash_bdj = 80;
	
	
	
	public static final String ADMIN_NAME="admin";
	
	public static final int ALLOW_CHILD_NUMS=4;
	
	
	public static final int ALLOW_BAODAN_NUMS=5;//成为报单员条件
	public static final int CARD_NUMS = 10;//重复的身份证号数量
	
}