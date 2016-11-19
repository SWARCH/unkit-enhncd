<%-- 
    Document   : updatePartS
    Created on : 12/11/2016, 09:21:08 PM
    Author     : lorenags
--%>

<%@page import="co.unkitsolutions.businesslogic.controller.PartController"%>
<%@page import="co.unkitsolutions.accessdata.dao.PartDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PartDAO partDAO = new PartDAO();
    List<Part> part;
    part = partDAO.searchAll();
    PartController uPart = new PartController();
    int idPart = (uPart.getIdPart());
    System.out.println("PARTE EN JSP: " + part.get(idPart).getName() + "ID: " + part.get(idPart).getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Actualización de partes</title>
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

            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Actualizar una parte</h3>
                    </div>
                    
                    <form action="../../addPartServlet" method="post">
                        <div class="form-group">
                            <label for="inputName">Nombre</label>
                            <input class="form-control" type="text" name="name" value=<%=part.get(idPart).getName()%> >
                        </div>

                        <div class="form-group">
                            <label for="inputDescription">Descripción</label>
                            <input class="form-control" type="text" name="description" value=<%=part.get(idPart).getDescription()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputCost">Costo</label>
                            <input class="form-control" type="text" name="cost" value=<%=part.get(idPart).getCost()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputUnits">Unidades</label>
                            <input class="form-control" type="text" name="units" value=<%=part.get(idPart).getUnits()%>>
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

