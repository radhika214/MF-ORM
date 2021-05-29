<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Customer Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
</head>



    
<body background="<c:url value='/resources/images/w-qjCHPZbeXCQ-unsplash.jpg' />">

<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="fname" />
		
		<br><br>
		
		Last name (*): <form:input path="lname" />
		<form:errors path="lname" cssClass="error" />
		
		<br><br>
		
		Mobile No (*):<form:input path="pno" />
		<form:errors path="pno" cssClass="error"></form:errors>
		
		<br><br>
		
		e-mail(*):<form:input path="email"/>
		<form:errors path="email" cssClass="error"></form:errors>

		
				
	<br><br>
	Gender(*):<form:input path="gender"/>
		<form:errors path="gender" cssClass="error"></form:errors>
		<br><br>
	Country:<form:select path="country" >
		<form:option value="India" label="India"/>
		<form:option value="Australia" label="Australia"/>
		
			
		</form:select>
		<br><br>

		
		
		
		Password: <form:input path="password"/>
		<form:errors path="password" cssClass="error" />
		
			<br><br>
		<input type="submit" value="Submit" />

</form:form>

</body>
</html>
