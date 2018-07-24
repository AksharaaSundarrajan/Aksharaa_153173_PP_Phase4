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
<h2>Thank you for creating an account with us ${customer.name}!</h2><br>
<h2>Your Registered mobile number is :-${customer.mobileNo}</h2>
</div>
</body>
</html>