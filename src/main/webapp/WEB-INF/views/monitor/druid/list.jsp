<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" language="javascript">
	function iFrameHeight() {
		var ifm = document.getElementById("iframepage");
		var subWeb = document.frames ? document.frames["iframepage"].document
				: ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
		}
	}
</script>
<div class="wrapper wrapper-content gray-bg animated fadeInRight"
	style="height: 100%">
	<div class="ibox">
		<div class="ibox-content">
			<iframe id="iframepage" name="iframepage" onLoad="iFrameHeight()"
				frameborder="0" border="10" marginwidth="100" marginheight="0"
				scrolling="no" allowtransparency="no" width=100% height=100%
				src="${pageContext.request.contextPath}/druid"></iframe>
		</div>
	</div>
</div>
