<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web from chen</title>
</head>
<body>
<h1>welcome to chen's web</h1>
<!--  禁止未登录用户访问本页面-->
<c:choose>
	<c:when test="${empty sessionScope.sessionUser }">您尚未登录，无法访问本页面！</c:when>
	<c:otherwise>
		您的用户名为：${sessionScope.sessionUser.username }<br/>
		您的密码为：${sessionScope.sessionUser.password }
	</c:otherwise>
</c:choose>
</body>
</html>