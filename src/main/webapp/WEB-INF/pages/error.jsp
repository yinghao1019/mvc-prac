<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>抱歉，系統發生錯誤</h1>
<p>錯誤訊息：<strong><%= exception.getMessage() %>
</strong></p>
<hr>
</body>
</html>
