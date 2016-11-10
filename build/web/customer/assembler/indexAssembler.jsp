<%-- 
    Document   : indexAssembler
    Created on : Oct 20, 2016, 5:20:47 AM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="images/unkit-logo.jpg">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>UN KIT Solutions Ltda.</h1>
                    <h3>Fábrica CKD</h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->

            <h1> Bienvenidos <%= request.getSession().getAttribute("customerName")%> </h1>
            <div class="row">
                <a class="btn btn-default" href="customer/assembler/partsShop.jsp" role="button">Tienda</a>
                <a class="btn btn-default" href="/showParts" role="button">Invocar Servlet</a>
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" value="Logout" />
                </form>
            </div>
        </div>

    </body>
</html>
