<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:out value="${param.get('test')}" default="testDefault"/>
</p>

<c:set var="file" value="upload.jpg"/>
<c:if test="${fn:endsWith(file, '.jpg') }">
    <p>this is a picture</p>
</c:if>
</body>
</html>
