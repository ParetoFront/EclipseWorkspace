<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){  //文档加载完毕后触发
		var btn=document.getElementById("btn");
		btn.onclick=function(){
			//进行ajax四部操作
			//1. 获取异步对象 
			var xmlHttp=createXMLHttpRequest();
			xmlHttp.open("POST","/webTest_ajax/AServlet",true);
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttp.send("username=mike&password=123");
			// 4.注册监听器
			xmlHttp.onreadystatechange=function(){
				//双重判断，要求服务器响应完毕且服务器响应的状态码为成功  
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var text=xmlHttp.responseText;
					var hi=document.getElementById("hi");
					hi.innerHTML=text;
				}
			};
		};
	};
	//创建异步对象 
	function createXMLHttpRequest(){
		try{
			return new XMLHttpRequest();   //支持大多数浏览器
		}catch(e){
			try{
				return new ActiveXObject("Msxml2.XMLHTTP"); //支持IE6.0
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP"); //支持IE5.5级以前的版本
				}catch(e){
					alert("您的浏览器太奇葩了");
					throw e;
				}
			}
		}
	}
	
</script>
</head>
<body>
	<button id="btn">post请求方式异步获取资源</button>
	<h1 id="hi"></h1>
</body>
</html>