<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
    	 battcn.ns('battcn.admin.menu${OP.menu}');
    	 $('#admin_menu${OP.menu}_datagrid').bootstrapTable({ 
             url:rootPath + '${MENU.channel}/query.shtml',
             height: '100%',
             sortName: 'account',
             sortOrder: 'desc',
             striped: true,
             pagination: true,
             pageSize: 10,
             pageList: [10, 25, 50, 100, 200],
             search: false,
             sidePagination:'server',
             idField: 'id',
             uniqueId: 'id',
             responseHandler: responseHandler,
             queryParams: queryParams,
             minimumCountColumns: 2,
             clickToSelect: true,
             columns: [{checkbox: true
             }, {
                 field: 'account',
                 title: '账号',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },{
                 field: 'title',
                 title: '操作项',
                 align: 'center',
                 valign: 'middle'
             },
             {
                 field: 'message',
                 title: '消息',
                 align: 'center',
                 valign: 'middle'
             },{
                 field: 'optime',
                 title: '操作时间',
                 align: 'left',
                 valign: 'top',            
                 sortable: true,
                 formatter:function(value,row,index){return new Date(value).pattern("yyyy-MM-dd HH:mm:ss")}
             }, {
                 field: 'ip',
                 title: 'IP',
                 align: 'center',
                 valign: 'middle'
             } , {
                 field: 'url',
                 title: '跳转地址',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             } ]      
	     });
    	 
    	// 传递的参数
    	 function queryParams(params) {
    	 	var pageSize = params.limit;
    	 	var sort = params.sort;
    	 	var offset = params.offset;
    	 	var order = params.order;
    	 	var pageNum = offset / pageSize + 1;
    	 	return {
    	 		pageSize : pageSize,
    	 		pageNum : pageNum,
    	 		sort : sort,
    	 		order : order
    	 	}
    	 }
    	 
   		//导出日志
   		battcn.admin.menu${OP.menu}.export = function(){ 
   			battcn.confirm(function(){
   		    	//$.get(rootPath + "/op_export_${OP.menu}.shtml",function(){});
   			 	location.href= rootPath + "/op_export_${OP.menu}.shtml";  
   			});
   		}
    	 
	});
</script>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
		<%@ include file="/WEB-INF/views/common/toolbar.jsp"%>
			<div class="table-responsive">
				<table id="admin_menu${OP.menu}_datagrid" data-toolbar="#toolbar"
					data-show-refresh="true" data-show-toggle="true"
					data-show-columns="true" data-show-footer="false"
					data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</div>