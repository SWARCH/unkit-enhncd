<%-- 
    Document   : vehiclesShop
    Created on : Oct 23, 2016, 7:52:18 PM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.VehicleDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    VehicleDAO vehicleDAO = new VehicleDAO();
    List<Vehicle> vehiclesToBuy;
    List<Vehicle> allVehicles;

    vehiclesToBuy = (ArrayList) request.getSession().getAttribute("vehiclesToBuy");
    allVehicles = vehicleDAO.searchAll();
    System.out.print("partsShop.vehiclesToBuy " + vehiclesToBuy);
    System.out.print("partsShop.allVehicles " + allVehicles);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Tienda de vehículos</title>
    </head>
    <body>
        
        <div class="container">    <head>
            <h1>Tienda de vehículos</h1>
            
        </div>
        
    </body>
</html>
