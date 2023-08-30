<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h1>Save Travels</h1>
<table>
	<tr>
		<th>Expense</th>
		<th>Vendor</th>
		<th>Amount</th>
		<th>Actions<th>
		<th></th>
	</tr>
	<tbody>
	<c:forEach var= "thisExpense" items="${allExpenses}"> <!--  for each to show each expense on the allExpenses List-->
		<tr>
			<td><a href="/expenses/${thisExpense.id}/show"><c:out value ="${thisExpense.expense}"/></a></td>
			<td><c:out value ="${thisExpense.vendor}"/></td>
			<td><c:out value ="$ ${thisExpense.amount}"/></td>
			<td><a href="/expenses/${thisExpense.id}/edit"><c:out value ="edit"/></a></td> <!-- link to route each expense to edit route  -->
			<td><form action ="/expenses/${thisExpense.id}/delete" method= "post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete"/>
				</form>
			</td> <!-- link to route each expense to delete route  -->
			
		</tr>
	</c:forEach>
	</tbody>
</table>


<!-- form to get the user data and create a newExpense -->
	<form:form modelAttribute="newExpense" method="post" action="/saveexpenses"> 
	<p>
		<form:label path="expense">Expense Name</form:label> <!-- the path is going to attach the user data to the "path value" directly by the modelAttribute (a blank sheet of paper called "newExpense-->
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