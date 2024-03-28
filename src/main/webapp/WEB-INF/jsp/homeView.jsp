<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="create-account" method="post" modelAttribute="employee">
<input type="text" name="name" /><br/>
<input type="text" name="email" /><br/>
<input type="password" name="password"/><br/>
<input type="submit" value="register"/>
</form:form>
</body>
</html>