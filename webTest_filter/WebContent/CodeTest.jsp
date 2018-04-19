<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<c:url value='/CodeServlet?username=张三'/>">这是一个get类型的请求</a>
<hr/>
这是一个post类型的请求

<form action="<c:url value='/CodeServlet'/>" method="post" >
	<input type="text" name="username"/><br/>
	<input type="submit" />
</form>
</body>
</html>