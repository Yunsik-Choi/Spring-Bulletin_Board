<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: choiy
  Date: 2021-04-07
  Time: 오후 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>제목</th>
            <th>${boardVO.title}</th>
        </tr>
        <tr>
            <td>내용</td>
            <td>${boardVO.content}</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>${boardVO.writer}</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>${boardVO.regDate}</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>${boardVO.cnt}</td>
        </tr>
    </table>
    <div>
        <a href="<c:url value="/board/edit"/>">수정</a>
        <a href="<c:url value="/board/delete"/>">삭제</a>
        <a href="<c:url value="/board/list"/>">목록</a>
    </div>
</body>
</html>
