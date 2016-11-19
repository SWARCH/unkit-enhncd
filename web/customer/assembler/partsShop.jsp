<%-- 
    Document   : partsShop
    Created on : Oct 22, 2016, 9:49:57 PM
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
        <script src="shop_script.js"></script>
        
        <title>Tienda de partes</title>
    </head>
    <body>
        <div class="container">

            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="../../images/unkit-logo.jpg">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>UN KIT Solutions Ltda.</h1>
                    <h3>Fábrica CKD</h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->

            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Tienda de ensambladores</h3>
                    </div>



                    <table class="table" style="border:1px solid black;">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Costo</th>
                            <th>Stock</th>
                            <th>Cantidad</th>
                            <th>*</th>
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
                            <td><form action="/partShop.jsp" method ="post">
                                    <input class="form-control" type="number" name="quantity">
                                    <a href="${pageContext.request.contextPath}/posAddPart?index=<%=j++%>&quantity=<%=q%>">Agregar</a>
                                </form>
                            </td>
                            <td>
                                
                            </td>
                        </tr>

                        <%
                            }
                        %>

                    </table>

                    <h1>Carrito de compras</h1>

                    <table class="table" style="border:1px solid black;">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Costo</th>
                            <th>Cantidad pedida</th>
                            <th>*</th>
                        </tr>
                        <%  if (partsToBuy != null && partsToBuy.size() != 0) {
                                int k = 0;
                                for (int i = 0; i < partsToBuy.size(); i++) {
                        %>
                        <tr>
                            <td><%= partsToBuy.get(i).getId()%></td>
                            <td><%= partsToBuy.get(i).getName()%></td>
                            <td><%= partsToBuy.get(i).getDescription()%></td>
                            <td>$<%= partsToBuy.get(i).getCost()%></td>
                            <td><%= q%></td> <!-- put the quantity -->
                            <td><a href="posDelPart?pos=<%=k++%>">Borrar</a></td>
                        </tr>

                        <%
                                }
                            }
                        %>

                    </table>
                </div>
            </div>
    </body>
</html>