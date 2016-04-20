<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>提前订单查询</title>
<%@include file="../common/header.jsp"%>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />
<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"></script>
<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"></script>
<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/less/datetimepicker.less"></script>
		
<!-- END PAGE LEVEL STYLES -->

</head>
<body class="page-header-fixed page-quick-sidebar-over-content ">
	<!-- BEGIN HEADER -->
	<%@include file="../common/top.jsp"%>

	<!-- END HEADER -->
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->

	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar navbar-collapse collapse"></div>
		</div>
		<!-- END SIDEBAR -->

		<!-- BEGIN CONTENT -->

		<div class="page-content-wrapper">
			<div class="page-content">

				<!-- BEGIN PAGE HEADER-->

				<div class="page-bar">
					<ul class="page-breadcrumb">
						<li><i class="fa fa-home"></i> <a href="${ctx}/index.shtml">首页</a>
							<i class="fa fa-angle-right"></i></li>
						<li>在线订单管理</li>
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
									<i class="fa fa-list"></i>订单明细
								</div>
								<div class="tools">
								  <a href="${ctx}/order/preOrderList.shtml">返回</a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="dataTables_wrapper">
									<div class="row">
										<form class="form-horizontal form-row-seperated" action="#">
											<div class="col-md-12 col-sm-12">
										</form>
									</div>
								</div>

								<table
									class="table table-striped table-bordered table-hover table-advance"
									id="sample_1">
									<thead>
										<tr>
											<th>序号</th>
											<th>订单编号</th>
											<th>商品码</th>
											<th>商品名</th>
											<th>商品类型</th>
											<th>商品数量</th>
											<th>价格</th>
											<th>单位</th>
											<th>总价</th>
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
	<%@include file="../common/import-js-core.jspf"%>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/select2/select2.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>		
    <script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
		
		
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
				lengthChange : false,
				showRowNumber : true,
				"aLengthMenu" : [ [ 10, 25, 50, -1 ], [ 10, 25, 50, "All" ] ],
				"searching" : false,
				"scrollX" :"100%",
				"scrollY" : false,
				"bAutoWidth":true,
				ajax : {
					url : "${ctx}/order/getPreOrderDetail.shtml",
					data : {orderNo:"${orderNo}"}	
				},
				serverSide : true,
				columns : [ {"data" : ""}, 
				            {"data" : "orderNo"},
				            {"data" : "productCode"},
				            {"data" : "productName"},
				            {"data" : "productType"}, 
				            {"data" : "productNum"}, 
				            {"data" : "price"}, 
				            {"data" : "unit"}, 
				            {"data" : "amount"} ],
				"aoColumnDefs" : [ {
					sDefaultContent : '',
					aTargets : [ '_all' ]

				} ],
				"language" : {
					"lengthMenu" : "_MENU_ 条记录每页",
					"zeroRecords" : "没有找到记录",
					"info" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
					"infoEmpty" : "无记录",
					"infoFiltered" : "(从 _MAX_ 条记录过滤)",
					"paginate" : {
						"previous" : "上一页",
						"next" : "下一页"
					}
				}
			});
			table.on( 'order.dt search.dt', function () {
				table.column(0).nodes().each( function (cell, i) {
		            cell.innerHTML = i+1;
		        } );
				table.column(6).nodes().each( function (cell, i) {
		            cell.innerHTML = "￥"+cell.innerHTML;
		        } );
				table.column(8).nodes().each( function (cell, i) {
		            cell.innerHTML = "￥"+cell.innerHTML;
		        } );
			}).draw();
		});	
	</script>
</body>
<!-- END BODY -->
</html>