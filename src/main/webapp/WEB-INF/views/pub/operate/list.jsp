<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
    var tt = 0;
    $(function(){
    	 battcn.ns('battcn.admin.menu${OP.menu}');
    	 $('#admin_menu${OP.menu}_datagrid').bootstrapTable({ 
             url:rootPath + '${MENU.channel}/query.shtml',
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
                 field: 'menuname',
                 title: '菜单名称',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },{
                 field: 'name',
                 title: '操作名称',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },
             {
                 field: 'op',
                 title: '代码',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },{
                 field: 'icon',
                 title: '图标',
                 align: 'left',
                 valign: 'top',
                 formatter: function(val,row)
                 {
                	 return '<i class="fa fa-'+val+' text-navy"></i>';
                 },
                 sortable: true
             }, {
                 field: 'ordno',
                 title: '排序',
                 align: 'center',
                 valign: 'middle'
             } , {
                 field: 'isshow',
                 title: '工具栏',
                 align: 'center',
                 valign: 'middle',
                 sortable: true,
                 formatter: function(val,row)
                 {
                	 return val == 1 ? '<i class="fa fa-check text-navy"></i> ': '<i class="fa fa-close text-danger"></i>';
                 }
             } ],  
             onLoadSuccess: function (data) {
             },
             onLoadError: function (status) {
             }              
	     });
	});
//新增
battcn.admin.menu${OP.menu}.add = function(){
	battcn.showWindow({
			title:'增加操作',
			href:rootPath + '/op_edit_${OP.menu}.shtml',
			width:'50%',
			height:'70%',
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
	switch(rows.length)
	{
		case 0:battcn.msg(msg.choose);break;
		case 1:
			battcn.showWindow({
				title:'编辑操作',
				href:rootPath + '/op_edit_${OP.menu}.shtml?menu='+rows[0].menu+'&op='+rows[0].op,
				width:'50%',
				height:'70%',
				okhandler:function(){
					battcn.admin.menu${OP.menu}.save();
				},
				cancelhandler:function(){
					battcn.closeWindow();
				}
			});
			break;
		default :battcn.msg(msg.single);break;	
	}
}
	
	//删除
	battcn.admin.menu${OP.menu}.remove = function(){
		console.info(0);
		var rows = $('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
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
	    		ps.push(n.menu+"-"+n.op);
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
