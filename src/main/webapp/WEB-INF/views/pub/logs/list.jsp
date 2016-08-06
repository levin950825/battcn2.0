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
                 sortable: true
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
	});
</script>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
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