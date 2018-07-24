<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
table,td,th
{
border-width:thin;
border-style:solid;
}
</style>
</head>
<body>
<div align="center">
<h2>Welcome ${customer.name}</h2><br>
<h2>Your Registered mobile number is :-${customer.mobileNo}</h2>
<div align="center">
<br><br>
<table style="border-color:black">
<tbody>
<tr>
<td>
<b>Pick your operation</b>
</td>
</tr>
<tr>
<td>
<a href="withdrawAmount"> Withdraw amount</a>
</td>
</tr>

<tr>
<td>
<a href="depositAmount"> Deposit Amount</a>
</td>
</tr>

<tr>
<td>
<a href="fundTransfer"> Fund Transfer</a>
</td>
</tr>

<tr>
<td>
<a href="showBalance"> See your balance</a>
</td>
</tr>

<tr>
<td>
<a href="retrieveAllTransactions">See your Transactions</a>
</td>
</tr>

<tr>
<td>
<a href="retrieveAllCustomers">All customer details</a>
</td>
</tr>

<tr>
<td>
<a href="retrieveAllWithMinBalance">Customers having balance less than minimum balance</a>
</td>
</tr>
</tbody>
</table>
</div>

</div>
</body>
</html>