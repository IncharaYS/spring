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
<form action="searchById" >
    Search by medicine id:<br>
    <input type="number" name="id"><br>
    <input type="submit" value="Submit">

</form>

<c:if test="${medicineDto!=null}">
    <p>Medicine Name : ${ medicineDto.medicineName }</p>
    <p>Medicine Id : ${ medicineDto.id }</p>
    <p>Price : ${medicineDto.price}</p>
    <p>Mg : ${medicineDto.mg}</p>
    <p>Combination Name : ${medicineDto.combination}</p>
    <p>Expiry Date : ${medicineDto.expDate}</p>
</c:if>

<h5 style="color:red;">${DataNotFound}</h5>

</body>
</html>