<%-- 
    Document   : index
    Created on : Oct 21, 2016, 10:45:09 AM
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
        <title>Home</title>
    </head>
    <body>
        <div class="container">

            <div class="row"><!--Start header-->
                <div class="col-md-6">
                    <img src="images/unkit-logo.jpg">
                </div>
                <div class="col-md-6 text-right text-uppercase">
                    <h1>
                        UN KIT Solutions Ltda.
                    </h1>
                    <h3>
                        Fábrica CKD
                    </h3>
                </div>
            </div>
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <!--End header-->

            <!--Start button bar-->
            <div class="row">
                <a class="btn btn-default" href="login.jsp" role="button">Ingresar</a>
                <a class="btn btn-default" href="login.jsp" role="button">Trabaje aquí</a>
                <a class="btn btn-default" href="login.jsp" role="button">¿Quienes somos?</a>
            </div>
            <!--End button bar-->
            
            <br>

            <!--Start carousel-->
            <div class="row">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="images/assembler1.jpg" alt="Slide 1">
                            <div class="carousel-caption">
                                caption 1
                            </div>
                        </div>
                        <div class="item">
                            <img src="images/car1.jpg" alt="Slide 2">
                            <div class="carousel-caption">
                                caption 2
                            </div>
                        </div>
                        <div class="item">
                            <img src="images/employee_team.jpg" alt="Slide 3">
                            <div class="carousel-caption">
                                caption 3
                            </div>
                        </div>
                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <!--End carousel-->

        </div>
    </body>
</html>
