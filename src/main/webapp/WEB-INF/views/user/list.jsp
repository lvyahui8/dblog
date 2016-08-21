<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>用户名</th>
            <th>头像</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.avatar}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.type}</td>
                <td><a href="${pageContext.servletContext.contextPath}/user/view?id=${user.id}">查看</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
</html>
