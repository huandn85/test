<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/13/22
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.2.2/css/bootstrap.min.css" />

</head>
<body style="display: flex;justify-content: center;align-items: center;background-color: cadetblue;">
<div  class="container" style="background-color: white;height:400px;width: 400px;box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);text-align: center;padding-top: 50px; ">
    <h1 style="border-bottom: 1.5px solid #ced4da;font-size: 25px;">ADD STUDENT</h1>
<form:form modelAttribute="student" action="addStudent" method="post" class="input-group " style="width: 360px;margin:0 auto;">
    <div class="input-group input-group-lg">
    <table  style="width: 100%">

    <tr>
        <td style="padding:5px 0;">Name</td></tr>
        <td><form:input class="form-control" tyle="text" path="name"/> </td>

    <tr >
        <td style="padding:5px 0;">AVG MARK</td></tr>
        <td ><form:input class="form-control"  tyle="text" path="avgmark"/> </td>

    <tr >
        <td style="padding:5px 0;">LEVEL</td></tr>
        <td><form:input class="form-control" tyle="text" path="level"/></td>

    <tr>
        <td colspan="2" style="padding:5px 0;">
            <button type="submit" class="btn btn-primary" style="width: 360px; margin-top: 10px;">Submit</button>
        </td>
    </tr>

</table>
    </div>
</form:form>
</div>
</body>
</html>
