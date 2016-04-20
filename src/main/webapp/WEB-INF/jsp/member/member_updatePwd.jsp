<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 4.1.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>修改密码</title>
<%@include file="../common/header.jsp" %>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-quick-sidebar-over-content ">
<!-- BEGIN HEADER -->
<%@include file="../common/top.jsp" %>

<!-- END HEADER -->
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->

<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
		</div>
	</div>
	<!-- END SIDEBAR -->

	<!-- BEGIN CONTENT -->
	
	<div class="page-content-wrapper">
		<div class="page-content">
		
			<!-- BEGIN PAGE HEADER-->

			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="${ctx}/index.shtml">首页</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						个人中心
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			
			<!-- BEGIN PAGE CONTENT-->
			<form:form id="editForm" method="post"  commandName="m"  class="form-horizontal form-row-seperated">
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-list"></i>修改密码
							</div>
							<div class="tools">
							</div>
						</div>
						<c:if test="${result!=null}">
							<div class="alert alert-danger">
								<button class="close" data-close="alert"></button>
								<span>${result.msg}</span>
							</div>
						</c:if>
						
						
						
						<div class="portlet-body form">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-md-3 ">原二级密码</label>
									<div class="col-md-9">
										<input type="password" size="16" class="form-control" name="oldPasswordLevel2" >
										<span id="regNameSpanMsg" class="alert-danger"></span>
									</div>
								</div>


								<div class="form-group">
									<label class="control-label col-md-3 ">新一级密码</label>
									<div class="col-md-9">

										<input type="password" size="16" class="form-control" name="password" >
										<span id="boundRegCodeSpanMsg" class="alert-danger"></span>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-md-3 ">新二级密码</label>
									<div class="col-md-9">

										<input type="password" size="16" class="form-control" name="passwordLevel2" >
										<span id="boundRegCodeSpanMsg" class="alert-danger"></span>
									</div>
								</div>
						</div>
						
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="portlet">
						<div class="portlet-title">	
							<div class="btn-set">
									<input type="hidden" name ="submitFlag" value="bind"/>
									<button class="btn green"><i class="fa fa-check"></i>修改</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			</form:form>
			<!-- END PAGE CONTENT-->
			
		</div>
	</div>
	
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
<%@include file="../common/footer.jsp"%>
<!-- END FOOTER -->

<!-- BEGIN CORE PLUGINS -->
<%@include file="../common/import-js-core.jspf" %>
<%@ include file="../common/validate.jsp" %>
<!-- END CORE PLUGINS -->

<script>
        jQuery(document).ready(function() {    
        	$(".page-sidebar").load("${ctx}/sidebar.jsp");
        	Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			QuickSidebar.init(); // init quick sidebar
			Demo.init(); // init demo features
       // Ecommerce.init();
			
			 $('#editForm').validate({
		            errorElement: 'span', //default input error message container
		            errorClass: 'errMsg', // default input error message class
		            focusInvalid: false, // do not focus the last invalid input
		            rules: {
		            	oldPasswrodLevel2: {
		                    required: true
		                   // ,isPwd:true
		                },
		                password: {
		                    required: true
		                    //,isPwd:true
		                },
		                passwordLevel2: {
		                    required: true
		                    //,isPwd:true
							
		                },
		            },

		            messages: {
		            },

		            invalidHandler: function(event, validator) { //display error alert on form submit
		              //  $('.alert-danger', $('#editForm')).show();
		            },

		            highlight: function(element) { // hightlight error inputs
		                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
		            },

		            success: function(label) {
		                label.closest('.form-group').removeClass('has-error');
		                label.remove();
		            },

		            submitHandler: function(form) {
		            	form.action="updatePwd.shtml";
		                form.submit(); // form validation success, call ajax form submit
		            }
		        });
			
			
			
        });
    </script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>