<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("code", "<script>alert('hello')</script>");
%>
<c:set var="code2" value="<script>alert('hello55555555')</script>"></c:set>
${code2 }
<c:out value="${code }" escapeXml="false"></c:out>
<c:forEach var="i" begin="1" end="10">
	${i }
</c:forEach>
</body>
</html>