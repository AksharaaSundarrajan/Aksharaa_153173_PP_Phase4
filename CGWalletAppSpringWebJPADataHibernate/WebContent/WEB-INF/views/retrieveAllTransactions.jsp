<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table,td,th
{
border-width:thin;
border-style:solid;
}
.error{
color:red;
font-weight: bold;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Previous Transactions</title>
</head>
<body>

<h1>Transactions performed by this number are:</h1>
<table>
<tr>
<th>Mobile Number</th>
<th>Transaction Type</th>
<th>Amount</th>
<th>Transaction Date</th>
<th>Transaction Status</th>
</tr>
<c:forEach items="${transactions}" var="trans">
<tr>
<td>${trans.mobileNumber}</td>
<td>${trans.transactionType}</td>
<td>${trans.amount}</td>
<td>${trans.dateOfTransaction}</td>
<td>${trans.transactionStatus}</td>
</tr>
</c:forEach>
</table>
</body>
</html>