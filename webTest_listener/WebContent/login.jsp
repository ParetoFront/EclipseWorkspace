<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
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
		//1.获取有客户端提供的locale
		//2.创建resourcesBundle
		//3.把所有信息用rb.getString获得
		
		Locale locale=request.getLocale();
		ResourceBundle rb=ResourceBundle.getBundle("res",locale);
	%>
	<h1><%=rb.getString("login") %></h1>
	<form action="">
		<%=rb.getString("username") %> <input type="text" name="username" /> <br/>
		<%=rb.getString("password") %><input type="text" name="password" /> <br/>
		<input type="submit" value="提交" />
	</form>
</body>
</html>