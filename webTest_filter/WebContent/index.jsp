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
<h1>您是普通游客</h1><br/>
<h1>欢迎访问，您的ip访问次数将被记录</h1><br/>

<a href="<c:url value='/user/user.jsp' />" >会员入口</a><br/>
<a href="<c:url value='/admin/admin.jsp' />" >管理员入口</a>
</body>
</html>