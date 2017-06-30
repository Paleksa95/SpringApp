<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>

        body{
            color: lightblue;
        }

        h1{
            color: darkmagenta;
        }

    </style>


    <title>User details</title>
</head>


<!-- Header -->
<c:import url="templates/header.jsp"/>
<body>



<!-- User info -->
<h1> User Details:</h1>

     <h1> Name : <c:out value="${user.name}"/></h1>
<hr>
        <h1>Email :<c:out value="${user.email}"/></h1>



</body>
</html>
