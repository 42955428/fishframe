<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
	<li class="sidebar-toggler-wrapper">
		<div class="sidebar-toggler">
		</div>
	</li>
	
		
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">订单管理</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="${ctx}/order/list.shtml"><i class="icon-home"></i>实时订单</a>
				</li>
				<li>
					<a href="${ctx}/order/preOrderList.shtml"><i class="icon-home"></i>提前定单</a>
				</li>
			</ul>
		</li>	
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">售卖管理</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="${ctx}/assign/salesManager.shtml"><i class="icon-home"></i>商品售卖管理</a>
				</li>				
			</ul>
		</li>
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">商品查询</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="${ctx}/product/product_category.shtml"><i class="icon-home"></i>商品类别查询</a>
				</li>			
			</ul>
		</li>
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">会员管理</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="${ctx}/member/memberAdd.shtml"><i class="icon-home"></i>会员注册</a>
				</li>
				<li>
					<a href="${ctx}/member/memberList.shtml"><i class="icon-home"></i>会员查询</a>
				</li>
				<%-- <li>
					<a href="${ctx}/member/memberAdd.shtml"><i class="icon-home"></i>会员充值</a>
				</li> --%>
			</ul>
		</li>
		<li>
			<a href="javascript:;">
				<i class="icon-social-dropbox"></i>
				<span class="title">个人中心</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
			</a>
			<ul class="sub-menu">
				
				<li>
					<a href="${ctx}/member/updatePwd.shtml"><i class="icon-home"></i>密码修改</a>
				</li>
				<li>
					<a href="${ctx}/member/updatePwd.shtml"><i class="icon-home"></i>个人信息</a>
				</li>
			</ul>
		</li>
	
	
</ul>
<script>
$(function(){
	var _url=location.href,
		reg=/(_edit(.*?)\.)|(_add(.*?)\.)|(_product(.*?)\.)|(_detail(.*?)\.)/ig,
	_url=_url.substring(_url.lastIndexOf('/')+1,_url.lastIndexOf('#')>0?_url.lastIndexOf('#'):_url.length)||'index.shtml';
	
	_url=_url.replace(reg,".");
	$('.page-sidebar-menu li').removeClass('active');
	
	$(".page-sidebar-menu a[href$='"+_url+"']").parents('li').addClass('active').parents('li').addClass('active');
	
});
</script>