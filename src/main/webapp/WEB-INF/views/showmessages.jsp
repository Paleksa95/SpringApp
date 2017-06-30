<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>


    body {
        text-align: center;
    }

    h1 {
        color: brown;
    }

    h2{
        color: red;
    }
</style>


<head>
    <title>Messages</title>
</head>
<body>


<!-- Header -->
<c:import url="templates/header.jsp"/>


<!-- Add form to submit messages here -->

<h1>Submit message:</h1>

<form:form commandName="Messages">
    <!-- Display errors -->
  <h1><form:errors path="title"/></h1>
    <h2>Enter title:</h2>   <form:input path="title"/>
    <!-- Display errors -->
    <h1> <form:errors path="title"/></h1>
    <h2>Enter description:</h2>   <form:input path="description"/>

    <input type="submit" value="submit">

</form:form>


<c:forEach items="${messages}" var="message">
    <hr>
    <hr>
    <h2>Message Title:<c:out value="${message.title}"/></h2>

    <h2>Message Body:<c:out value="${message.description}"/></h2>

    <hr>
    <hr>

</c:forEach>

<!-- Footer -->
<c:import url="templates/footer.jsp"/>


</body>
</html>
