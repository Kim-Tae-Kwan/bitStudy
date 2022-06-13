<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link type="text/css" rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	<script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		location.replace('./emp/')
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
