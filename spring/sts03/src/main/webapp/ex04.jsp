<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.add("item5");
		list.add("item6");
		list.add("item7");
		
		pageContext.setAttribute("list", list);
	%>
	<h1>list</h1>
	
	<ul>
	<c:forEach items="${list }" var="item" step="2" varStatus="status">
		<li>${item } - ${status.index }, ${status.count }</li>
	</c:forEach>
	</ul>
</body>
</html>