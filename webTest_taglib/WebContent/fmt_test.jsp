<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
		request.setAttribute("date", date);
		request.setAttribute("num1", 3.1415926);
	%>
	<f:formatDate value="${requestScope.date }" pattern="yyyy-MM-dd hh-mm-ss" />
	<f:formatNumber value="${requestScope.num1 }" pattern="0.00"></f:formatNumber>
	<br />
	
</body>
</html>