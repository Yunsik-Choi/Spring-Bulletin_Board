<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: choiy
  Date: 2021-04-07
  Time: 오후 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="post">
    <table border="1">
        <tr>
            <th><form:label path="title">제목</form:label></th>
            <td><form:input path="title"/><form:errors path="title"/> </td>
        </tr>
        <tr>
            <th><form:label path="content">내용</form:label></th>
            <td><form:input path="content"/><form:errors path="content"/> </td>
        </tr>
        <tr>
            <th><form:label path="writer">작성자</form:label></th>
            <td><form:input path="writer"/><form:errors path="writer"/> </td>
        </tr>
        <tr>
            <th><label for="pwd">비밀번호 확인</label></th>
            <td><input type="password" id="pwd" name="pwd">${msg}</td>
        </tr>
    </table>
    <div>
        <input type="submit" value="수정">
        <a href="<c:url value="/board/list"/>">목록</a>
    </div>
</form:form>
</body>
</html>
