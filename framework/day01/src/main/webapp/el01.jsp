<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el language(LE 표현식)</h1>
	<p><%=1+2+3+4+5 %></p>
	<p>${1+2+3+4+5 }</p>
	<table>
		<tr>
			<th>자료형</th>
			<th>표현식</th>
			<th>EL</th>
			<th></th>
		</tr>
		<tr>
			<th>숫자(정수)</th>
			<th><%=-1234 %></th>
			<th>${-1234 }</th>
			<th></th>
		</tr>
		<tr>
			<th>숫자(실수)</th>
			<th><%=3.14 %></th>
			<th>${3.14 }</th>
			<th></th>
		</tr>
		<tr>
			<th>문자</th>
			<th><%='A' %></th>
			<th></th>
			<th>문자 지원안함(표현 안됨)</th>
		</tr>
		<tr>
			<th>문자열</th>
			<th><%="ABC" %></th>
			<th>${"ABC" }</th>
			<th>"",'' 둘다 문자열</th>
		</tr>
		<tr>
			<th>문자열</th>
			<th><%="ABC" %></th>
			<th>${"'ABC'" }</th>
			<th></th>
		</tr>
		<tr>
			<th>문자열</th>
			<th><%="ABC" %></th>
			<th>${'"ABC"' }</th>
			<th></th>
		</tr>
		<tr>
			<th>Boolean</th>
			<th><%=false %></th>
			<th>${false }</th>
			<th></th>
		</tr>
		<tr>
			<th>object</th>
			<th><%=new Date() %></th>
			<th></th>
			<th>전달 안 받음</th>
		</tr>
		<tr>
			<th>object</th>
			<th><%
			Object a = null;
			out.println(a); %></th>
			<th>${null }</th>
			<th>null 표현 안함</th>
		</tr>
		<tr>
			<th>연산(사칙)</th>
			<th><%=2*3 %></th>
			<th>${2*3 }</th>
			<th></th>
		</tr>
		<tr>
			<th>연산(사칙)</th>
			<th><%=5/2 %></th>
			<th>${5/2 }</th>
			<th></th>
		</tr>
		<tr>
			<th>연산(사칙)</th>
			<th><%=5%2 %></th>
			<th>${5 mod 2 }</th>
			<th></th>
		</tr>
		<tr>
			<th>비교</th>
			<th><%=5>2 %></th>
			<th>${5 gt 2 }</th>
			<th></th>
		</tr>
		<tr>
			<th>비교</th>
			<th><%=5<2 %></th>
			<th>${5 lt 2 }</th>
			<th></th>
		</tr>
		<tr>
			<th>비교</th>
			<th><%=5==2 %></th>
			<th>${5 eq 2 }</th>
			<th></th>
		</tr>
		<tr>
			<th>비교</th>
			<th><%=5!=2 %></th>
			<th>${5 ne 2 }</th>
			<th></th>
		</tr>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		
	</table>
</body>
</html>