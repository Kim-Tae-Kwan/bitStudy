<%@page import="java.util.List"%>
<%@page import="com.bit.spring.model.EmpVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/header.jspf" %>
</head>
<body>
	<%@ include file="../template/menu.jspf" %>
	<div class="container">
		<div class="jumbotron">
		  <h1>EMP Detail page</h1>
		</div>
		<form class="form-horizontal" action="update.bit" method="post">
		  <div class="form-group">
		    <label for="empno" class="col-sm-2 control-label">empno</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="empno" id="empno" placeholder="empno" value="${bean.empno }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="ename" class="col-sm-2 control-label">ename</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="ename" id="ename" placeholder="ename" value="${bean.ename }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="sal" class="col-sm-2 control-label">sal</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="sal" id="sal" placeholder="sal" value="${bean.sal }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="job" class="col-sm-2 control-label">job</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="job" id="job" placeholder="job" value="${bean.job }">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
			    <div class="btn-group btn-group-justified" role="group" aria-label="...">
			      <button type="submit" class="btn btn-primary">입력</button>
			      <button type="button" class="btn btn-danger">삭제</button>
			      <button type="reset" class="btn btn-default">취소</button>
			      <button type="button" class="btn btn-default	" onclick="history.back();">뒤로</button>
			    </div>
		    </div>
		  </div>
		</form>
	</div>
	<script type="text/javascript">
		var del = function(){
			$.post('delete.bit', 'empno=${bean.empno}', function(){
				location.href='list.bit';
			});
			
		};
		var edit = function (e) {
			$('input').prop('readonly', false).first().prop('readonly', true);
			$('.btn.btn-danger').hide().next().show();
			$('.jumbotron>h1').text('EMP Edit page')
			return false;
		};
	
		$('input').prop('readonly', true);
		$('.btn.btn-danger').show().next().hide();
		$('.btn.btn-danger').on('click', del);
		$('form').one('submit', edit);
	</script>
</body>
</html>