<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<c:url value='/ajaxUtils.js'/>"></script>
<script type="text/javascript">
	window.onload = function() {
		xmlHttp = createXMLHttpRequest();
		xmlHttp.open("GET", "<c:url value='/ProvinceServlet'/>", true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var proArray = eval("(" + xmlHttp.responseText + ")"); //处理response返回的json语句
				for (var i = 0; i < proArray.length; i++) {
					var pro = proArray[i];
					var opt = document.createElement("option");
					opt.value = pro.pid; //给option的实际值赋值，赋值为pid
					var textNode = document.createTextNode(pro.pname);
					opt.appendChild(textNode);
					document.getElementById("province").appendChild(opt);
				}

			}
			;
			var proSelect = document.getElementById("province");
			proSelect.onchange = function() {
				xmlHttp = createXMLHttpRequest();
				xmlHttp.open("POST", "<c:url value='/CityServlet'/>", true);
				xmlHttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xmlHttp.send("pid=" + proSelect.value); //proSelect.value也就是所选择的的省的pid 
				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						//清空原city选项
						var citySelect = document.getElementById("city");
						var cityOptionArray = citySelect
								.getElementsByTagName("option");
						while (cityOptionArray.length > 1) {
							citySelect.removeChild(cityOptionArray[1])
						}
						var cityArray = eval("(" + xmlHttp.responseText + ")"); //处理返回的json语句
						for (var i = 0; i < cityArray.length; i++) {
							var city = cityArray[i];
							var opt = document.createElement("option");
							opt.value = city.cid; //给option的实际值赋值，赋值为pid
							var textNode = document.createTextNode(city.cname);
							opt.appendChild(textNode);
							document.getElementById("city").appendChild(opt);
						}
					}
				}
			};
		};
	};
</script>
<body>
	<h1>省市联动</h1>
	省
	<select id="province">
		<option value="">请选择</option>
	</select> 市
	<select id="city">
		<option value="">请选择</option>
	</select>
</body>
</html>