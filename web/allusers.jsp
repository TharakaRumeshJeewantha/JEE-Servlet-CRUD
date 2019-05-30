<%-- 
    Document   : allusers
    Created on : May 28, 2019, 1:26:16 PM
    Author     : TRJ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
    </head>
    <body>
        <table border="1">
            <td><a href="userinfo.jsp">User Info</a></td>
            <td><a href="allusers.jsp">All Users</a></td>
        </table>
        <br />
        <h3>List of Users</h3>
        <br />
        <table border="1">
            <th>User ID</th>
            <th>User Name</th>
            <th>Address</th>
            <c:forEach items="${requestScope.list}" var="user">
            <tr>
                <td><a href="./GetUser?id=${user.userID}">${user.userID}</a></td>
                <td>${user.name}</td>
                <td>${user.address}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
