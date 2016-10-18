<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
$(function() {
	
	 $('#admin_menu_column_datagrid').bootstrapTable({
            url:rootPath + '/${MENU.channel}/query.shtml?tid=${dto.uuid != null ? dto.uuid : "false"}',
            height: '100%',
            sortName: 'createDate',
            sortOrder: 'desc',
            striped: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 25, 50, 100, 200],
            search: true,
            sidePagination:'client',
            idField: 'uuid',
            uniqueId: 'uuid',
            //responseHandler: responseHandler,
            //queryParams: queryParams,
            minimumCountColumns: 2,
            clickToSelect: true,
            columns: [{
                field: 'attributeName',
                title: '属性名',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'attributeType',
                title: '属性类型',
                align: 'center',
                valign: 'middle'
            },{
                field: 'remake',
                title: '备注',
                align: 'center',
                valign: 'middle'
            },{
                field: 'defaultVal',
                title: '默认值',
                align: 'center',
                valign: 'middle'
            },{
                field: 'createDate',
                title: '创建时间',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'operate',
                title: '操作',
                width: 100,
                align: 'center',
                valign: 'middle',
                formatter: function(value, row, index)
                {
                	return [
                     	 	'<a class="edit" href="javascript:edit(\''+ row.uuid + '\')" title="edit">',
                     	 	'<i class="glyphicon glyphicon-edit"></i>',
                     	 	'</a> &nbsp;' ,
                     	 	'<a class="remove" href="javascript:remove(\''+ row.uuid + '\')" title="remove">',
                     	 	'<i class="glyphicon glyphicon-remove"></i>',
                     	 	'</a>'
                     	 	].join('');
                }
            }]
    	});
		
	   edit = function(uuid)
	   {
	 		 $.ajax({
		          type: 'GET',
		          url: rootPath + "/${MENU.channel}/cedit.shtml",
		          data: {"tid":"${dto.uuid}","cid":uuid},
		          dataType: 'json',
		          success: function (data) {
		        	  $form = $("#menuCodeColumnForm");
		        	  console.info(data);
		        	  $form.find("input[name='attributeName']").val(data.attributeName);
		        	  //$(form).find("input[name='attributeName']").val(data.attributeName);
		        	  $form.find("input[name='defaultVal']").val(data.defaultVal);
		        	  $form.find("input[name='remake']").val(data.remake);
		        	  $form.find("input[name='uuid']").val(data.uuid);
		        	  
		        	  layer.open({
		                  type: 1,
		                  skin: 'layui-layer-rim', //加上边框
		                  area: ['50%', '45%'], //宽高
		                  content: $("#dialog-add").html(),
		                  btn: ['保存', '取消']
		      		 	,yes: function(index, layero){
		      		 		$.ajax({
		      					type: "POST", 
		      					url: rootPath + "/${MENU.channel}/csave.shtml",
		      					data: $('#menuCodeColumnForm').serializeArray(),
		      					dataType: "json",
		      					success: function(data){
		      						if(data.success) {
		      							 layer.close(index);
		      							$('#admin_menu_column_datagrid').bootstrapTable('refresh');
		      						}
		      						battcn.toastrsAlert({
		      			       		     code: data.success ? 'success' :'error',
		      			       		     msg: data.msg
		      			       		});
		      					}
		      				});
		      		 	}
		      		});
		         }
		    });
	   }
	   
	   remove = function(uuid)
	   {
		   $.ajax({
		          type: 'post',
		          url: rootPath + '/op_remove_${OP.menu}.shtml',
		          data: {"tid":"${dto.uuid}","cid":uuid},
		          dataType: 'json',
		          success: function (data) {
		          	$('#admin_menu_column_datagrid').bootstrapTable('refresh');
		          	battcn.toastrsAlert({
	              		 code: data.success ? 'success' :'error',
	    		       	 msg: data.success ? '成功' :'失败'
	         		});
		          }
		    });
	   }
   	 

   	 battcn.admin.menu${OP.menu}.save = function(obj) {
	  		if($("#menu${OP.menu}Form").valid()){
	  			if(!CommnUtil.notNull($("#uuid").val()))
	  			{
	  				$("#uuid").val(battcn.uuid());
	  			}
	  			$.ajax({
					type: "POST", 
					url: rootPath + "/op_save_${OP.menu}.shtml",
					data: $('#menu${OP.menu}Form').serializeArray(),
					dataType: "json",
					success: function(data){
						if(data.success) {
							battcn.closeWindow();
							$('#admin_menu${OP.menu}_datagrid').bootstrapTable('refresh');
						}
						battcn.toastrsAlert({
			       		     code: data.success ? 'success' :'error',
			       		     msg: data.msg
			       		});
					}
				});
	  		}
		}
	});
	
	function addAttribute(uuid)
	{
		layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['50%', '45%'], //宽高
            content: $("#dialog-add").html(),
            btn: ['保存', '取消']
		 	,yes: function(index, layero){
		 		if(!CommnUtil.notNull(uuid))
	  			{
	  				$("#cid").val(battcn.uuid());
	  			}
		 		$.ajax({
					type: "POST", 
					url: rootPath + "/${MENU.channel}/csave.shtml",
					data: $('#menuCodeColumnForm').serializeArray(),
					dataType: "json",
					success: function(data){
						if(data.success) {
							 layer.close(index);
							$('#admin_menu_column_datagrid').bootstrapTable('refresh');
						}
						battcn.toastrsAlert({
			       		     code: data.success ? 'success' :'error',
			       		     msg: data.msg
			       		});
					}
				});
			}
        }); 
	}
