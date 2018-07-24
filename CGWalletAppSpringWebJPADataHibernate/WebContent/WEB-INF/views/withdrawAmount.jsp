<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Amount</title>
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
</head>
<body>
<div align="center">
<b><font size="6">Withdraw Operation</font></b>
<br>
<br>
<table>
<form:form action="withdrawWallet" method="post" modelAttribute="customer">
<tr>
<td>
Please enter the amount you want to withdraw
</td>
<td>
<form:input path="wallet.balance" size="10"></form:input>
</td>
<td>
<input type="submit" name="Withdraw" value="submit">
</td>
</tr>
</form:form>
</table>
</div>
<div><font color="red"><c:if test="${not empty errorMessage}" >
${errorMessage}</c:if></font></div>
</body>
</html>