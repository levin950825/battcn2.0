<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="battcn" uri="http://www.battcn.com/tags"%>
<div class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate" id="menu${OP.menu}Form" method="post">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单：</label>
				<div class="col-sm-8">
					<select class="form-control m-b" name="menu">
						<option value="">请选择菜单</option>
						<battcn:list var="m" namespace="com.battcn.platform.mapper.pub.MenuMapper.listMenuByscort">
							<option value="${m.id}"
								<c:if test="${m.id == dto.menu}" >selected</c:if>>
								<c:forEach var="a" begin="0" end="${m.nlevel}"> －  </c:forEach> ＋ ${m.name}
							</option>
						</battcn:list>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">操作名称：</label>
				<div class="col-sm-8">
					<input name="name" value="${dto.name}" class="form-control"
						validate="{ required: true,maxlength:20,messages:{required:'请填写操作',maxlength:' '}}"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">代码：</label>
				<div class="col-sm-8">
					<input name="op" value="${dto.op}" class="form-control"
						validate="{ required: true,maxlength:20,messages:{required:'请填写操作代码',maxlength:' '}}"
						type="text">
					<div class="help-block m-b-none">
						<i class="fa fa-info-circle"></i> 比如list add edit remove save 等
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">图标：</label>
				<div class="col-sm-8">
					<input name="icon" value="${dto.icon}" class="form-control"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">排序：</label>
				<div class="col-sm-8">
					<input name="ordno" value="${dto.ordno}" class="form-control"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<textarea name="remark" cols="55" rows="3" style="resize: vertical;" class="form-control">${dto.remark}</textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label">工具栏：</label>
				<div class="col-sm-8">
					<div class="radio i-checks radio-inline">
						<label> <input type="radio" value="1"
							<c:if test="${dto.isshow == 1}" > checked</c:if> name="isshow">
							<i></i> 启动
						</label>
					</div>
					<div class="radio i-checks radio-inline">
						<label> <input type="radio"
							<c:if test="${dto.isshow == 0}" > checked</c:if> value="0"
							name="isshow"> <i></i>禁用
						</label>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
  $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
  $(function(){
	  	battcn.admin.menu${OP.menu}.save = function() {
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
		       		     msg: data.success ? '成功' :'失败'
		       		});
				}
			});
  		}
	}
});
</script>