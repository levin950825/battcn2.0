<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>

<div id="dialog-add" class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate" id="menuCodeColumnForm" method="post">
			<input type="hidden" id="cid" name="uuid" value="${dto.uuid}">
			<div class="form-group">
				<label class="col-sm-2 control-label">属性名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="attributeName" value="${dto.attributeName}" placeholder="首字母必须为字母或下划线" 
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
					<input type="text" class="form-control" name="defaultVal" value="${dto.defaultVal}" placeholder="默认值" title="默认值"
						validate="{required:true,messages:{required:'请填写默认值'}}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">备注：</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" name="remake" value="${dto.remake}"  placeholder="备注" title="备注"
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