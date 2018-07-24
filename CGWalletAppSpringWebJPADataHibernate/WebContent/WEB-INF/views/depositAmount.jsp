<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit Amount</title>
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
<b><font size="6">Deposit Operation</font></b>
<br>
<br>
<table>
<form:form action="depositWallet" method="post" modelAttribute="customer">
<tr>
<td>
Please enter the amount you want to deposit
</td>
<td>
<form:input path="wallet.balance" size="10"></form:input>
</td>
<td>
<input type="submit" name="Deposit" value="submit">
</td>
</tr>
</form:form>
</table>
</div>
</body>
</html>