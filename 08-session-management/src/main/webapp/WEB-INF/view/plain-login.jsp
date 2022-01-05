<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

<h3>My Custom Login Page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">
	
		<p>
			User name: <input type="text" name="username" />
		</p>

		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<!-- Check for login error -->
	
		<div>
		<i class="failed">${errorMessage}</i>
		</div>
			
		<input type="submit" value="Login" />
		
	</form:form>

</body>

</html>












