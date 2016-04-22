<script>
	$(document).ready(function(){
		var selected = "<%= request.getParameter("active") %>";
		var mobileTitle = "<%= request.getParameter("mobileTitle") %>";
		$("#" + selected).addClass("active");
		
		if(mobileTitle == "null" || mobileTitle == "")
		{
			mobileTitle = "Resident Scheduler";
		}
		$("#mobileTitle").html(mobileTitle);
	});
</script>

<div class="navbar navbar-fixed-top navbar-inverse" role="navigation" style="margin:0px">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand hidden-xs" href="${pageContext.request.contextPath}/">Resident Scheduler</a>
			<a id="mobileTitle" class="navbar-brand visible-xs" href="${pageContext.request.contextPath}/">Resident Scheduler</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id="navHome"><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li id="navSchedule"><a href="${pageContext.request.contextPath}/schedule">Schedules</a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</div>
<div class="hidden-xs" style="margin-bottom:20px"></div>