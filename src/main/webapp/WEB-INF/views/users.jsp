<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        body {
            text-align: center;
        }
    </style>

    <title>User list</title>
</head>
<body>

<!-- Header -->
<c:import url="templates/header.jsp"/>




<!-- Looping and getting list of all users.  -->
<c:forEach items="${users}" var="user">


    <hr>
    <hr>
    User name :<a href="<spring:url value="users/${user.id}"/> " >
    <c:out value="${user.name}"/>
    </a>

    <h2>User email:<c:out value="${user.email}"/></h2>

    <a href="<c:url value="/users/delete/${user.id}" />"> Delete user</a>


    <hr>
    <hr>


</c:forEach>


<!-- Footer -->
<c:import url="templates/footer.jsp"/>

</body>
</html>
