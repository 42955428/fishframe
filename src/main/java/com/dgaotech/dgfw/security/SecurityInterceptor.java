package com.dgaotech.dgfw.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dgaotech.base.util.Constants;


public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
	private String notFilterPath;//不需要过滤的路径  是否要求登录和含有非法字符
	private String loginPath;//需要登录的路径

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String[] _noFilter =  notFilterPath.split(",");//不需要过滤的路径
		String uri = request.getRequestURI();
		String parm = request.getQueryString();
		if (null != parm && !"".equals(parm)) {
			uri+="?"+parm;
		}
		boolean isNeed = true;
		if(null != _noFilter && _noFilter.length > 0){
			for(String s : _noFilter){
				if(uri.indexOf(s) >= 0){ 
					isNeed = false;
					break;
				}
			}
		}
		
		//需要登录
		if(isNeed ==true){
			Object obj = request.getSession().getAttribute(com.dgaotech.base.util.Constants.LOING_MEMBER_SESSION);
			
			if(null == obj){
				//如果是ajax异步请求，直接返回json
				if (isAjaxRequest(request)) {
					response.setContentType("text/html;charset=UTF-8");
					try {
						PrintWriter writer = response.getWriter();
						JSONObject json = new JSONObject();
			        	json.put(Constants.JSON_RETURN_CODE, Constants.CODE_LOGOUT);
			        	json.put(Constants.JSON_RERUTN_MESSAGE, Constants.MESSAGE_LOGOUT);
						writer.write(json.toString());
						writer.flush();
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
				}else {
					response.sendRedirect(request.getContextPath()+"/login.shtml?returnURL="+java.net.URLEncoder.encode(uri));
					return false;
				}
			}
		}

		
        return super.preHandle(request, response, handler);  
	}

	public void setNotFilterPath(String notFilterPath) {
		this.notFilterPath = notFilterPath;
	}

	public void setLoginPath(String loginPath) {
		this.loginPath = loginPath;
	}

	/**
     * 判断是否是ajax访问
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
     String header = request.getHeader("X-Requested-With");
     if (header != null && "XMLHttpRequest".equals(header))
     	return true;
     else
     	return false;
    }
	
}