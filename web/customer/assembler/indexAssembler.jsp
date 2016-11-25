<%-- 
    Document   : indexAssembler
    Created on : Oct 20, 2016, 5:20:47 AM
    Author     : mauricio
--%>

<%@page import="co.unkitsolutions.accessdata.dao.CustomerDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.unkitsolutions.accessdata.entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CustomerDAO customerDAO = new CustomerDAO();
    List<Customer> allCustomers;

    allCustomers = customerDAO.searchAll();
    
    Customer customerlog = new Customer();
    customerlog = (Customer) request.getSession().getAttribute("customer");

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
        <title>Ensamblador</title>
    </head>
    <body>
        <div class="container">

            <div class="row"> <!--Start header-->
                <div class="col-md-6">
                    <img src="${pageContext.request.contextPath}/images/unkit-logo.jpg">
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
                        <li class="active"><a href="<%=request.getContextPath()%>/customer/assembler/indexAssembler.jsp">Inicio</a></li>
                        <li><a href="<%=request.getContextPath()%>/customer/assembler/buyPart.jsp">Comprar accesorios</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout" method="post">Cerrar sesión</a></li>
                    </ul>
                </nav>
            </div>
            
            <br>

            <h1> Bienvenidos <%= request.getSession().getAttribute("customerName")%> </h1>
            
            <div class="row"> <!--Start login form-->

                <div class="row text-center">
                    <h3>Datos de la empresa</h3>
                    <table class="table table-bordered">
                        <tr>
                            <th>Nit</th>
                            <th>Nombre</th>
                            <th>Tipo de empresa</th>
                        </tr>
                        <tr>
                            <td><%=customerlog.getUserId() %></td>
                            <td><%=customerlog.getTradeName() %></td>
                            <td><%=customerlog.getType() %></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>