<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" uri="http://www.bsco.com/mytags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var tt = 0;
    $(function(){
    	sy.ns('sy.admin.menu${OP.menu}');
    	 $('#admin_menu${OP.menu}_datagrid').bootstrapTable({
             url:'${MENU.channel}/list.action',
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
             columns: [
                       {
                 checkbox: true
             }, {
                 field: 'name',
                 title: '角色名称',
                 align: 'center',
                 valign: 'middle',
                 sortable: true
             },
             {
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
             }  ],  
             onLoadSuccess: function (data) {
                // $result.text('Event: onLoadSuccess, data: ' + data);
             },
             onLoadError: function (status) {
                // $result.text('Event: onLoadError, data: ' + status);
             } 
     });
    })
    
      function stateFormatter(value, row, index) {
        if (value) {
        	return "<font color='green'>启用</font>";
        }else{
        	return "<font color='red'>禁用</font>";
        }
        return value;
    }
    
    function responseHandler(res) {
    	tt = res.totalCount;
		return {
			"rows" : res.list,
			"total" : res.total
		};
}

// 传递的参数
//search: undefined, sort: "name", order: "desc", limit: 25, offset: 0
function queryParams(params) {
	var page = 0;
	if(tt == 0 ){
	}else{
		page = params.offset % params.limit == 0 ? params.offset / params.limit : params.offset % params.limit +1;
	}
	return {
		numPerPage : params.limit,
		pageNum : page+1,
		orderDirection : params.order,
		orderField : params.sort
		
	};
}
    
    

//新增
sy.admin.menu${OP.menu}.add = function(){
	sy.showWindow({
			title:'增加管理员',
			href:'op_add_${OP.menu}.action',
			width:'800px',
			height:'600px',
			okhandler:function(){
				sy.admin.menu${OP.menu}.save();
			},
			cancelhandler:function(){
				sy.closeWindow();
			}
		});
}

	//编辑
sy.admin.menu${OP.menu}.edit = function(){
	var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
	if(rows.length==0){
		 sy.toastrsAlert({
		     code:'info',
		     msg:'请选择你要编辑的记录'
		});
		return;
	}
	if(rows.length > 1){
		 sy.toastrsAlert({
		     code:'warning',
		     msg:'sorry , 只能选择一条进行编辑'
		});
		return;
	}
	sy.showWindow({
			title:'编辑管理员',
			href:'op_edit_${OP.menu}.action?id='+rows[0].id,
			width:'800px',
			height:'600px',
			okhandler:function(){
				sy.admin.menu${OP.menu}.save();
			},
			cancelhandler:function(){
				sy.closeWindow();
			}
		});
}

	
	//删除
	sy.admin.menu${OP.menu}.remove = function(){
		var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
	if(rows.length==0){
		 sy.toastrsAlert({
		     code:'info',
		     msg:'请选择你要删除的记录'
		});
		return;
	}
	
	sy.confirm(function(){
		var rows =$('#admin_menu${OP.menu}_datagrid').bootstrapTable('getSelections');
		var ps = [];
  	$.each(rows,function(i,n){
  		ps.push(n.id);
  	});
  	$.ajax({
          type: 'post',
          url: 'op_remove_${OP.menu}.action',
          data: {"ids":ps.join(",")},
          dataType: 'json',
          success: function (data) {
          	$('#admin_menu${OP.menu}_datagrid').bootstrapTable('refresh');
          	sy.toastrsAlert({
     		     code:'success',
     		     msg:'删除成功'
     		});
          }
      });
	});
	 
	}
    </script>
<div class="wrapper wrapper-content gray-bg bgg animated fadeInRight"
	style="height: 100%">
	<div class="ibox">
		<div class="ibox-content">
			<c:import url="../toolbar.jsp" />
			<table id="admin_menu${OP.menu}_datagrid"
				data-mobile-responsive="true">
			</table>
		</div>
	</div>
</div>

