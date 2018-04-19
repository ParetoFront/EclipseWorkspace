<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
<c:forEach items="${pb.beanList }" var="cstm">
	<tr>
		<td>${cstm.cname }</td>
		<td>${cstm.gender }</td>
		<td>${cstm.birthday }</td>
		<td>${cstm.cellphone }</td>
		<td>${cstm.email }</td>
		<td>${cstm.description }</td> 
		<td>
		<!-- 每个“编辑“链接都带有独特的cid用于表明编辑对象  -->
			<a href="<c:url value='/CustomerServlet?method=preEdit&cid=${cstm.cid }'/>">编辑</a>
			<a href="<c:url value='/CustomerServlet?method=delete&cid=${cstm.cid }'/>">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
<center>
	第 ${pb.pc } 页 /共 ${pb.tp } 页
	<!--  <a href="<c:url value='/CustomerServlet?method=findAll&pc=1'/> ">首页</a> -->
	<a href="${pb.url }&pc=1">首页</a>
	<!-- 若当前为第一页，则上一页失效（不显示为超链接） -->
	<c:choose>
		<c:when test="${pb.pc>1 }">
			<a href="${pb.url }&pc=${pb.pc-1 }">上一页</a>
		</c:when>
		<c:when test="${pb.pc==1 }">
			上一页
		</c:when>
	</c:choose>
	<!-- 计算页码列表的begin、end -->
	<c:choose>
		<c:when test="${pb.tp<=10 }">
			<c:set var="begin" value="1"/>
			<c:set var="end" value="${pb.tp }"/>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${pb.pc-5 }"/>
			<c:set var="end" value="${pb.pc+4 }"/>
			<c:if test="${begin<1 }">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="10"/>
			</c:if>
			<c:if test="${end>pb.tp }">
				<c:set var="begin" value="${pb.tp-9 }"/>
				<c:set var="end" value="${pb.tp }"/>
			</c:if>
		</c:otherwise>
	</c:choose>
	<!-- 显示页码列表， 当前页不显示为超链接  -->
	<c:forEach var="i" begin="${begin }" end="${end }">
		<c:choose>
			<c:when test="${i eq pb.pc }">
				[${i }]
			</c:when>
			<c:otherwise>
				<a href="${pb.url }&pc=${i }"> [${i }] </a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${pb.pc<pb.tp }">
			<a href="${pb.url }&pc=${pb.pc+1 }">下一页</a>
		</c:when>
		<c:when test="${pb.pc==pb.tp }">
			下一页
		</c:when>
	</c:choose>
	<a href="${pb.url }&pc=${pc.tp }">尾页</a>
</center>
  </body>
</html>
