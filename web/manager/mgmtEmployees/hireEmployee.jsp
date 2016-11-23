<%-- 
    Document   : hireEmployee
    Created on : Oct 20, 2016, 9:00:04 AM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Registro de empleados</title>
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
                        <h3>Registrar un empleado</h3>
                    </div>
                    <form action="../../addEmployeeServlet" method="post">
                        <div class="form-group">
                            <label for="inputUsername">Nombre de usuario</label>
                            <input class="form-control" type="text" name="user">
                        </div>
                        <div class="form-group">
                            <label for="inputName">Nombres y apellidos</label>
                            <input class="form-control" type="text" name="name">
                        </div>
                        <div class="form-group">
                            <label for="inputID">Documento de identificación</label>
                            <input class="form-control" type="text" name="id">
                        </div>
                        <div class="form-group">
                            <label for="inputGender">Género</label>
                            <select name="gender">
                                <option value="F">Femenino</option>
                                <option value="M">Masculino</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputRole">Tipo de empleado</label>
                            <select name="role">
                                <option value="manager">Administrador</option>
                                <option value="manufacturer">Fabricante</option>
                                <option value="assembler">Ensamblador</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputContractType">Tipo de contrato</label>
                            <select name="contractType">
                                <option value="undefined">Indefinido</option>
                                <option value="fixedTerm">Termino fijo</option>
                                <option value="services">Prestación de servicios</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputSalary">Salario</label>
                            <input class="form-control" type="text" name="salary">
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Contraseña</label>
                            <input class="form-control" type="password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="inputPasswordC">Confirme su contraseña</label>
                            <input class="form-control" type="password" name="passwordC">
                        </div>
                        <button type="submit" class="btn btn-default">Registrar</button>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

        </div>
    </body>
</html>
