<%-- 
    Document   : indexWholesaler
    Created on : Oct 20, 2016, 5:21:17 AM
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
        <title>Mayorista</title>
    </head>
    <body>
        <div class="container">
            
            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="${pageContext.request.contextPath}/images/unkit-logo.jpg">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>UN KIT Solutions Ltda.</h1>
                    <h3>Fábrica CKD</h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->
            
            <!-- Navigation menu -->
            <div class="masthead">
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="LogoutServlet">Salir</a></li>
                    </ul>
                </nav>
            </div>
            
            <br>

            <h1> Bienvenidos <%= request.getSession().getAttribute("customerName")%> </h1>
            <div class="row">
                <a class="btn btn-default" href="customer/wholesaler/buyVehicle.jsp" role="button">Ir a la tienda de carros</a>
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" value="Logout" />
                </form>
            </div>
        </div>

    </body>
</html>

