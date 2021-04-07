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
            <th>${boardVo.title}</th>
        </tr>
        <tr>
            <td>내용</td>
            <td>${boardVo.content}</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>${boardVo.writer}</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>${boardVo.regDate}</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>${boardVo.cnt}</td>
        </tr>
    </table>
    <div>
        <a href="<c:url value="/board/edit/${boardVo.seq}"/>">수정</a>
        <a href="<c:url value="/board/list"/>">목록</a>
    </div>
</body>
</html>
