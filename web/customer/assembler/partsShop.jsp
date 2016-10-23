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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda de partes</title>
    </head>
    <body>
        <h1>Tienda de partes</h1>

        <table class="table" style="border:1px solid black;">
            <tr>
                <th>Id</th>
                <th>Nombre</th> 
                <th>Descripción</th>
                <th>Costo</th>
                <th>Stock</th>
                <th>*</th>
            </tr>

            <%
                System.out.print("First OK");
                int j = 0;
                for (Part p : allParts) {
            %>

            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
                <td><%=p.getDescription()%></td>
                <td>$<%=p.getCost()%></td>
                <td><%=p.getUnits()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/posAddPart?index=<%=j++%>">Agregar</a>
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
                <th>Stock</th>
                <th>*</th>
            </tr>

            <%  if (partsToBuy != null && partsToBuy.size() != 0) {
                    int k = 0;
                    for (int i = 0; i < partsToBuy.size(); i++) {
                        System.out.print("inside for");
            %>

            <tr>
                <td><%= partsToBuy.get(i).getId()%></td>
                <td><%= partsToBuy.get(i).getName()%></td>
                <td><%= partsToBuy.get(i).getDescription()%></td>
                <td><%= partsToBuy.get(i).getCost()%></td>
                <td><%= partsToBuy.get(i).getUnits()%></td>
                <td><a href="posDelPart?pos=<%=k++%>">Borrar</a></td>
            </tr>

            <%
                    }
                }
            %>

        </table>
    </body>
</html>