<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h2>Exam Generation App</h2>

<!-- Add a link to point to exam generation -->
<p>
	<a href ="${pageContext.request.contextPath}/examgen"> Exam Generation </a>
</p>

<!-- Add a link to point to question-answer -->
<p>
	<a href ="${pageContext.request.contextPath}/question-answer"> Question and Answer </a>
</p>

<!-- Add a link to point to admin -->
<p>
	<a href ="${pageContext.request.contextPath}/admin"> Admin </a>
</p>


<!-- Add a logout form -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		<input type="submit" value="Logout"/>
		
	</form:form>	
</body>
</html>
