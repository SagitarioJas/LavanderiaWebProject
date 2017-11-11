<%--
  Created by IntelliJ IDEA.
  User: Sergio.Aguirre
  Date: 11/11/2017
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table  align="center"  height=100% widht=100%>
    <tr align="center"  bottom="middle">
        <td>
        <form method="post" action="checklogin.php" >
            <table cellpadding="0" cellspacing="0" border="0" align="center">
                <tr>
                    <td><input type="text" placeholder="Usuario" name="username" id="username" /></td>
                </tr>
                <tr>
                    <td><input type="password" placeholder="Contrasena" name="password" id="password" /></td>
                </tr>
                <tr>
                    <td><button id="login_userbttn">Login</button></td>
                </tr>
            </table>
        </form>
        </td>
    </tr>
</table>

</body>
</html>
