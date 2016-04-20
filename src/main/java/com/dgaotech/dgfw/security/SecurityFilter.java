package com.dgaotech.dgfw.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 功能：安全过滤器，通过设置安全请求实现
 * 版本：v3.0
 * 版权：bestnet
 * 创建人：chengyang
 * 创建日期：2011-1-12
 * 修改历史：
 */
public class SecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(!(request instanceof HttpServletRequest)){
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSecurityRequest sreq = new HttpSecurityRequest(req);
		chain.doFilter(sreq, response);
	}

	public void destroy() {
		//Do nothing
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//Do nothing
	}

}
