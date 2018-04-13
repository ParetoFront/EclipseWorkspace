<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='<c:url value="/RegistServlet"/>' method="post">
		用户名：<input type="text" name="username" />${regist_errors.username }<br /> 
		密码 :  <input type="text" name="password" />${regist_errors.password }<br />
		验证码: <input type="text" name="verifycode" size="3"/>
		<img  id="regist_vcode" src="<c:url value='/VerifyServlet'/>" border="2"/>
		<a href="javascript:_change()">看不清，换一张</a>${regist_errors.verifycode }<br/>
		 <input type="submit" value="注册" />
	</form>
</body>
</html>