<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/11/22
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mcv" uri="http://www.springframework.org/tags/form" %>
<html class="p-3 mb-2 bg-light text-dark">
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.2/css/bootstrap.min.css" />
</head>
<body class="p-3 mb-2 bg-light text-dark">

<h1>View List</h1>

    <table class="table table-success table-striped" >
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>AVG</td>
            <td>Level</td>
            <td><a href="requestAddStudent" target="_blank"><button class="btn btn-primary" style="background-color:white; border:none;color: brown" type="button">Add Student</button></a></td>
        </tr>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.avgmark}</td>
                <td>${s.level}</td>
                <td><a href="delete?id=${s.id}" target="_blank"><button class="btn btn-primary" style="background-color:red;border:none;" type="button">Delete</button></a>
                <a href="requestId?id=${s.id}"><button class="btn btn-primary" style="border:none;" type="button">Update</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
