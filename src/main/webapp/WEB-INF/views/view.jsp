<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
 
    <h3>파일 다운로드</h3>
    <c:forEach var="file" items="${all}">
        ${file.savedNm}
        <img src="/img/${file.savedNm}" width="150" height="150" />
        <a href="/attach/${file.id}">${file.orgNm}</a> <br>
    </c:forEach>
    <!--
    <div th:each="file : ${all}">
        <a th:href="|/attach/${file.id}|" th:text="${file.orgNm}"></a>
    </div>
    -->
</body>
</html>