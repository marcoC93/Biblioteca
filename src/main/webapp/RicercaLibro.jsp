<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String logged = (String)request.getSession().getAttribute("logged"); out.println(logged) ;%>
	<% if (logged == null){
		response.sendRedirect("LoginUtente.jsp");
	}
	
	else {
		out.println("Benvenuto nella biblioteca") ;
	}
	
	
	%>
</body>
</html>