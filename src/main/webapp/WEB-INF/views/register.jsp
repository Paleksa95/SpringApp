<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>

    body {
        background: lightblue;
    }

    form {
        text-align: center;
    }

    h1 {
        text-align: center;
        color: brown;
    }


</style>

<head>
    <title>Register</title>
</head>
<body>

<!-- Header -->
<c:import url="templates/header.jsp"/>



<!-- Show if registrations is success -->
<c:if test="${param.success eq true}">

    <h1>REGISTRATION SUCCESS!</h1>

</c:if>


<h1>Registration form:</h1>
<form:form commandName="user">
    <!-- Display errors -->
  <h1> <form:errors path="name"/>  </h1>
    <h2>Enter name:</h2><form:input path="name"/>
    <!-- Display errors -->
    <h1> <form:errors path="email"/> </h1>
    <h2>Enter email:</h2> <form:input path="email"/>
    <!-- Display errors -->
  <h1>  <form:errors path="password"/> </h1>
    <h2>Enter password:</h2>  <form:password path="password"/>
    <input type="submit" value="submit">
</form:form>

<!-- Footer -->
<c:import url="templates/footer.jsp"/>


</body>
</html>
