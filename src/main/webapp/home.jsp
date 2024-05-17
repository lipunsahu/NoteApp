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
	<h1 class="text-center">
		Hey

		<%=sessionUser.getName()%>
		,Welcome TO No Note App
	</h1>
	
	<a href="./addNotes.jsp"><button class="btn bg-primary text-white col-md-12">Add Note</button></a>
	
	<%String msg = (String) session.getAttribute("addnote");
						
		if(msg != null){%>
							
			<h3 class="text-center text-danger"><%= msg %></h3>
			<%
			session.removeAttribute("addnote");
						}
	%>


	<%
	}
	%>
</body>
</html>