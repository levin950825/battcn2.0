<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
						battcn.reloadDiv(rootPath + '/op_list_${OP.menu}.shtml');
					}
					battcn.toastrsAlert({
		       		     code: data.success ? 'success' :'error',
		       		     msg: data.success ? '成功' :'失败'
		       		});
				}
			});
  		}
		 
	}
  	
  	battcn.admin.menu${OP.menu}.imgs = function (){
  		battcn.showWindow({
			title:'使用规则',
			type:2,
			href:'http://www.zi-han.net/theme/hplus/fontawesome.html?v=4.0#contao',
			width : '45%',
			height : '65%',
			okhandler:function(){
				battcn.closeWindow();
			},
			cancelhandler:function(){
				battcn.closeWindow();
			}
		});
  	}
 });
</script>
<div class="ibox float-e-margins">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate" id="menu${OP.menu}Form">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称：</label>
				<div class="col-sm-8">
					<input name="name" class="form-control" value="${dto.name}"
						validate="{required:true,messages:{required:'请填写菜单名称'}}"
						type="text">
					<!-- <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span> -->
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">上级菜单：</label>
				<div class="col-sm-8">
					<select class="form-control m-b" name="pid">
						<option value="">请选择上级菜单</option>
						<battcn:list var="d" namespace="com.battcn.platform.mapper.pub.MenuMapper.listMenuByscort">
							<option value="${d.id}"
								<c:if test="${d.id == dto.pid }" > selected</c:if>>
								<c:forEach var="a" begin="0" end="${d.nlevel}">
                                                                                                           －
                                             </c:forEach> ＋ ${d.name}
							</option>
						</battcn:list>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">图标：</label>
				<div class="col-sm-8">
					<input name="img" class="form-control" type="text"
						value="${dto.img}"
						validate="{required:true,messages:{required:'请填写img'}}">
					<span class="help-block m-b-none"><i
						class="fa fa-info-circle"></i> <a href="javascript:;"
						onClick="battcn.admin.menu${OP.menu}.imgs();">点我查看使用规则</a></span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">目录：</label>
				<div class="col-sm-8">
					<input name="channel" class="form-control" type="text"
						value="${dto.channel}"
						validate="{required:true,messages:{required:'请填写目录'}}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">参数：</label>
				<div class="col-sm-8">
					<input name="param" class="form-control" type="text"
						value="${dto.param}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">排序：</label>
				<div class="col-sm-8">
					<input name="ordno" class="form-control" type="text"
						value="${dto.ordno}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<div class="radio i-checks    radio-inline">
						<label> <input type="radio" value="true"
							<c:if test="${dto.state == true}" > checked</c:if> name="state">
							<i></i> 启动
						</label>
					</div>
					<div class="radio i-checks    radio-inline">
						<label> <input type="radio"
							<c:if test="${dto.state == false}" > checked</c:if> value="false"
							name="state"> <i></i>禁用
						</label>
					</div>
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


