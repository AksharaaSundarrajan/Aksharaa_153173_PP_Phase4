<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Amount</title>
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
<b><font size="6">Transfer Amount</font></b>
<br>
<br>
<table>
<form:form action="fundTransferWallet" method="post" modelAttribute="customer">
<tr>
<td>
Please enter the amount you want to transfer
</td>
<td>
<form:input path="wallet.balance" name="dAmount" size="10"></form:input>
</td>
<td>
Please enter the number of the recipient
</td>
<td>
<form:input path="mobileNo" name="mNo" size="10"></form:input>
</td>
<td>
<input type="submit" name="Transfer" value="submit">
</td>
</tr>
</form:form>
</table>
</div>
<div><font color="red"><c:if test="${not empty errorMessage}" >
${errorMessage}</c:if></font></div>
</body>
</html>