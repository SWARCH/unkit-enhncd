<%-- 
    Document   : buyVehicle
    Created on : Nov 22, 2016, 10:08:40 PM
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
    System.out.print("vehiclesShop.vehiclesToBuy " + vehiclesToBuy);
    System.out.print("vehiclesShop.allVehicles " + allVehicles);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Tienda de vehículos</title>
    </head>
    <body>
        <div class="container"> <!--start container-->

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
                        <li><a href="${pageContext.request.contextPath}/wholesaler/indexWholesaler.jsp">Retroceder</a></li>
                    </ul>
                </nav>
            </div>
            
            <br>

            <div class="row"> <!-- Start View Table -->
                <h3>Lista de vehiclees</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Marca</th>
                        <th>Descripción</th>
                        <th>Modelo</th>
                        <th>Color</th>
                        <th>Costo</th>
                    </tr>
                    <%
                        int j = 0;
                        int q = 0;
                        for (Vehicle v : allVehicles) {

                    %>
                    <tr>
                        <td><%=v.getId()%></td>
                        <td><%=v.getTrademark()%></td>
                        <td><%=v.getDescription()%></td>
                        <td><%=v.getModel()%></td>
                        <td><%=v.getColor()%></td>
                        <td>$<%=v.getCost()%></td>
                        <td><%=v.getUnits()%></td>
                    </tr>

                    <%
                        }
                    %>
                </table>
            </div> <!-- End View Table -->
            
            <br>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <br>

            <div class="row"> <!-- Start Buying Form -->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Comprar autómovil</h3>
                    </div>
                    <form action="<%=request.getContextPath()%>/buyVehicleServlet" method="post">
                        <div class="form-group">
                            <label for="inputPartId">ID del automóvil</label>
                            <input class="form-control" type="text" name="vehicleId">
                        </div>
                        <div class="form-group">
                            <label for="inputQuantity">Cantidad</label>
                            <input class="form-control" type="number" name="vehicleQuant">
                        </div>
                        <button type="submit" class="btn btn-default">Comprar</button>
                        <br><br>
                        <span class="message">${message}</span>
                    </form>
                </div>
            </div> <!-- End Buying Form -->

            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="./index.jsp">Back to top</a></p>
                <p>&copy; 2016 Unkit Solutions Ltda.  &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script src="bootstrap/js/bootstrap.min.js"></script>
        </div> <!-- end container -->
    </body>
</html>
