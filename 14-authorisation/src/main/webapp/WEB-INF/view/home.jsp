<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>Exam Generation App</h2>

<!-- Add a logout form -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout"/>
		
	</form:form>	
</body>
</html>
