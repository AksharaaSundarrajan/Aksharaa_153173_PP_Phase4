<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap-3.2.0-dist/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div align="center">
<b><font size="6">Welcome to Login Page</font></b>
<table>
<form:form action="customerLogin" method="post" modelAttribute="customer">
<tr>
<td>Mobile No:</td>
<td><form:input path="mobileNo" size="11"/></td>
<td><form:errors path="mobileNo" cssClass="error"/></td>
</tr>
<tr>
<td><input type="submit" value="submit"/></td>
</tr>
</form:form>
</table>
</div>
</body>
</html>