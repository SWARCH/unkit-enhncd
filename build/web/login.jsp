<%-- 
    Document   : login
    Created on : Oct 18, 2016, 11:43:13 PM
    Author     : mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Ingreso al sistema</title>
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
            
            <!-- Navigation menu -->
            <div class="masthead">
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Retroceder</a></li>
                    </ul>
                </nav>
            </div>

            <br>

            <div class="row"> <!--Start login form-->
                <div class="col-md-4 col-md-offset-4">
                    <div class="row text-center">
                        <h3>Log in</h3>
                    </div>
                    <form action="loginServlet" method="post">
                        <div class="form-group">
                            <label for="inputUsername">Nombre de usuario</label>
                            <input class="form-control" type="text" name="usr">
                        </div>
                        <div class="form-group">
                            <label for="inputUsername">Contraseña</label>
                            <input class="form-control" type="password" name="pwd">
                        </div>
                        <button type="submit" class="btn btn-default">Ingresar</button>
                        <br><br>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div> <!--End login form-->

            <!-- FOOTER -->
            <footer>
                <p class="pull-right"><a href="./login.jsp">Back to top</a></p>
                <p>&copy; 2016 Unkit Solutions Ltda.  &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
            </footer>

        </div>
    </body>
</html>
