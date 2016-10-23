<%-- 
    Document   : shop
    Created on : Oct 20, 2016, 4:17:00 AM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Part"%>
<%@page import="co.unkitsolutions.accessdata.dao.PartDAO"%>
<!DOCTYPE html>
<%
    PartDAO partDao = new PartDAO();
    List<Part> partList = partDao.searchAll();
    List<Part> shoopingCart = new ArrayList<Part>();
    request.getSession().setAttribute("shopingCartItems", shoopingCart.size());
    System.out.println("--------------shop.jps : " + partList);
%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Tienda de partes</title>
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

            <h1>Tienda de partes</h1>
            <p>
                Tenemos las mejores partes de automóviles del Sistema Solar. 
                Si usted encuentra un precio más barato compre ahí.
            </p>

            <form action="shoppingServlet" method="post">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th> 
                        <th>Descripción</th>
                        <th>Costo</th>
                        <th>Stock</th>
                        <th>-_-</th>
                    </tr>

                    <%
                        for (Part p : partList) {
                    %>

                    <tr>
                        <td><%= p.getId()%></td>
                        <td><%= p.getName()%></td>
                        <td><%= p.getDescription()%></td>
                        <td><%= p.getCost()%></td>
                        <td><%= p.getUnits()%></td>
                        <td><button type="submit" class="btn btn-default">Agregar al carrito</button></td>
                    </tr>

                    <%
                        }
                    %>

                </table>
            </form>
                    Hay <%= request.getSession().getAttribute("shopingCartItems")%>
                    elementos el carrito de compras.
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <h3>Carrito de compras</h3>
            
            <%
                int i = 0;
                for (Part p : partList) {
                    
            %>
            
                <%=p.getId()%>[
                <a href="posDelPart?pos=<%i++;%>">Borrar</a>]<br>
            
            <%
                }
            %>
            
        </div>
    </body>
</html>
