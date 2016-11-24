<%-- 
    Document   : indexEmployee
    Created on : Oct 20, 2016, 4:46:42 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Empleados</title>
    </head>
    <body>
        <% Employee currentEmployee = (Employee) request.getSession().getAttribute("employee"); %>
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

            <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="masthead">
                <!-- Generates a greeting depending on the gender. Cool! -->
                <% if (request.getSession().getAttribute("employeeGender").equals('F')) {%>
                <h1> Bienvenida <%= request.getSession().getAttribute("employeeName")%> </h1>
                <% } else {%>
                <h1> Bienvenido <%= request.getSession().getAttribute("employeeName")%> </h1>
                <% }%>
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="index.jsp">Home</a></li>
                        <li><a href="#">Manual del empleado</a></li>
                        <li><a href="#">Manual técnico</a></li>
                        <li><a href="#">Terminos de uso</a></li>
                        <li><a href="#">Contacta a tu patrón</a></li>
                    </ul>
                </nav>
            </div>


            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Información</h3>
                    </div>
                    <form action="loginServlet" method="post">
                        <div class="form-group">
                            <label for="ce_username">ID: </label>
                            <%= currentEmployee.getUser().getId()%>
                        </div>
                        <div class="form-group">
                            <label for="ce_username">Nombre de acceso: </label>
                            <%= currentEmployee.getUser().getUsername()%>
                        </div>
                        <div class="form-group">
                            <label for="ce_username">Nombre completo: </label>
                            <%= currentEmployee.getName()%>
                        </div>
                        <div class="form-group">
                            <label for="ce_salary">Salario: </label>
                            $<%= currentEmployee.getSalary()%>
                        </div>
                        <div class="form-group">
                            <label for="ce_">Estado del contrato: </label>
                            <%= currentEmployee.getContractStatus().equals("active")? "Activo" : "Otro" %>
                        </div>
                        <a href="#" class="btn btn-default">Cambiar contraseña</a>
                        <a href="${pageContext.request.contextPath}/quitJobServlet?quit=true">Renunciar</a>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="./index.jsp">Back to top</a></p>
                <p>&copy; 2016 Unkit Solutions Ltda.  &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div>
    </body>
</html>
