<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="header.jspf" %>
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<c:forEach items="${list }" var="bean">
			<div class="card">
			  <div class="card-header">
			  <p class="card-text">${bean.empno }</p>
			  </div>
			  <div class="card-body">
			    <h5 class="card-title">${bean.ename }</h5>
			    <p class="card-text">${bean.hiredate }</p>
			    <a href="${bean.empno }" class="btn btn-primary">Detail</a>
			  </div>
			</div>	
		</c:forEach>
	</div>
</body>
</html>