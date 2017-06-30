<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<html>
<head>
    <style type="text/css">


        ul {
            list-style-type: none;
            margin: 5px;
            padding: 5px;
            overflow: hidden;
            background-color: #333333;

        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 20px;
            text-decoration: none;
        }

        body {
            background: lightblue;
            text-align: center;
        }
    </style>
</head>
<body>
<ul>


    <!-- Based on some expressions( and authentication role ) display options in menu  -->

    <li><a href="<c:url value="../index"/> ">Home</a></li>
   <security:authorize access="isAuthenticated()">
       <li><a href="<c:url value="../showmessages"/> ">See and post messages!</a></li>
   </security:authorize>

    <security:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="<c:url value="../users"/> ">Users</a></li>
    </security:authorize>


    <security:authorize access="!isAuthenticated()">
        <li><a href="<c:url value="../register"/> ">Register here</a></li>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
    </security:authorize>


    <security:authorize access="!isAuthenticated()">
        <li><a href="<c:url value="/spring_security_login"/>">Login</a></li>
    </security:authorize>

</ul>




</body>
</html>