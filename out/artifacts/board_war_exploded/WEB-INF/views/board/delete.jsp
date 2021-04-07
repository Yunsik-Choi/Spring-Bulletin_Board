<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: choiy
  Date: 2021-04-08
  Time: 오전 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="deleteForm" action="<c:url value="/board/delete"/>" method="post">
        글 번호 : <strong>${seq}</strong><br>
        <input type="hidden" name="seq" value="${seq}">
        비밀번호 : <input type="password" name="pwd"><br>
        <input type="submit" value="삭제"><br>
        <a href="<c:url value="/board/read/${seq}"/> ">취소</a>
    </form>
    <div>${msg}</div>
</body>
</html>
