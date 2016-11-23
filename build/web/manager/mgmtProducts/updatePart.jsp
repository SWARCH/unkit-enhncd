<%-- 
    Document   : updatePart
    Created on : Oct 20, 2016, 9:02:29 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.PartDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PartDAO partDAO = new PartDAO();
    List<Part> allParts;

    allParts = partDAO.searchAll();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Gestión de partes</title>
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
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtProducts/addPart.jsp">Agregar parte</a></li>
                    </ul>
                </nav>
            </div>

            <div class="row"> <!--Start login form-->

                <div class="row text-center">
                    <h3>Gestionar partes</h3>
                    <p>Seleccione la parte que desee actualizar</p>
                    <table class="table table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Costo</th>
                            <th>Stock</th>
                            <th> </th>
                        </tr>
                        <%
                            int j = 0;
                            for (Part p : allParts) {
                        %>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/updatePartServlet?idPart=<%=j++%>" ><%=p.getId()%></a></td>
                            <td><%=p.getName()%></td>
                            <td><%=p.getDescription()%></td>
                            <td>$<%=p.getCost()%></td>
                            <td><%=p.getUnits()%></td>
                            <td><a href="${pageContext.request.contextPath}/addPartServlet?idPart=<%=p.getId()%>" >Eliminar</a></td>
                        </tr>

                        <%
                            }
                        %>

                    </table>
                </div>
            </div>
    </body>
</html>
