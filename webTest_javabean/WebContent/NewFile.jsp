<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.chen.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello</h1>
	<%
		Person pp = new Person();
		pp.setAge(23);
		pp.setName("sss");
		request.setAttribute("person", pp);
	%>
	${requestScope.person.name }
</body>
</html>