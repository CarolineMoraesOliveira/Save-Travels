<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div>
	<h1>Showing Expense</h1>
	<a href="/expenses">Go back</a>
</div>

<h3>Name: <c:out value="${thisExpense.expense}"></c:out></h3><br>
<h3>Vendor: <c:out value="${thisExpense.vendor}"></c:out></h3><br>
<h3>Amount: <c:out value="${thisExpense.amount}"></c:out></h3><br>
<h3>Description: <c:out value="${thisExpense.description}"></c:out></h3><br>

</body>
</html>