<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload = function() {
		var btn = document.getElementById("btn");
		btn.onclick = function() {
			var xmlHttp=createXMLHttpRequest();
			xmlHttp.open("GET","<c:url value='/JSONServlet'/>",true);
			xmlHttp.send(null);
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4&&xmlHttp.status==200){
					var text=xmlHttp.responseText;
					var person=eval("("+text+")");
					var str=person.name+","+person.age;
					document.getElementById("h1").innerHTML=str;
				}
			}
		};
	};
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
<body>
	<button id="btn">点击此处获取json内容</button>
	<h1 id="h1"></h1>
</body>
</html>