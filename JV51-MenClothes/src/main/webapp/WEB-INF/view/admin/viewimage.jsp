<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02/23/23
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="f" items="${files}">
    <div>
        <label>${f.name}</label>
        <img height="100px" width="300px" src="${f.url}"/>
    </div>
</c:forEach>
</body>
</html>
