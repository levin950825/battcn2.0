<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="battcn" uri="http://www.battcn.com/tags"%>
<script type="text/javascript">
  $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
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
			id="menu${OP.menu}Form" action="op_save_${OP.menu}.shtml"
			method="post">
			<input type="hidden" name="managerid" value="${dto.managerid}" />
			<div class="form-group">
				<label class="col-sm-3 control-label">姓名：</label>
				<div class="col-sm-8">
					<input name="name" class="form-control" type="text"
						value="${dto.name}"
						validate="{required:true,messages:{required:'请填写姓名'}}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">帐号：</label>
				<div class="col-sm-8">
					<c:if test="${empty dto.managerid}">
						<input name="account" class="form-control" value="${dto.account}"
							validate="{required:true,messages:{required:'请填写帐号'}}"
							type="text">
					</c:if>
					<c:if test="${not empty dto.managerid}">
						<span style="display: block; margin-top: 6px;">${dto.account}</span>
						<input type="hidden" name="account" class="formText"
							value="${dto.account}" />
					</c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">角色：</label>
				<div class="col-sm-8">
					<select class="form-control m-b" name="role">
						<option value="">请选择角色</option>
						<battcn:list var="m"
							namespace="com.battcn.platform.mapper.pub.RoleMapper.listRoleByscort">
							<option value="${m.id}"
								<c:if test="${m.id == dto.role}" >selected</c:if>>${m.name}
							</option>
						</battcn:list>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码：</label>
				<div class="col-sm-8">
					<input name="password" id="password" class="form-control"
						validate="{<c:choose><c:when test="${empty dto.managerid}">required: true,</c:when><c:otherwise></c:otherwise></c:choose> minlength:4,maxlength:20,messages:{<c:if test="${empty dto.managerid}">required:'请填写密码',</c:if>minlength:'密码必须大于等于4',maxlength:'密码必须小于等于20'}}"
						type="password">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">确认密码：</label>
				<div class="col-sm-8">
					<input name="rePassword" class="form-control" type="password"
						validate="{<c:if test="${empty dto.managerid}">required:true,</c:if>equalTo:'#password',messages:{<c:if test="${empty dto.managerid}">required:'请填写重复密码',</c:if>equalTo:'两次密码输入不一致'}}">
					<span style="color: red;">不填为则不修改密码</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<div class="radio i-checks radio-inline">
						<label> <input type="radio" value="1"
							<c:if test="${dto.locked == 1}"> checked</c:if> name="locked">
							<i></i> 启动
						</label>
					</div>
					<div class="radio i-checks    radio-inline">
						<label> <input type="radio"
							<c:if test="${dto.locked == 0}"> checked</c:if> value="0"
							name="locked"> <i></i>禁用
						</label>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
