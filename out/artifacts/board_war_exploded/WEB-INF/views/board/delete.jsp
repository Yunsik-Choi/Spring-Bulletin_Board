<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form modelAttribute="boardVO" method="post">
        글 번호 : <strong>${boardVO.seq}</strong><br>
        <input type="hidden" name="seq" value="${boardVO.seq}">
        비밀번호 : <input type="password" name="pwd"><br>
        <input type="submit" value="삭제"><br>
        <a href="<c:url value="/board/read/${seq}"/> ">취소</a>
    </form:form>
    <div>${msg}</div>
</body>
</html>
