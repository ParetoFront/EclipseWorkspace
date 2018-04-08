<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username=(String)session.getAttribute("username");
	if(username==null){
		//向request中保存信息，转发给login.jsp，利用了转发的留头不留尾 
		request.setAttribute("msg","您还没有登录");
		request.getRequestDispatcher("/session_login/login.jsp").forward(request, response);
		return;
	}
%>
<h1>欢迎用户<%=username %>登录本站</h1>
</body>
</html>