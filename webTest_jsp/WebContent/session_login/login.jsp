<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>本页面提供登录表单，并提供错误信息,支持cookie进行默认输入</h1>
<%
  	//读取名为uname的cookie
  	String uname="";
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie ck:cookies){
			if("uname".equals(ck.getName())){ 
				uname=ck.getValue();
			}
		}
	}
%>
<%
	String message="";
	String msg=(String)request.getAttribute("msg");
	if(msg!=null){
		message=msg;
	}
%>
<font color="red"><b><%= message %></b></font>
<form action="/webTest_jsp/loginServlet" method="post">
	用户名：<input type="text" name="username" value="<%=uname%>"/><br/>
	密码：<input type="text" name="password"/><br/>
	<input type="submit" value="登录"/>
</form>

</body>
</html>