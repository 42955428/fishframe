<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>商品售卖管理</title>
<%@include file="../common/header.jsp"%>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" />
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
						<li>售卖管理</li>
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
									<i class="fa fa-list"></i>商品售卖管理
								</div>
								<div class="tools">
							</div>
							</div>
							<div class="portlet-body">
								<div class="dataTables_wrapper">
									<div class="row">
										<form class="form-horizontal form-row-seperated" action="#">
									<!--  		<div class="col-md-12 col-sm-12">
													<label>
												       时间: <input type="text" id="datetimepicker"  class="form-control input-inline" placeholder="时间选择" />								
													</label>
													<label>
												       车次: <input type="text" id="trainNo" class="form-control input-inline" placeholder="输入车次" />							
														 <a class="btn btn-icon-only">
														   <i id="searchBtn" class="fa fa-search"></i>
														 </a>
													</label>
											</div>-->
										</form>
									</div>
								</div>

								<table
									class="table table-striped table-bordered table-hover table-advance"id="sample_1">								
									<thead>
										<tr>
										    <th>序号</th>
											<th>名称</th>
											<th>售价(元)</th>
											<th>数量</th>
											<th>单位</th>
											<th>车次</th>
											<th>当前状态</th>
											<th>修改状态</th>					
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
   							 <input type="hidden"value="${sessionScope.member.userId}" id="userId">
   							 <input type="hidden"value="${sessionScope.member.trainNo}" id="trainNo">
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
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="${ctx}/assets/global/plugins/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
		

		
	<!-- END PAGE LEVEL PLUGINS -->


	<!-- END JAVASCRIPTS -->

	<script>
var table;
        jQuery(document).ready(function() {   
        //	alert( $("#userId").val());
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
	                url: "${ctx}/assign/loadProductFromTrainStock.shtml",
	                data: function(d){
	                	    d.userId=$("#userId").val();
	                		d.trainNo=$("#trainNo").val();
	                		}
	               },
	            serverSide: true,
	            columns: [{data:""},
	                      {data:"productName"},
	                        {data:"price"},
				            {data:"stockNum"},
				            {data :"unit"},
				            {data:"trainNo"},
				            {    data: "isSale",  render: function (celldata, type, full, meta) {
	                               	celldata = celldata?1:0;
	                                   var text = ['暂停售卖', '正在售卖'],
	                                       cls = ['label-success', 'label-danger'];
	                                   return "<span class='label " + cls[celldata] + "'?>" + text[celldata] + "</span>";
	                               }
	                           },
	                           {
	                        	   data: "isSale", defaultContent: "", render: function (celldata, type, full, meta) {
	                                   var result = '<select class="isSale form-control" data-id="' + full.trainNo + "/" + full.productCode + '">';
	                                   if (celldata == '0') {
	                                       result += '<option value="0" selected>暂停售卖</option>';
	                                       result += '<option value="1">恢复售卖</option>';
	                                   }
	                                   else {
	                                       result += '<option value="0">暂停售卖</option>';
	                                       result += '<option value="1" selected>恢复售卖</option>';
	                                   }
	                                   result += '</select>';

	                                   return result;
	                               }                               
	                           } //是否可售卖
				       
				          	
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
	            },
	             "fnDrawCallback":function(){        	 
	     	            $('table select.isSale').change(function () {
	     	            	 var isSale = $(this).val();
	     	            	 var selectedId = $(this).data('id');
	     	            	 var trainNo = selectedId.split("/")[0];
	     	            	 var productCode = selectedId.split("/")[1]; 
	     	            	 
	     	               $.ajax({     	            	  
	     	            	    url:"${ctx}/assign/updateIsSale.shtml",  
	     	            	    data: {
	     	            	    	userId:$("#userId").val(),
	     	            	    	isSale:isSale,
	     	            	    	productCode:productCode,
	     	            	    	trainNo:trainNo
	     	            	    	},
	  	                		success: function () {
	  	                			 table.ajax.reload();   
	  	                          
	  	                      }
	     	               })
	     	          
	     	            });	
	             }  
	        });
		
			table.on( 'order.dt search.dt', function () {
				table.column(0).nodes().each( function (cell, i) {
		            cell.innerHTML = i+1;
		        });
			
				table.column(2).nodes().each( function (cell, i) {
		            cell.innerHTML = "￥"+cell.innerHTML;
		        } );
		    }).draw();
			
		   
        }); 
</script>
</body>
<!-- END BODY -->
</html>