<%-- 
    Document   : indexManager
    Created on : Oct 20, 2016, 4:17:00 AM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home</title>
    </head>
    <body>
        <h1> Bienvenido <%= request.getSession().getAttribute("employee-name") %> </h1>
        
    </body>
</html>
