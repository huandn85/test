<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>index</title>

</head>
<body>
	<form:form id="formUploadFile" method="POST" action="uploadFile" enctype="multipart/form-data" modelAttribute="myFile">
		File: <input type="file" name="multipartFile" /> <br /> <br/>
		Name: <input type="text" name="name">
		<input type="submit" value="Submit" />
	</form:form>
	
</body>

</html>