package com.dgaotech.dgfw.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.dgaotech.base.exception.BussinessProcessException;

/**
 * 功能：继承HttpServletRequestWrapper，过滤关键字
 * 		该实现只是重写了getParameter方法，getParameterValues方法请自行重写
 * 版本：v3.0
 * 版权：bestnet
 * 创建人：chengyang
 * 创建日期：2012-2-7
 * 修改历史：
 * 			description by author@date
 */
public class HttpSecurityRequest extends HttpServletRequestWrapper {

	public static final String SQLIN = ".*(?i)(( *SELECT +)|( +FROM +)|( *TRUNC(CATE)? *)|( *UNION *)|( +AND +)|( +DUAL *)|( +OR +)|( *DELETE *)|( *UPDATE *)).*";
	private static final String FATAL_ERR = "系统参数检查存在非法注入字符";
	
	public HttpSecurityRequest(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 重写，过滤关键字
	 */
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null||value.length()<1)return null;
		if(value.matches(SQLIN)){
			throw new BussinessProcessException(FATAL_ERR);
		}
		return filter(value);
	}
	
	
	
	@Override
	public String[] getParameterValues(String name) {
		String[] arr = super.getParameterValues(name);
		if(arr == null || arr.length < 1)return arr;
		for(int i=0;i<arr.length;i++){
			arr[i] = filter(arr[i]);
		}
		return arr;
	}

	/**
	 * 这里使用的处理方式比较简单，请根据系统情况定义处理级别
	 * 该方法中使用的是硬代码，建议将过滤词做成可配置的
	 * @param src
	 * @return
	 */
	@Deprecated
	protected String filter(String src){
		if(src==null||src.equals(""))return src;
		/**下面开始处理XSS关键字，这里只过滤部分关键字
		 * 需要注意的是，这里针对的是JavaScript关键字，并不是很全面
		 * VBScript关键字请查询相关资料
		 */
		src = src.replaceAll(">", "&gt;").replaceAll("<", "&lt;").replaceAll("\"", "&quot;")
				 .replaceAll("'", "&acute;").replaceAll("alert", "").replaceAll("expression", "").replaceAll("\n", "&lt;/br&gt;").replaceAll("\r", "").replaceAll("script", "").trim();
		/**下面开始处理SQL关键字，这里只过滤部分关键字
		 * 需要注意的是，这里针对的是Oracle关键字，也不是很全面
		 */
		src = src.replaceAll("(?i)(( ?SELECT )|( FROM )|( AND )|( OR )|( ?DELETE )|( ?UPDATE ))", "");//使用正则表达式，忽略大小写
		return src;
	}
	
}
