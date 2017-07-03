<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Utility.UserDataUtil" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Partner" %>
<%@ page import="java.math.BigDecimal" %>
<html>
<head>
    <!--  bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="css/bootstrap-reboot.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- head koniec  bootstrap -->

    <body>
    <div class="container">

        <nav class="navbar navbar-default ">
            <div style="margin: 20px">
                <h2>ADMINISTRATOR PANEL</h2>
            </div>
        </nav></br></br>
        <div class="row"></div>

        <div class ="col-md-offset-0 col-sm-5">
            <form class="form-horizontal" action="LoginServlet" method="get">
                <div class="form-group">
                    <label for="login" class="col-sm-2 control-label">Login</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="login" name="login" value="admin">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="password" name="password" value="admin">
                    </div>
                </div></br>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </div>

    </div>

    <!-- body bootstrap + jquery-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- koniec body bootstrap + jquery-->
    </body>
</html>
