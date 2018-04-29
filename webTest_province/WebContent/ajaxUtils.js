/**
 * 
 */
// 创建request
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest(); // 支持大多数浏览器
	} catch (e) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP"); // 支持IE6.0
		} catch (e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP"); // 支持IE5.5级以前的版本
			} catch (e) {
				alert("您的浏览器太奇葩了");
				throw e;
			}
		}
	}
}
// option中需要的参数有：
// 请求方式 method ,请求的url url ,是否异步 asyn,请求体 params,回调方法callback,服务器响应数据类型 type
function ajax(option) {
	var xmlHttp = createXMLHttpRequest();
	if (!option.method) { // method默认为GET
		option.method = "GET";
	}
	if (option.asyn == undefined) { // 默认支持异步
		option.asyn = true;
	}
	xmlHttp.open(option.method,option.url, option.asyn);
	// 判断是否为POST请求，若是则设置请求头
	if ("POST" == option.method) {
		xmlHttp.setRequstHeader("Content-Type",
				"applicaton/x-www-form-urlencoded");
	}
	// 若是GET类型请求，params自然不会传过去
	xmlHttp.send(option.params);
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var data;
			var type=option.type;
			if (!type) { // 默认按text处理
				data = xmlHttp.responseText;
			} else if (type == "xml") {
				data = xmlHttp.responseXML;
			} else if (type == "text") {
				data = xmlHttp.responseText;
			} else if (type == "json") {
				var text = xmlHttp.responseText;
				data = eval("(" + text + ")");
			}
			// 调用回调方法
			option.callback(data);
		}
	}
}