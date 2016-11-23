<%-- 
    Document   : updateEmployeeS
    Created on : 22/11/2016, 07:06:23 PM
    Author     : lorenags
--%>

<%@page import="co.unkitsolutions.businesslogic.controller.EmployeeController"%>
<%@page import="co.unkitsolutions.accessdata.dao.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EmployeeDAO employeeDAO = new EmployeeDAO();
    List<Employee> employee;
    employee = employeeDAO.searchAll();
    EmployeeController uEmployee = new EmployeeController();
    int idEmployee = (uEmployee.getIdEmployee());
    System.out.println("PARTE EN JSP: " + employee.get(idEmployee).getName() + "ID: " + employee.get(idEmployee).getUserId());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Actualización de empleados</title>
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
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtEmployees/updateEmployee.jsp">Volver</a></li>
                    </ul>
                </nav>
            </div>
            
            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Actualizar los datos de un empleado</h3>
                    </div>
                    <form action="updateEmployee" method="post">
                        <div class="form-group">
                            <label for="inputName">Nombres y apellidos</label>
                            <input class="form-control" type="text" name="name" value=<%=employee.get(idEmployee).getName()%>>
                        </div>
                        <div class="form-group">
                            <label for="inputSalary">Salario</label>
                            <input class="form-control" type="text" name="salary" value=<%=employee.get(idEmployee).getSalary()%>>
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
