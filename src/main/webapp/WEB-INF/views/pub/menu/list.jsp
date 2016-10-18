<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
.table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
	background-color: #FFF;
}
</style>
<div class="wrapper wrapper-content animated fadeInRight"
	style="height: 100%">
	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<%@ include file="/WEB-INF/views/common/toolbar.jsp"%>
			<div class="table-responsive" style="margin-top: 20px;">
				<form role="form" class="form-inline"
					action="${ctx}/menu/list.shtml">
					<table id="admin_menu${OP.menu}_datagrid"
						class="table table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th><input type="checkbox"
									onclick="$('.ii-checks').prop('checked',($(this).prop('checked') ? true : false ))"
									name="input[]"></th>
								<th>名称</th>
								<th>目录</th>
								<th>图标</th>
								<th>是否删除</th>
								<th>添加时间</th>
								<th>修改时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="tree">
								<tr
									class="treegrid-${tree.id} <c:if test="${tree.pid != 0}">treegrid-parent-${tree.pid}</c:if>">
									<td><input type="checkbox" class="ii-checks" name="check"
										value="${tree.id}"></td>
									<td>${tree.name}</td>
									<td>${tree.channel}</td>
									<td><i class="${tree.img} text-navy"></i></td>
									<td>${tree.state ? '<i class="fa fa-check text-navy"></i>' : '<i class="fa fa-close text-danger"></i> '}</td>
									<td><fmt:formatDate value="${tree.addtime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><fmt:formatDate value="${tree.updatetime}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="fixed-table-pagination"
						style="display: block; margin-top: -50px;">
						<div class="pull-left pagination-detail">
							<span class="pagination-info">显示第 ${page.pageNum} 到第
								${page.pageNum * page.pageSize } 条记录，总共${page.total}条记录</span> <span
								class="page-list">每页显示<span class="btn-group dropup">
									<button type="button" class="btn btn-default  dropdown-toggle"
										data-toggle="dropdown">
										<span class="page-size">${page.pageSize}</span> <span
											class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu" id="resources_meny">
										<li><a href="javascript:void(0)">10</a></li>
										<li><a href="javascript:void(0)">30</a></li>
										<li><a href="javascript:void(0)">50</a></li>
									</ul>
							</span> 条记录
							</span>
						</div>
						<div
							class="pull-right pagination ${page.pageSize >= page.total ? 'hidden' : null}">
							<ul class="pagination">
								<li
									class="page-first ${page.pageNum == page.firstPage ? 'disabled' : null}"
									onclick="loadResources(1)"><a href="javascript:void(0)">«</a></li>
								<li
									class="page-pre ${page.pageNum == page.firstPage ? 'disabled' : null}"
									onclick="loadResources(${page.pageNum-1})"><a
									href="javascript:void(0)">‹</a></li>
								<c:forEach begin="1" end="${page.pages}" varStatus="k">
									<li
										class="page-number ${page.pageNum == k.index ? 'active' : null}"
										onclick="loadResources(${k.index})"><a
										href="javascript:void(0)">${k.index}</a></li>
								</c:forEach>
								<li
									class="page-next ${page.pageNum == page.lastPage ? 'disabled' : null}"
									onclick="loadResources(${page.pageNum+1})"><a
									href="javascript:void(0)">›</a></li>
								<li
									class="page-last ${page.pageNum == page.lastPage ? 'disabled' : null}"
									onclick="loadResources(${page.lastPage})"><a
									href="javascript:void(0)">»</a></li>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		battcn.ns('battcn.admin.menu${OP.menu}');
		$('#admin_menu${OP.menu}_datagrid').treegrid(  {
				  expanderExpandedClass: 'glyphicon glyphicon-minus',
	            expanderCollapsedClass: 'glyphicon glyphicon-plus'
		}  );
	}) 
	$("#resources_meny>li").click(function(){
		battcn.reloadDiv(rootPath+"/pub/menu/list.shtml?pageSize="+$(this).text());
		//$(".J_mainContent div.J_box:visible").loadUrl(rootPath+"/pub/menu/list.shtml?pageSize="+$(this).text());
	});
	function loadResources(pageNum)
	{
		battcn.reloadDiv(rootPath+"/pub/menu/list.shtml?pageNum="+pageNum);
	}
	//删除
	battcn.admin.menu${OP.menu}.remove = function(){
		var cbox = [];
		$("input[name='check']").each(function(){
		    if(true == $(this).is(':checked'))cbox.push($(this).val());
		});
		if (cbox == "" || cbox.length==0) {
			battcn.toastrsAlert({
			     code:'info',
			     msg:'请选择你要删除的记录'
			});
			return;
		}
		layer.confirm('是否删除？', function(index) {
			$.ajax({
		          type: 'post',
		          url: rootPath + '/op_remove_${OP.menu}.shtml',
		          data: {"ids":cbox.join(",")},
		          dataType: 'json',
		          success: function (data) {
		          	battcn.reloadDiv(rootPath + '/op_list_${OP.menu}.shtml');
		          	battcn.closeWindow();
		          	battcn.toastrsAlert({
	              		 code: data.success ? 'success' :'error',
	    		       	 msg: data.success ? '成功' :'失败'
	         		});
		          }
		  	});
		})
	};
	
	battcn.admin.menu${OP.menu}.add = function(){
		battcn.showWindow({
				title:'增加菜单',
				href:'op_edit_${OP.menu}.shtml',
				width : '50%',
				height : '70%',
				okhandler:function(){
					battcn.admin.menu${OP.menu}.save();
				},
				cancelhandler:function(){
					battcn.closeWindow();
				}
			});
	}
	
	battcn.admin.menu${OP.menu}.edit = function(){
		var cbox = [];
		$("input[name='check']").each(function(){
		    if(true == $(this).is(':checked'))cbox.push($(this).val());
		});
		if (cbox == "") {
			layer.msg("请选择编辑项！！");
			return;
		}
		if (cbox.length > 1) {
			layer.msg("只能选中一个");
			return;
		}
		battcn.showWindow({
			title : '编辑菜单',
			href:'op_edit_${OP.menu}.shtml?id=' + cbox,
			width : '50%',
			height : '70%',
			okhandler:function(){
				battcn.admin.menu${OP.menu}.save();
			},
			cancelhandler:function(){
				battcn.closeWindow();
			}
		});
	}
</script>