</script>

<div id="dialog-add" style="display: none;" class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate" id="menuCodeColumnForm" method="post">
			<input type="hidden" id="cid" name="uuid">
			<input type="hidden" id="tid" value="${dto.uuid}">
			<div class="form-group">
				<label class="col-sm-2 control-label">属性名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="attributeName" value="im" placeholder="首字母必须为字母或下划线" 
					title="属性名" validate="{required:true,messages:{required:'请填写名称'}}" />
				</div>
				<div class="col-sm-6">
					<div class="radio i-checks radio-inline">
						<label> <input type="radio" value="1" name="attributeType" checked="checked" >
							<i></i> String
						</label>
						<label> <input type="radio" value="2" name="attributeType">
							<i></i> Integer
						</label>
						<label> <input type="radio" value="3" name="attributeType">
							<i></i> Date
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">默认值：</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="defaultVal" placeholder="默认值" title="默认值"
						validate="{required:true,messages:{required:'请填写默认值'}}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="remake" placeholder="备注" title="备注"
						validate="{required:true,messages:{required:'请填写备注'}}" />
				</div>
			</div>
			<div class="form-group">
				<font class="col-sm-8 col-sm-offset-1" color="red" style="font-weight: bold;">
					注意：<br/>
					  1. 请不要添加  XX_ID 的主键，系统自动生成一个32位无序不重复字符序列作为主键<br/>
					  2. 主键为  类名_ID 格式，所有字段的字母均用大写
				</font>
			</div>
		</form>
	</div>
</div>


<div class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate"
			id="menu${OP.menu}Form" method="post">
			<input type="hidden" name="uuid" id="uuid" value="${dto.uuid}">
			<div class="form-group">
				<label class="col-sm-2 control-label">上级包名：</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="upPackage"
						id="upPackage" value="${dto.upPackage}"
						placeholder="这里输入包名  (请不要输入特殊字符,请用纯字母)" title="包名称"
						validate="{required:true,messages:{required:'请填写名称'}}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">处理类名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="processorClass"
						id="processorClass" value="${dto.processorClass}"
						placeholder="这里输入处理类名称" title="类名称" />
				</div>
				<div class="col-sm-6">
					<label class="col-sm-2 control-label">表前缀：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="tablePrefix"
							id="tablePrefix" value="${dto.tablePrefix}" placeholder="这里输入表前缀"
							title="表前缀T_" />
					</div>
				</div>
			</div>
		</form>
	</div>

	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
				role="group">
				<button type="button" class="btn btn-outline btn-info" onclick="javascript:addAttribute()">
					<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
				</button>
			</div>
			<div class="table-responsive" style="margin-top: 20px;">
				<div class="table-responsive">
					<table id="admin_menu_column_datagrid" data-toolbar="#toolbar"
						data-show-refresh="true" data-show-toggle="true"
						data-show-columns="true" data-show-footer="false"
						data-mobile-responsive="true">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
