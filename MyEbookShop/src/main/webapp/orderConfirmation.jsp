<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>

<form action="https://uat.esewa.com.np/epay/main" method="get">
    <input type="hidden" name="scd" value="YOUR_MERCHANT_ID">
    <input type="hidden" name="su" value="http://yourdomain.com/PaymentHandler">
    <input type="hidden" name="fu" value="http://yourdomain.com/PaymentHandler">
    <input type="hidden" name="amount" value="100">
    <input type="hidden" name="payment_status" value="PENDING">
    <input type="submit" value="Pay with eSewa">
</form>


</body>
</html>