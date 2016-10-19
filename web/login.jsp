<%-- 
    Document   : login
    Created on : Oct 18, 2016, 11:43:13 PM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="loginServlet">
            Nombre de usuario: <input type="text" name="usr"><br>
            Contraseña: <input type="password" name="pwd"><br>
            <input type="submit" value="Ingresar" />
        </form>
    </body>
</html>
