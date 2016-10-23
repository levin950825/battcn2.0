<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
    	 battcn.ns('battcn.admin.menu${(OP.menu)!'$'+'{OP.menu}'}');
    	 $('#admin_menu${(OP.menu)!'$'+'{OP.menu}'}_datagrid').bootstrapTable({ 
             url:rootPath + '${(MENU.channel)!'$'+'{MENU.channel}'}/query.shtml',
             height: '100%',
             //sortName: 'createTime',
             //sortOrder: 'desc',
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
             },
     <#list fieldList as var>
		<#if var[1] == 'Date'>
			 {
             	field: '${var.attributeName}',
                title: '${var.remake}',
                align: 'center',
                valign: 'top',            
                sortable: true,
                formatter:function(value,row,index){return new Date(value).pattern("yyyy-MM-dd HH:mm:ss")}
             },
		<#else>
			 {
                field: '${var.attributeName}',
                title: '${var.remake}',
                align: 'center',
                valign: 'middle'
              },
		</#if>
	</#list> 
             ]      
	     });
	});
</script>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
		<%@ include file="/WEB-INF/views/common/toolbar.jsp"%>
			<div class="table-responsive">
				<table id="admin_menu${(OP.menu)!'$'+'{OP.menu}'}_datagrid" data-toolbar="#toolbar"
					data-show-refresh="true" data-show-toggle="true"
					data-show-columns="true" data-show-footer="false"
					data-mobile-responsive="true">
				</table>
			</div>
		</div>
	</div>
</div>