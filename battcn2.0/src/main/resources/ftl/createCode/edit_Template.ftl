<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
  $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
  $(function(){
  	battcn.admin.menu${(OP.menu)!'$'+'{OP.menu}'}.save = function(obj) {
  		if($("#menu${(OP.menu)!'$'+'{OP.menu}'}Form").valid()){
  			$.ajax({
				type: "POST", 
				url: rootPath + "/op_save_${(OP.menu)!'$'+'{OP.menu}'}.shtml",
				data: $('#menu${(OP.menu)!'$'+'{OP.menu}'}Form').serializeArray(),
				dataType: "json",
				success: function(data){
					if(data.success) {
						battcn.closeWindow();
						$('#admin_menu${(OP.menu)!'$'+'{OP.menu}'}_datagrid').bootstrapTable('refresh');
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
		<form class="form-horizontal m-t required-validate" id="menu${(OP.menu)!'$'+'{OP.menu}'}Form" method="post">
	<#list fieldList as var>
		<#if var[1] == 'Date'>
			<!-- 暂未完善,每个人的时间格式不一致  -->
		<#elseif var[1] == 'Integer'>
			<div class="form-group">
				<label class="col-sm-3 control-label">${var.remake}：</label>
				<div class="col-sm-8">
					<input name="${var.attributeName}" class="form-control" type="number"
						value="${(dto.menu)!'$'+'{dto.${var.attributeName}}'}"  placeholder="这输入${var.remake}"
						validate="{required:true,messages:{required:'这输入${var.remake}'}}">
				</div>
			</div>
		<#else>
			<div class="form-group">
				<label class="col-sm-3 control-label">${var.remake}：</label>
				<div class="col-sm-8">
					<input name="${var.attributeName}" class="form-control" type="text"
						value="${(dto.menu)!'$'+'{dto.${var.attributeName}}'}" placeholder="这输入${var.remake}"
						validate="{required:true,messages:{required:'这输入${var.remake}'}}">
				</div>
			</div>
		</#if>
	</#list> 
		</form>
	</div>
</div>
