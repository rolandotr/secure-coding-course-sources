<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Client Registration Form</title>

	<!--  Inline CCS -->
	<style>
		.error {color:red}
	</style>

</head>
<body>

	<form:form action="${pageContext.request.contextPath}/workout/processForm" 
		modelAttribute="client" >
		Name: <form:input path="name" />
		<form:errors path="name" cssClass="error" />
		
		<br><br>
		
		Age: <form:input path="age" />
		<form:errors path="age" cssClass="error" />
		
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>
