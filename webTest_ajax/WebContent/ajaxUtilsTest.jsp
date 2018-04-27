<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<c:url value='/ajaxUtils.js'/>"></script>
<script type="text/javascript">
	window.onload=function(){
		var btn=document.getElementById("btn");
		btn.onclick=function(){
			ajax(
				{
					url:"<c:url value='/JSONServlet'/>",
					type:"json",
					callback:function(data){
						document.getElementById("h1").innerHTML=data.name+","+data.age;
					}
				}		
			);
		};
	};
</script>
<body>
	<button id="btn">点击此处测试ajaxUtils</button>
	<h1 id="h1"></h1>
</body>
</html>