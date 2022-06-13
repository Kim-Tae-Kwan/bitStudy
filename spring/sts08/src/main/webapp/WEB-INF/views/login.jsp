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
		<c:if test="${err ne null }">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>${err.message }</strong>
			  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		
		<form method="post">
		  <div class="mb-3">
		    <label for="empno" class="form-label">empno</label>
		    <input type="text" class="form-control" id="empno" name="empno" value="${bean.empno}">
		  </div>
		  <div class="mb-3">
		    <label for="ename" class="form-label">ename</label>
		    <input type="text" class="form-control" id="ename" name="ename" value="${bean.ename}">
		  </div>
		  <button type="submit" class="btn btn-primary">입력</button>
		  <button type="reset" class="btn btn-default">취소</button>
		  <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
		</form>
	</div>
</body>
</html>