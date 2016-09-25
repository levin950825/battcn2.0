<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
    	 battcn.ns('battcn.admin.menu${OP.menu}');
    	 $('#admin_menu${OP.menu}_datagrid').bootstrapTable({
             url:rootPath + '/${MENU.channel}/query.shtml',
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
             columns: [{checkbox: true
           	 }, {
                 field: 'name',
                 title: '角色名称',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             }, {
                 field: 'code',
                 title: '角色代码',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },{
                 field: 'remark',
                 title: '备注',
                 align: 'left',
                 valign: 'top',
                 sortable: true
             } ]
     	});
    })
    
    //新增
battcn.admin.menu${OP.menu}.add = function(){
	battcn.showWindow({
			title:'增加角色',
			href:'op_edit_${OP.menu}.shtml',
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
			var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
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