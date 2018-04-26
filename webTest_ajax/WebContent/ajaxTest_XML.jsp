<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() { //文档加载完毕后触发
		var btn = document.getElementById("btn");
		btn.onclick = function() {
			//进行ajax四部操作
			//1. 获取异步对象 
			var xmlHttp = createXMLHttpRequest();
			//2. 打开与服务器的连接
			xmlHttp.open("GET", "<c:url value='/XMLServlet'/>", true);
			//3. 发送请求
			xmlHttp.send(null);
			// 4.注册监听器
			xmlHttp.onreadystatechange = function() {
				//双重判断，要求服务器响应完毕且服务器响应的状态码为成功  
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					//获取服务器响应的XML 
					var doc = xmlHttp.responseXML;
					//查找documen中所有元素，得到数组，再取下标0的元素
					var ele = doc.getElementsByTagName("student")[0];
					//在XMLServlet中，返回的xml内容中，number是id属性，所以用getAttribute获取
					var number = ele.getAttribute("number");
					var name = ele.getElementsByTagName("name")[0].textContent;
					var age = ele.getElementsByTagName("age")[0].textContent;
					var sex = ele.getElementsByTagName("sex")[0].textContent;
					var text = number + "," + name + "," + age + "," + sex;
					document.getElementById("h1").innerHTML = text;
				}
			};
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
</head>
<body>
	<button id="btn">点击这里获取xml信息</button>
	<h1 id="h1"></h1>
</body>
</html>