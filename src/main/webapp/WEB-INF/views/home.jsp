<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="/WEB-INF/views/layouts/main.jsp" />

<body>
	<jsp:include page="/WEB-INF/views/layouts/headerMenu.jsp">
		<jsp:param name="active" value="navHome" />
	</jsp:include>
	<div class="container">
		<div class="row row-offcanvas">
			<div class="col-md-offset-1 col-lg-offset-1 col-xs-12 col-sm-12 col-md-10 col-lg-10">
				<div class="jumbotron hidden-xs">
					<h1>Resident Scheduler</h1>
					<p>Use this application to schedule, log, and run violation analyses for residents.</p>
				</div>
				<div class="jumbotron jumbotron-xs visible-xs">
                    <h1>Resident Scheduler</h1>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>
	</div>
</body>
</html>