<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
    <script type="text/javascript">
    var tt = 0;
   $(function(){
   	 battcn.ns('battcn.admin.menu${OP.menu}');
   	 $('#admin_menu${OP.menu}_datagrid').bootstrapTable({ 
          url: rootPath + '${MENU.channel}/query.shtml', 
          height: '100%',
          sortName: 'name',
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
          searchAlign: 'left',
          columns: [{
              checkbox: true
          }, {
              field: 'name',
              title: '姓名',
              align: 'center',
              valign: 'middle',
              sortable: true
          },{
              field: 'time',
              title: '时间',
              align: 'center',
              valign: 'middle',
              sortable: true
          },
          {
              field: 'account',
              title: '帐号',
              align: 'center',
              valign: 'middle',
              sortable: true
          },{
              field: 'rolename',
              title: '角色名称',
              align: 'left',
              valign: 'top',
              sortable: true
          }, {
              field: 'rolecode',
              title: '角色代码',
              align: 'center',
              valign: 'middle'
          } , {
              field: 'locked',
              title: '状态',
              align: 'center',
              valign: 'middle',
              sortable: true,
              formatter: stateFormatter
          } ]
    });
})
    
function stateFormatter(value, row, index) {
    if (value == 1) {
    	return '<i class="fa fa-check text-navy"></i>';
    }else{
    	return '<i class="fa fa-close text-danger"></i>';
    }
    return value;
}

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
		order : order,
		name:$("#name").val()
	}
}
//查询
var serach = 0;
battcn.admin.menu${OP.menu}.serach = function(){
	 if($("#name").val() !=''){
		 $('#admin_menu${OP.menu}_datagrid').bootstrapTable('refresh');
		 serach = 0;
	 }else
	 {
		 if(serach == 0)
		{
			 $('#admin_menu${OP.menu}_datagrid').bootstrapTable('refresh');
			 serach++;
		}
	}
 }
 

//新增
battcn.admin.menu${OP.menu}.add = function(){
	battcn.showWindow({
			title:'增加管理员',
			href:rootPath + '/op_edit_${OP.menu}.shtml',
			width:'50%',
			height:'60%',
			okhandler:function(){
				battcn.admin.menu${OP.menu}.save();
			},
			cancelhandler:function(){ 
				battcn.closeWindow();
			}
		}); 
	
}

	//编辑
battcn.admin.menu${OP.menu}.edit = function(){
	var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
	if(rows.length==0){
		battcn.toastrsAlert({
		     code:'info',
		     msg:'请选择你要编辑的记录'
		});
		return;
	}
	if(rows.length > 1){
		battcn.toastrsAlert({
		     code:'warning',
		     msg:'sorry , 只能选择一条进行编辑'
		});
		return;
	}
	battcn.showWindow({
			title:'编辑管理员',
			href:rootPath + '/op_edit_${OP.menu}.shtml?id='+rows[0].id,
			width:'50%',
			height:'60%',
			okhandler:function(){
				battcn.admin.menu${OP.menu}.save();
			},
			cancelhandler:function(){
				battcn.closeWindow();
			}
		});
}
 
	
	//删除
	battcn.admin.menu${OP.menu}.remove = function(){ 
		var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
		if(rows.length==0){
			battcn.toastrsAlert({
			     code:'info',
			     msg:'请选择你要删除的记录'
			});
			return;
		}
		battcn.confirm(function(){
			var ps = [];
	    	$.each(rows,function(i,n){
	    		ps.push(n.id);
	    	});
	    	$.ajax({
	            type: 'post',
	            url: rootPath + '/op_remove_${OP.menu}.shtml',
	            data: {"ids":ps.join(",")},
	            dataType: 'json',
	            success: function (data) {
	            	$('#admin_menu${OP.menu}_datagrid').bootstrapTable('refresh');
	            	battcn.toastrsAlert({
	              		 code: data.success ? 'success' :'error',
	    		       	 msg: data.success ? '成功' :'失败'
	         		});
	            }
	        });
		});
	}
</script>

<div class="wrapper wrapper-content animated fadeInRight">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="panel panel-default">
					<div class="panel-body">
						<form id="formSearch" class="form-horizontal">
							<div class="form-group" style="margin-top: 15px">
								<label class="control-label col-sm-1" for="txt_search_departmentname">名称</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="name">
								</div>
								<label class="control-label col-sm-1" for="txt_search_statu">性别</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="sex">
								</div>
								<div class="col-sm-4" style="text-align: left;">
									<button type="button"  onclick = "battcn.admin.menu${OP.menu}.serach();"
										class="btn btn-primary">查询</button>
								</div>
							</div>
						</form>
					</div>
				</div>
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