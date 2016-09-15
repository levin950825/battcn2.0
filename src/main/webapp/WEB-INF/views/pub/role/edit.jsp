<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		var zNodes =[
	  			{ id:1, pId:0, name:"系统管理", open:true,checked:true},
	  			{ id:11, pId:1, name:"菜单管理",checked:true},
	  			{ id:111, pId:11, name:"添加"},
	  			{ id:112, pId:11, name:"删除",checked:true},
	  			{ id:113, pId:11, name:"修改",checked:true},
	  			{ id:12, pId:1, name:"账号管理"},
	  			{ id:121, pId:12, name:"添加"},
	  			{ id:122, pId:12, name:"删除"},
	  			{ id:123, pId:12, name:"修改"},
	  		];
		$(document).ready(function(){
			$.fn.zTree.init($("#menuTree"),setting,zNodes);
		});
		
		$(function(){
		  	battcn.admin.menu${OP.menu}.save = function(obj) {
		  		if($("#menu${OP.menu}Form").valid()){
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
</script>
<div class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate"
			id="menu${OP.menu}Form" action="op_save_${OP.menu}.action"
			method="post">
			<input type="hidden" name="id" value="${dto.id}" />

			<div class="form-group">
				<label class="col-sm-3 control-label">角色名称：</label>
				<div class="col-sm-8">
					<input name="name" class="form-control" value="${dto.name}"
						validate="{required:true,messages:{required:'请填写名称'}}" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">角色代码：</label>
				<div class="col-sm-8">
					<c:choose>
						<c:when test="${empty dto.id}">
							<input name="code" class="form-control" value="${dto.code}"
								validate="{required:true,messages:{required:'请填写代码'}}"
								type="text">
						</c:when>
						<c:otherwise>
							<span style="display: block; margin-top: 6px;">${dto.code}</span>
							<input type="hidden" name="code" class="formText"
								value="${dto.code}" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限：</label>
				<div class="col-sm-8">
					<div style="width: 470px; height: auto; overflow: auto; border-width: 1px; border-color: #ccc; border-style: solid; padding: 1px;">
						<div id="menuTree" class="ztree">
							
						</div>
					</div>
					<!-- <label><input id="checkAll"
						onclick="javascript:$('.operates').prop('checked',($(this).prop('checked') ? true : false ));"
						type="checkbox" />全选/不选 </label> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<textarea id="ccomment" name="remark" cols="55" rows="3"
						class="form-control">${dto.remark}</textarea>
				</div>
			</div>
		</form>
	</div>
</div>

