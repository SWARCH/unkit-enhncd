<%-- 
    Document   : addPart
    Created on : Oct 20, 2016, 9:02:11 AM
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
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Creación de partes</title>
    </head>
    <body>
        <div class="container">

            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="<%=request.getContextPath()%>/images/unkit-logo.jpg">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>UN KIT Solutions Ltda.</h1>
                    <h3>Fábrica CKD</h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->

            <div class="masthead">
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="<%=request.getContextPath()%>/manager/indexManager.jsp">Inicio</a></li>
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtProducts/updatePart.jsp">Volver</a></li>
                    </ul>
                </nav>
            </div>

            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Agregar una parte</h3>
                    </div>
                    <form action="../../addPartServlet" method="post">
                        <div class="form-group">
                            <label for="inputName">Nombre</label>
                            <input class="form-control" type="text" name="name">
                        </div>
                        <div class="form-group">
                            <label for="inputDescription">Descripción</label>
                            <input class="form-control" type="text" name="description">
                        </div>
                        <div class="form-group">
                            <label for="inputCost">Costo</label>
                            <input class="form-control" type="text" name="cost">
                        </div>
                        <div class="form-group">
                            <label for="inputUnits">Unidades</label>
                            <input class="form-control" type="text" name="units">
                        </div>
                        <button type="submit" class="btn btn-default">Agregar</button>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

        </div>
    </body>
</html>

