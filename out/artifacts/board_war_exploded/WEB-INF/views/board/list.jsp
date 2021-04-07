<%--
  Created by IntelliJ IDEA.
  User: choiy
  Date: 2021-04-07
  Time: 오후 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>NO</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
        </tr>
        <c:forEach var="board" items="${boardList}" varStatus="loop">
            <tr>
                <td>${board.seq}</td>
                <td><a href="<c:url value="/board/read/${board.seq}" />">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.regDate}</td>
                <td>${board.cnt}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/board/write"/>">새글</a>
</body>
</html>
