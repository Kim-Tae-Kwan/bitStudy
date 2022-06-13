<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="header.jspf" %>
<script type="text/javascript">
</script>
</head>
<body>
	<%@ include file="menu.jspf" %>
	<div class="container">
		<form action="./" method="post">
			<input type="hidden" name="_method" value="put">
		  <div class="mb-3">
		    <label for="empno" class="form-label">empno</label>
		    <input type="text" class="form-control" id="empno" name="empno" value="${bean.empno}" readonly>
		  </div>
		  <div class="mb-3">
		    <label for="ename" class="form-label">ename</label>
		    <input type="text" class="form-control" id="ename" name="ename" value="${bean.ename}" readonly>
		  </div>
		  <div class="mb-3">
		    <label for="sal" class="form-label">sal</label>
		    <input type="text" class="form-control" id="sal" name="sal" value="${bean.sal}" readonly>
		  </div>
		  <div class="mb-3">
		    <label for="job" class="form-label">job</label>
		    <input type="text" class="form-control" id="job" name="job" value="${bean.job}" readonly>
		  </div>
		  <button type="submit" class="btn btn-primary">수정</button>
		  <button type="button" class="btn btn-danger">삭제</button>
		  <button type="reset" class="btn btn-default">취소</button>
		  <button type="button" class="btn btn-default" onclick="history.back();">뒤로</button>
		</form>
	</div>
</body>
</html>