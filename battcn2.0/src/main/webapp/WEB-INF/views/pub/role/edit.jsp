<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
 		var operates = [
		                <c:forEach var="m" varStatus="n" items="${ops}">
		                <c:if test="${n.index != 0}">,</c:if> 
		                  '${m.op_id}'
		               </c:forEach>
		];
 		
 		
		$(function() {
			console.info(operates);
			IDMark_A = "_a";
			/* 初始化功能树 */
			//ztree树  view回调方法 ：能够自定义树 追加内容
			$.fn.zTree.init($('#menuTree'), {
				data : {
					simpleData : {
						enable : true
					}
				},
				view: {
					addDiyDom: function(treeId, treeNode) {
						var aObj = $("#" + treeNode.tId + IDMark_A);
						var html = [];
						for(var i=0;i<treeNode.operates.length;i++) {
							var op = treeNode.operates[i];
							var span = "<font style='margin-top:3px;'>"+op.name+"</font>";
							html.push(" <label><input class=\"operates\" type=\"checkbox\" name=\"operates\" value=\""+op.id+"\""+($.inArray(op.id,operates)!=-1?" checked":"")+"/>"+span+"</label>");
						}
						aObj.after(html.join(""));
					}
				},
				callback : {
					onClick : function(event, treeId, treeNode, clickFlag) {
						//
					}
				}
			}, [ 
			<c:forEach varStatus="in" var="m" items="${menus}">
			  <c:if test="${in.index != 0}">,</c:if>{
				    "id" : '${m.id}',
					"pId" : '${m.pId}',
					"name" : "${m.name}",
					"open" : true,
					"operates" : [
					    <c:forEach varStatus="oi" var="o" items="${m.operates}">
					    <c:if test="${oi.index != 0}">,</c:if>
					    {"id" : '${o.id}', "name" : '${o.name}'}
						</c:forEach>   
					]
				}
			 </c:forEach>    
			]);
		
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
                 <div class="col-sm-8" >
                     <div  style="width: 470px; height:auto ; overflow: auto; border-width: 1px; border-color: #ccc; border-style: solid; padding: 1px;">
						<div id="menuTree" class="ztree"></div>
					</div>
					<label><input id="checkAll"  onclick="javascript:$('.operates').prop('checked',($(this).prop('checked') ? true : false ));"   type="checkbox" />全选/不选 </label>
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

