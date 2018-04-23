<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){   //文档加载完成后立即执行 
		var btn=document.getElementById("btn");  //得到btn元素
		btn.onclick=function(){    //为btn的click事件注册监听
			var hi=document.getElementById("hi");
			hi.innerHTML="hello ,it is JS!";
		};
	};
</script>
</head>
<body>
<button id="btn">点击这里</button>
<h1 id="hi"></h1>
</body>
</html>