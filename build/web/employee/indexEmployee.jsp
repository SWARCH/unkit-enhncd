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
        <% Employee currentEmployee = (Employee)request.getSession().getAttribute("employee"); %>
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
            
            <!-- Generates a greeting depending on the gender. Cool! -->
            <% if (request.getSession().getAttribute("employeeGender").equals('F')) {%>
            <h1> Bienvenida <%= request.getSession().getAttribute("employeeName")%> </h1>
            <% } else {%>
            <h1> Bienvenido <%= request.getSession().getAttribute("employeeName")%> </h1>
            <% }%>

            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Información</h3>
                    </div>
                    <form action="loginServlet" method="post">
                        <div class="form-group">
                            <label for="ce_username">Nombre de usuario: </label>
                            <%= currentEmployee.getName() %>
                        </div>
                        <div class="form-group">
                            <label for="ce_">Salario: </label>
                            $<%= currentEmployee.getSalary() %>
                        </div>
                        <a href="employee/changePassword.jsp" class="btn btn-default">Cambiar contraseña</a>
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
