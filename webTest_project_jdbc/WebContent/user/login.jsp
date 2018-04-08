<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<script type="text/javascript">
	function _change(){
		var imgEle=document.getElementById("login_vcode");
		
		// 要在js中使用jstl并不是直接将jstl的value赋值给一个js的变量，
		//而是要在jstl的value上加上""，比如一个从服务器端返回的数据可以这样赋值给js的变量。
		//加一个时间参数是为了令浏览器重新发送请求，避免浏览器使用缓存  
		imgEle.src="<c:url value='/VerifyServlet'/>"+"?"+new Date().getTime();
	}
</script>
<body>
<h1>登录</h1>
	<p style="color:red;font-weight:900">${msg }</p>
	<form action='<c:url value="/LoginServlet"/>' method="post">
		用户名：<input type="text" name="username" />${login_errors.username }<br /> 
		密码 :  <input type="text" name="password" />${login_errors.password }<br />
		验证码: <input type="text" name="verifycode" size="3"/>
		<img  id="login_vcode" src="<c:url value='/VerifyServlet'/>" border="2"/>
		<a href="javascript:_change()">看不清，换一张</a>${login_errors.verifycode }<br/>
		 <input type="submit" value="登录" />
	</form>
</body>
</html>