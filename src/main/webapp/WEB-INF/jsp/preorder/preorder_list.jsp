<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>提前订单查询</title>
<%@include file="../common/header.jsp"%>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />

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
									<i class="fa fa-list"></i>提前订单查询
								</div>
								<div class="tools">
							</div>
							</div>
							<div class="portlet-body">
								<div class="dataTables_wrapper">
									<div class="row">
										<form class="form-horizontal form-row-seperated" action="#">
											<div class="col-md-12 col-sm-12">
													<label>
												       时间: <input type="text" id="datetimepicker"  class="form-control input-inline" placeholder="时间选择" />								
													</label>
													<label>
												       车次: <input type="text" id="trainNo" class="form-control input-inline" placeholder="输入车次" />							
														 <a class="btn btn-icon-only">
														   <i id="searchBtn" class="fa fa-search"></i>
														 </a>
													</label>
											</div>
										</form>
									</div>
								</div>

								<table
									class="table table-striped table-bordered table-hover table-advance"id="sample_1">
									
									<thead>
										<tr>
											<th>序号</th>
											<th>订单编号</th>
											<th>手机号</th>
											<th>订单日期</th>
											<th>订单类型</th>
											<th>订单状态</th>
											<th>订单金额</th>
											<th>实际金额</th>
											<th>送货方式</th>										
									<!--  	<th>车次</th>
											<th>发车时间</th> -->
											<th>车厢号</th>
											<th>座位号</th>
											<th>大号或小号</th>
									<!--  	<th>餐服长ID</th>-->
									<!--	<th>所属路局</th>-->
											<th>指定送货日期</th>
									<!--    <th>是否配货</th>-->
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
   							 <input type="hidden"value="${sessionScope.member.userId}" id="userId">
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
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		

		
	<!-- END PAGE LEVEL PLUGINS -->


	<!-- END JAVASCRIPTS -->

	<script>
var table;
        jQuery(document).ready(function() {   
        	//alert( $("#userId").val());
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
				"scrollX":"130%",
				"scrollY":false,
				"bAutoWidth":false,
				"scrollCollapse":false,				
				ajax: {
	                url: "getPreOrderlist.shtml",
	                	"data":function(d){
	                	    	d.userId=$("#userId").val();
		                		d.trainNo=$("#trainNo").val();
		                		d.time=$("#datetimepicker").val();
	                	}
			
	            },
	            serverSide: true,
	            columns: [
					{"data": ""},
					{"data": "orderNo"},
	                {"data": "appUserMobile"},
	                {"data": "orderDate"},
	                {"data": "orderType"},
	                {"data": "orderStatus"},
	                {"data": "orderAmt"},
	                {"data": "actualAmt"},
	                {"data": "deliverType"},
	        /*      {"data": "trainNo"},
	                {"data": "departureDate"},*/
	                {"data": "carriageNo"},
	                {"data": "seatNo"},
	                {"data": "trainSubNo"},
	         //     {"data": "mealsGrpLeadId"},
	        //      {"data": "bureau"},
	                {"data": "preOrderDate"},
	          //    {"data": "assignedFlag"}
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
		/*	table.on( 'xhr', function () {
					var json = table.ajax.json();
					alert( json.data.length +' row(s) were loaded' );
				});*/
			//加入序号
			table.on( 'order.dt search.dt', function () {
				table.column(0).nodes().each( function (cell, i) {
		            cell.innerHTML = i+1;
		        });
				table.column(1).nodes().each( function (cell, i) {
					var code = cell.innerHTML;
					cell.innerHTML = "<a href='${ctx}/order/preOrderDetail/"+code+".shtml'>" +cell.innerHTML +"</a>";
		        } );
				table.column(4).nodes().each( function (cell, i) {				
					if (cell.innerHTML==9){
						cell.innerHTML="预订单";}
		        } );
				table.column(7).nodes().each( function (cell, i) {				
					if (cell.innerHTML==1){
						cell.innerHTML="送货";}
		        } );
				table.column(6).nodes().each( function (cell, i) {
		            cell.innerHTML = "￥"+cell.innerHTML;
		        } );
				table.column(7).nodes().each( function (cell, i) {
		            cell.innerHTML = "￥"+cell.innerHTML;
		        } );
		    }).draw();
        });
        $("#searchBtn").click(function(){
        	 table.ajax.reload();   
        	 
        });
        
        $('#datetimepicker').datetimepicker({ 
			　　minView:"month", //选择日期后，不会再跳转去选择时分秒 
			　　format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			　　language: 'zh-CN', //汉化 
			　　autoclose:true //选择日期后自动关闭 
			  });
      
</script>
</body>
<!-- END BODY -->
</html>