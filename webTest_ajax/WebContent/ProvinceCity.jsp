<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET", "<c:url value='/ProvinceServlet'/>", true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				var arr = text.split(",");
				for (var i = 0; i < arr.length; i++) { //遍历所有province
					var opt = document.createElement("option");
					opt.value = arr[i]; //设置opt的实际值
					var textNode = document.createTextNode(arr[i]); //创建一个文本子节点
					opt.appendChild(textNode); //将文本子节点添加为opt子元素，即显示值
					document.getElementById("p").appendChild(opt);
				}
			}
		};
		//给province选项框添加改变监听器，使用选择的身份名称请求CityServlet，从返回值中解析每个city，冰添加到city选项框中
		var proSelect = document.getElementById("p");
		proSelect.onchange = function() {
			var xmlHttp = createXMLHttpRequest();
			xmlHttp.open("POST", "<c:url value='/CityServlet'/>", true);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlHttp.send("proName=" + proSelect.value);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					//将select中除提示项以外所有option移除
					var citySelect = document.getElementById("c"); 
					var optionEleList=citySelect.getElementsByTagName("option");
					//循环遍历option，移除非提示项
					while(optionEleList.length>1){
						citySelect.removeChild(optionEleList[1]);
					}
					var doc = xmlHttp.responseXML;
					var cityEleList = doc.getElementsByTagName("city"); //得到city列表
					for (var i = 0; i < cityEleList.length; i++) {
						var cityEle = cityEleList[i];
						var cityName;
						if (window.addEventListener) { //处理浏览器差异
							cityName = cityEle.textContent;
						} else {
							cityName = cityEle.text;
						}
						var opt = document.createElement("option");
						opt.value = cityName;
						var textNode = document.createTextNode(cityName);
						opt.appendChild(textNode);
						document.getElementById("c").appendChild(opt);
					}
				}
			}
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
	<!--页面的工作：
	第一部分：
		获取provinceServlet返回的字符串，用逗号分割，循环遍历该字符串，
		为每个province创建一个option元素加到province选择框中
	第二部分：
		0. 将city选择框中的子元素删除，但不要删除提示内容
		1. 得到服务器响应的结果（是一个doc）
		2. 获取所有的city子元素，循环遍历，得到city内容
		3. 使用每个city的内容创建一个option元素添加到city选择框中
-->
	<h1>省市联动</h1>
	<select id="p" name="province">
		<option>===请选择省===</option>
	</select>
	<select id="c" name="city">
		<option>===请选择市===</option>
	</select>
</body>
</html>