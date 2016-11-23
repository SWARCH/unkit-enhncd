<%-- 
    Document   : updateVehicleS
    Created on : 19/11/2016, 11:47:36 AM
    Author     : lorenags
--%>

<%@page import="co.unkitsolutions.businesslogic.controller.VehicleController"%>
<%@page import="co.unkitsolutions.accessdata.dao.VehicleDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    VehicleDAO vehicleDAO = new VehicleDAO();
    List<Vehicle> vehicle;
    vehicle = vehicleDAO.searchAll();
    VehicleController uVehicle = new VehicleController();
    int idVehicle = (uVehicle.getIdVehicle());
    System.out.println("PARTE EN JSP: " + vehicle.get(idVehicle).getTrademark()+ "ID: " + vehicle.get(idVehicle).getId());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Actualización de vehículos</title>
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
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtProducts/updateVehicle.jsp">Volver</a></li>
                    </ul>
                </nav>
            </div>
            
            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Actualizar un vehículo</h3>
                    </div>
                    <form action="updateVehicleServlet" method="post">
                        <div class="form-group">
                            <label for="inputTradeMark">Marca</label>
                            <input class="form-control" type="text" name="tradeMark" value=<%=vehicle.get(idVehicle).getTrademark()%> >
                        </div>
                        <div class="form-group">
                            <label for="inputModel">Modelo</label>
                            <input class="form-control" type="text" name="model" value=<%=vehicle.get(idVehicle).getModel()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputDescription">Descripción</label>
                            <input class="form-control" type="text" name="description" value=<%=vehicle.get(idVehicle).getDescription()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputColor">Color</label>
                            <input class="form-control" type="text" name="color" value=<%=vehicle.get(idVehicle).getColor()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputCost">Costo</label>
                            <input class="form-control" type="text" name="cost" value=<%=vehicle.get(idVehicle).getCost()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputUnits">Unidades</label>
                            <input class="form-control" type="text" name="units" value=<%=vehicle.get(idVehicle).getUnits()%>>
                        </div>
                        <button type="submit" class="btn btn-default">Guardar</button>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

        </div>
    </body>
</html>
