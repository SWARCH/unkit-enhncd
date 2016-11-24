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
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/employee/changePassword.jsp">Cambiar contraseña</a></li>
                        <li><a href="quitJobServlet">Renunciar</a></li>
                        <li><a href="${pageContext.request.contextPath}/assembler/indexAssembler.jsp">Retroceder</a></li>
                        <li><a href="LogoutServlet">Salir</a></li>
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
                            <label for="ce_id">ID: </label>
                            <output><%= currentEmployee.getUser().getId()%></output>
                        </div>
                        <div class="form-group">
                            <label for="ce_username">Nombre de acceso: </label>
                            <output><%= currentEmployee.getUser().getUsername()%></output>
                        </div>
                        <div class="form-group">
                            <label for="ce_name">Nombre completo: </label>
                            <output><%= currentEmployee.getName()%></output>
                        </div>
                        <div class="form-group">
                            <label for="ce_salary">Salario: </label>
                            <output>$<%= currentEmployee.getSalary()%></output>
                        </div>
                        <div class="form-group">
                            <label for="ce_contract">Estado del contrato: </label>
                            <output><%= currentEmployee.getContractStatus().equals("active")? "Activo" : "Otro" %></output>
                        </div>
                        <br>
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
