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
    <title>FastLaundy/Login</title>
    <link href="estilo.css" rel="stylesheet">
</head>
<body>
<header>
    <div class="cabecera">
        <img src = "img/logo.png"> <img src="img/logo1.png">
    </div>
</header>
<div class="limpiar"></div>
<table align="center">
    <tr   bottom="middle">
        <td>
        <form method="post" action="checklogin.php" >
            <table cellpadding="3" cellspacing="3" border="0" >
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
