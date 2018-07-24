<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error{
color:red;
font-weight: bold;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap-3.2.0-dist/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div align="center">
<b><font size="6">Welcome to Registration Page</font></b>
</div>
<table>
<form:form action="registerCustomer" method="post" modelAttribute="customer">
<tr>
<td>Name:</td>
<td><form:input path="name" size="30"/></td>
<td><form:errors path="name" cssClass="error"/></td>
</tr>

<tr>
<td>Mobile No:</td>
<td><form:input path="mobileNo" size="11"/></td>
<td><form:errors path="mobileNo" cssClass="error"/></td>
</tr>

<tr>
<td>Initial Balance:</td>
<td><form:input path="wallet.balance" size="20"/></td>
<td><form:errors path="wallet.balance" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" value="submit"/></td>
</tr>

</form:form>
</table>
</body>
</html>