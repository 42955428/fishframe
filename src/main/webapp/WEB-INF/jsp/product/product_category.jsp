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
<title>商品类别管理</title>
<%@include file="../common/header.jsp" %>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<!-- END PAGE LEVEL STYLES -->

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
						商品类别查询
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-list"></i>商品类别查询
							</div>
							<div class="tools">
							</div>
						</div>
						<div class="portlet-body">
							<div class="dataTables_wrapper">
								<div class="row">
									<form class="form-horizontal form-row-seperated" action="#">
									<div class="col-md-12 col-sm-12">
									<!-- 
										<div class="dataTables_length">
											<label>
												<div class="btn-set">
													<a href="hf_marketing_query_add.html" class="btn green"><i class="fa fa-plus"></i> 新增</a>
													<button class="btn default"><i class="fa fa-times"></i> 删除</button>
												</div>
											</label>
										</div>
									 -->
									</div>
									
									</form>
								</div>
							</div>
				
								<table class="table table-striped table-bordered table-hover table-advance" id="sample_1">
								<thead>
								<tr>
								 <th>
										序号
									</th>
								   <th>
									分类
									</th>
									 <th>
                                         类别值
                                     </th>
                                      <th>
                                          活跃度
                                     </th>
                                     <th>
                                          操作员Id
                                     </th>
                                  
								</tr>
								</thead>
								<tbody>
								</tbody>
								</table>
			
							
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
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
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ctx}/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
<script type="text/javascript" src="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->


<!-- END JAVASCRIPTS -->

<script>
var table;
        jQuery(document).ready(function() {    
        	$(".page-sidebar").load("${ctx}/sidebar.jsp");
        	Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			QuickSidebar.init(); // init quick sidebar
			Demo.init(); // init demo features
			
			table = $('#sample_1').DataTable({
				"lengthChange":false,
				"showRowNumber":true,
				"aLengthMenu": [[10, 25, 50, -1],[10, 25, 50, "All"]],
				"searching": false,
				"scrollX":"100%",
				"scrollY":false,
				"bAutoWidth":false,
				"scrollCollapse":false,
				ajax: {
	                url: "categoryAjax.shtml",
	                	"data": function ( d ) {
	                        d.extra_search = $('#extra1').val();
	                    }
	            },
	            serverSide: true,
	            columns: [
					{"data": "id"},
					{"data": "category"},
	                {"data": "typeValue"},
	                {"data": "isActive"},
	                {"data": "optId"},
	           
	            ],
	            "aoColumnDefs" : [ {
	            	sDefaultContent : '',
	                aTargets : [ '_all' ]
	                
	            }],
	            "language": {
	             "lengthMenu": "_MENU_ 条记录每页",
	                "zeroRecords": "没有找到记录",
	                "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
	                "infoEmpty": "无记录",
	                "infoFiltered": "(从 _MAX_ 条记录过滤)",
	                "paginate": {
	                    "previous": "上一页",
	                    "next": "下一页"
	                }
	            }
	        });
			table.on( 'xhr', function () {
			});
			
        }); 
        $("#searchBtn").click(function(){
        	 table.ajax.reload();
        });
</script>
</body>
<!-- END BODY -->
</html>