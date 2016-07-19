<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="doc-buttons">
	<c:forEach var="operate" items="${operates}" >
		<c:if test="${operate.isshow == 1}">
			<button onclick="battcn.admin.menu${OP.menu}.${operate.op}();" class="btn btn-primary" type="button">
				<i class="fa fa-${operate.icon}"></i> ${operate.name}
			</button>
		</c:if>
	</c:forEach>
</div>

