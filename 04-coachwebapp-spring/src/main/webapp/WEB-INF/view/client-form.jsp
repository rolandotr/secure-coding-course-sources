<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Client Registration Form</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/workout/processForm" 
		modelAttribute="client" >
		Name: <form:input path="name" />
		
		<br><br>
		
		Age: <form:input path="age" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>
