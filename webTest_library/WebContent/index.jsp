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
<h1>查询页面</h1>
<a href="<c:url value='/BookServlet?method=findAll'/> ">查询所有</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=1'/> ">查询SE类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=2'/> ">查询EE类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=3'/> ">查询框架</a>

</body>
</html>