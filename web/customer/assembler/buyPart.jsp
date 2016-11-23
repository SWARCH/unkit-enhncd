<%--
    Document   : buyPart
    Created on : Nov 21, 2016, 7:32:56 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.PartDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PartDAO partDAO = new PartDAO();
    List<Part> partsToBuy;
    List<Part> allParts;

    partsToBuy = (ArrayList) request.getSession().getAttribute("partsToBuy");
    allParts = partDAO.searchAll();
    System.out.print("partsShop.partsToBuy " + partsToBuy);
    System.out.print("partsShop.allParts " + allParts);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Tienda de partes</title>
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

            <div class="row"> <!-- Start View Table -->
                <h3>Lista de partes</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Costo</th>
                        <th>Stock</th>
                    </tr>
                    <%
                        int j = 0;
                        int q = 0;
                        for (Part p : allParts) {

                    %>
                    <tr>
                        <td><%=p.getId()%></td>
                        <td><%=p.getName()%></td>
                        <td><%=p.getDescription()%></td>
                        <td>$<%=p.getCost()%></td>
                        <td><%=p.getUnits()%></td>
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
                        <h3>Comprar parte</h3>
                    </div>
                    <form action="<%=request.getContextPath()%>/buyPartServlet" method="post">
                        <div class="form-group">
                            <label for="inputPartId">ID de la parte</label>
                            <input class="form-control" type="text" name="partId">
                        </div>
                        <div class="form-group">
                            <label for="inputQuantity">Cantidad</label>
                            <input class="form-control" type="number" name="partQuant">
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
