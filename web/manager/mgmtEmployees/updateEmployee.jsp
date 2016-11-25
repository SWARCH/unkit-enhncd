<%-- 
    Document   : updating
    Created on : Oct 20, 2016, 9:00:38 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EmployeeDAO employeeDAO = new EmployeeDAO();
    List<Employee> allEmployees;

    allEmployees = employeeDAO.searchAll();

    System.out.println("HOLA UPDATE EMPLOYEE-----------");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Gestión de empleados</title>
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
                        <li><a href="<%=request.getContextPath()%>/manager/mgmtEmployees/hireEmployee.jsp">Registrar empleado</a></li>
                    </ul>
                </nav>
            </div>

            <div class="row"> <!--Start login form-->

                <div class="row text-center">
                    <h3>Gestionar de empleados</h3>
                    <p>Seleccione la parte que desee actualizar</p>
                    <table class="table table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Género</th>
                            <th>Rol</th>
                            <th>Tipo de contrato</th>
                            <th>Estado de contrato</th>
                            <th>Salario</th>
                            <th> </th>
                            <th> </th>
                        </tr>
                        <%
                            int j = 0;
                            for (Employee e : allEmployees) {
                                //if(e.getContractStatus()== "Activo"){
                        %>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/updateEmployee?idEmployee=<%=j++%>" ><%=e.getUserId()%></a></td>
                            <td><%=e.getName()%></td>
                            <td><%=e.getGender()%></td>
                            <td><%=e.getRole()%></td>
                            <td><%=e.getContractType()%></td>
                            <td><%=e.getContractStatus()%></td>
                            <td>$<%=e.getSalary()%></td>
                            <td><a href="${pageContext.request.contextPath}/addEmployeeServlet?idEmployee=<%=e.getUserId()%>" >Eliminar</a></td>
                        </tr>

                        <%
                                //}
                            }
                        %>

                    </table>
                </div>
            </div>
    </body>
</html>
