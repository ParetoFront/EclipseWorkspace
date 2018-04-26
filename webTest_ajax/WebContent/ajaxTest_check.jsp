<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 本例演示如何在表单提交前校验用户是否已注册  
    方法：在用户名输入框添加onblur监听 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.onload = function() { 
		var userEle = document.getElementById("username");
		//失去焦点的事件监听 
		userEle.onblur = function() {
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value='/CheckServlet'/>", true);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			//4. 发送参数 
			xmlHttp.send("username="+userEle.value);
			// 4.注册监听器
			xmlHttp.onreadystatechange = function() {
				//双重判断，要求服务器响应完毕且服务器响应的状态码为成功  
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					var text = xmlHttp.responseText;
					var span = document.getElementById("errorSpan");
					span.innerHTML = text;
				}
			};
		};
	};
	//创建异步对象 
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest(); //支持大多数浏览器
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP"); //支持IE6.0
			} catch (e) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP"); //支持IE5.5级以前的版本
				} catch (e) {
					alert("您的浏览器太奇葩了");
					throw e;
				}
			}
		}
	}
</script>
</head>
<body>
<h1>演示用户名是否已被注册</h1>
<form action="" method="post">
	用户名：<input type="text" name="username" id="username"/><span id="errorSpan"></span><br/>
	密码： <input type="text" name="password" id="password"/><br/>
	<input type="submit" value="注册"/>
</form>
</body>
</html>