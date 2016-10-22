<%-- 
    Document   : indexManager
    Created on : Oct 20, 2016, 4:17:00 AM
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
        <title>Manager Home</title>
    </head>
    <body>
        <div class="container">
            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="http://placehold.it/100x100">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>UN KIT Solutions Ltda.</h1>
                    <h3>Fábrica CKD</h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->

            <!-- Generates a greeting depending on the gender. Cool! -->
            <% if (request.getSession().getAttribute("employeeGender").equals('F')) {%>
            <h1> Bienvenida <%= request.getSession().getAttribute("employeeName")%> </h1>
            <% } else {%>
            <h1> Bienvenido <%= request.getSession().getAttribute("employeeName")%> </h1>
            <% }%>

            <div class="row"> <!-- End navbar -->
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://placehold.it/262x200" alt="Image">
                        <div class="caption">
                            <h3>Gestionar empleados</h3>
                            <p>Aqui puede usted realizar cambios en la nómina de la fábrica.</p>
                            <p>
                                <a href="manager/mgmtEmployees/hireEmployee.jsp" class="btn btn-default" role="button">Contratar</a>
                                <a href="manager/mgmtEmployees/fireEmployee.jsp" class="btn btn-default" role="button">Despedir</a>
                                <a href="manager/mgmtEmployees/updateEmployee.jsp" class="btn btn-default" role="button">Actualizar</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://placehold.it/262x200" alt="Image">
                        <div class="caption">
                            <h3>Gestionar partes</h3>
                            <p>Aqui puede usted realizar la gestión de las partes.</p>
                            <p><!--a href="#" class="btn btn-primary" role="button">Button</a> -->
                                <a href="manager/mgmtProducts/addPart.jsp" class="btn btn-default" role="button">Adicionar</a>
                                <a href="manager/mgmtProducts/updatePart.jsp" class="btn btn-default" role="button">Actualizar</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://placehold.it/262x200" alt="Image">
                        <div class="caption">
                            <h3>Gestionar vehículos</h3>
                            <p>Texto</p>
                            <p><!--a href="#" class="btn btn-primary" role="button">Button</a> -->
                                <a href="manager/mgmtProducts/addVehicle.jsp" class="btn btn-default" role="button">Adicionar</a>
                                <a href="manager/mgmtProducts/updateVehicle.jsp" class="btn btn-default" role="button">Actualizar</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div> <!-- End navbar -->
            
            <form action="logout" method="POST">
                <button type="submit" class="btn btn-default">Salir</button>
            </form>
            
        </div>
    </body>
</html>
