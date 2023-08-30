<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go back</a>
</div>
	
	<form:form modelAttribute="thisExpense" method="put" action="/expenses/${thisExpense.id}/update">
	<p>
		<form:label path="expense">Expense Name</form:label>
		<form:errors path="expense"/>
		<form:input path="expense"/>
	</p>
	<p>
		<form:label path="vendor">Vendor</form:label>
		<form:errors path="vendor"/>
		<form:input path="vendor"/>
	</p>
	<p>
		<form:label path="amount">Amount</form:label>
		<form:errors path="amount"/>
		<form:input path="amount"/>
	</p>	
	<p>
		<form:label path="description">Description</form:label>
		<form:errors path="description"/>
		<form:textarea path="description" rows="3" cols ="15"/>
	</p>
	<input type="submit" value= "Submit"/>
</form:form>

</body>
</html>