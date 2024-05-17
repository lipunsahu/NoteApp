<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
	<%
	User sessionUser = (User) session.getAttribute("userObj");
	if (sessionUser == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>

	<%@ include file="components/homeNavbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Note</p>
						
						<form action="addNote" method="post">
							<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Description</label> 
								<textarea rows="10" cols="46" name="description" class="form-control"></textarea>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	}
	%>
</body>
</html>