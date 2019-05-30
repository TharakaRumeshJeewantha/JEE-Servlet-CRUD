<%-- 
    Document   : index
    Created on : May 28, 2019, 12:53:58 PM
    Author     : TRJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>
    <body>
        <table border="1">
            <td><a href="userinfo.jsp">User Info</a></td>
            <td><a href="./AllUsers">All Users</a></td>
        </table>
        
        <br />
        
        <form action="./UserServlet" method="POST">
            <table>
                <tr>
                    <td>User ID : </td>
                    <td><input type="text" name="id" value="${user.userID}"/></td>
                </tr>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" name="name" value="${user.name}"/></td>
                </tr>
                <tr>
                    <td>Address : </td>
                    <td><input type="text" name="address" value="${user.address}"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="Submit" name="operation" value="Add"/>
                        <input type="Submit" name="operation" value="Edit"/>
                        <input type="Submit" name="operation" value="Delete"/>
                        <input type="Submit" name="operation" value="Search"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
