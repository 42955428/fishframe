<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<%
/**代码捕获到的返回结果**/
response.setCharacterEncoding("UTF-8");
com.bestnet.bfb.erp.entity.ResultMessage message = (com.bestnet.bfb.erp.entity.ResultMessage)request.getAttribute("message");
%>
<body style="background:#fff;">
<div style="min-height: 20%;height: auto !important;height: 20%;"></div>
<%=message.getMessage() %>
			
</body>
</html>