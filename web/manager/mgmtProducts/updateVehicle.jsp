<%-- 
    Document   : updateVehicle
    Created on : Oct 20, 2016, 9:03:06 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.VehicleDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    VehicleDAO vehicleDAO = new VehicleDAO();
    List<Vehicle> allVehicles;

    allVehicles = vehicleDAO.searchAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Gestión de vehículos</title>
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
                        <li class="active"><a href="../indexManager.jsp">Inicio</a></li>
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtProducts/addVehicle.jsp">Agregar vehículo</a></li>
                    </ul>
                </nav>
            </div>

            <div class="row"> <!--Start login form-->
                    <div class="row text-center">
                        <h3>Gestionar vehículos</h3>
                        <p>Seleccione el vehículo que desea actualizar</p>
                        
                    <table class="table table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Descripción</th>
                            <th>Color</th>
                            <th>Costo</th>
                            <th>Stock</th>
                            <th> </th>
                        </tr>
                        <%
                            int j = 0;
                            for (Vehicle v : allVehicles) {
                        %>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/updateVehicleServlet?idVehicle=<%=j++%>" ><%=v.getId()%></a></td>
                            <td><%=v.getTrademark()%></td>
                            <td><%=v.getModel()%></td>
                            <td><%=v.getDescription()%></td>
                            <td><%=v.getColor()%></td>
                            <td>$<%=v.getCost()%></td>
                            <td><%=v.getUnits()%></td>
                            <td><a href="${pageContext.request.contextPath}/addVehicleServlet?idVehicle=<%=v.getId()%>" >Eliminar</a></td>
                        </tr>

                        <%
                            }
                        %>

                    </table>
                </div>
            </div>
    </body>
</html>

