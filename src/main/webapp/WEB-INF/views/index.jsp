<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<style>

    h1{
        color: brown;
    }
</style>


<html>
<head>
    <title>Welcome</title>
</head>
<body>

<!-- Header -->
<c:import url="templates/header.jsp"/>


<!-- If User with Admin role delete some user successfully -->
<c:if test="${param.success eq true}">

    <h1>User deleted successfully!</h1>

</c:if>







<h1> Welcome !</h1>

<!-- Footer -->
<c:import url="templates/footer.jsp"/>
</body>
</html>