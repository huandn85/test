
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>index</title>
</head>
<body>
	<h1>${message}</h1>
	<br/>
	description: ${description}
	<img src="<c:url value="/resources/image/${UpFile.imageUrl}" />"  width="500" height="600">
</body>
</html>
${MyFile.imageUrl}