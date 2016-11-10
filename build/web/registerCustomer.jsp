<%-- 
    Document   : registerCustomer
    Created on : Oct 23, 2016, 02:43:13 PM
    Author     : lorena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
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
                        <h3>Registro</h3>
                    </div>
                    <form action="RegisterCustomer" method="post">
                        <div class="form-group">
                            <label for="inputUsername">Nombre de usuario</label>
                            <input class="form-control" type="text" name="user">
                        </div>
                        <div class="form-group">
                            <label for="inputName">Razón social</label>
                            <input class="form-control" type="text" name="tradeName">
                        </div>
                        <div class="form-group">
                            <label for="inputID">Nit</label>
                            <input class="form-control" type="text" name="id">
                        </div>
                        <div class="form-group">
                            <label for="inputType">Tipo de empresa</label>
                            <select name="type">
                                <option value="assembler">Ensambladora</option>
                                <option value="wholesaler">Mayorista</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Contraseña</label>
                            <input class="form-control" type="password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="inputPasswordC">Confirme la contraseña</label>
                            <input class="form-control" type="password" name="passwordC">
                        </div>
                        <button type="submit" class="btn btn-default">Registrarse</button>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

        </div>
    </body>
</html>
