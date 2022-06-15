<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:forEach items="${list }" var="bean">
<a href="${bean.empno }">${bean }</a><br>
</c:forEach>
<a href="${bean.empno }">${bean }</a>
</body>
</html>
