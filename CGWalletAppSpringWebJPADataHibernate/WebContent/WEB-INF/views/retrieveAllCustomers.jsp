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

<h1>Registered Customers are:</h1>
<table>
<tr>
<th>Customer name</th>
<th>Mobile number</th>
<th>Balance</th>
</tr>
<c:forEach items="${customer}" var="cust">
<tr>
<td>${cust.name}</td>
<td>${cust.mobileNo}</td>
<td>${cust.wallet.balance}</td>
</tr>
</c:forEach>
</table>
</body>
</html>