<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sit218 Secure Coding - First Spring-based dynamic web app</title>
</head>
<body>
<h1>${message}</h1>

<form action="${pageContext.request.contextPath}/workout" 
	method="GET">

<input type="hidden" name="user" id="user" value="${param.user}"/>

Another workout advice? 
<input type="submit" value="Yes" />
</form>


<form action="${pageContext.request.contextPath}/showLogin">

Logout? <input type="submit" value="Yes" />

</form>
		
</body>
</html>
