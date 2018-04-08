<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="chen" uri="/WEB-INF/tlds/chen.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><chen:myTag/></h1>
<chen:myTag2/>
<chen:myTag3>我是张三</chen:myTag3>
<chen:myTag5 test="true">如果test为true就打印</chen:myTag5>
<chen:myTag4/>
本页面剩余内容（测试用）
</body>
</html>