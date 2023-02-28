<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-List Coffee Shop</title>
</head>
<body>
<form method = "post" action="navigationServlet">
<table>
<c:forEach items = "${requestScope.allCustomers}" var = "currentitem">
<tr>
<td><input type = "radio" name="id" value="${currentcustomer.id}"> </td>
<td>${currencustomer.fName}</td>
<td>${currentcustomer.lName}</td>
<td>${currentcustomer.phoneNumber}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToCustomer">
<input type ="submit" value = "delete" name="doThisToCustomer">
<input type ="submit" value = "add" name="doThisToCustomer">
</form>
</body>
</html>