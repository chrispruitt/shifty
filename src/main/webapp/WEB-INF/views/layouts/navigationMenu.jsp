<%@ include file="/WEB-INF/views/layouts/taglib.jsp" %>
<script>
	$(document).ready(function(){
		var selected = "<%= request.getParameter("active") %>";
		$("#" + selected).addClass("active");
	});
</script>

<div class="hidden-xs col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	<div class="list-group">
		<a id="navHome" href="${pageContext.request.contextPath}/" class="list-group-item">Home</a>
		<a id="navSchedule" href="${pageContext.request.contextPath}/schedule" class="list-group-item">Schedules</a>
	</div>
</div>