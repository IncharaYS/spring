<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <title>Search page</title>
</head>
<body>

<h5>Search Page</h5>
<form action="search" >
    Search by medicine name:<br>
    <input type="text" name="medicineName"><br>
    <input type="submit" value="Submit">


</form>

<c:if test="${medicine!=null}">
    <p>Medicine Name : ${ medicine.medicineName }</p>
    <p>Price : ${medicine.price}</p>
    <p>Mg : ${medicine.mg}</p>
    <p>Combination Name : ${medicine.combination}</p>
    <p>Expiry Date : ${medicine.expDate}</p>
</c:if>

<h5 style="color:red;">${DataNotFound}</h5>

</body>
</html>