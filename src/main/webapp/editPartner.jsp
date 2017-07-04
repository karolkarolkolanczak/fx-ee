<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Utility.UserDataUtil" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Partner" %>
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
</head>
<body>
<%User user=(User)session.getAttribute("userSessionData");%>
<div class="container">

    <nav class="navbar navbar-default ">
        <div style="position:absolute; top:5px; right:10px" >
            Welcome Admin: '<b><%=user.getLogin()%></b>'</br>
        </div>
        <div style="position:absolute; top:30px; right:10px" >
            <form action="LogOutServlet" method="get">
                <button type="submit" class="btn btn-default">log out</button>
                <%--<input type="submit" value="log out">--%>
            </form>
        </div>
        <div style="margin: 20px">
            <h2>ADMINISTRATOR PANEL</h2>
        </div>
    </nav>
    <div class="row"></div>

    <h4><b>Edit Partner:</b></h4> </br>
    <div class ="col-md-offset-0 col-sm-5">
        <form class="form-horizontal" action="SavePartnerServlet" method="get">
            <div class="form-group">
                <div class="col-sm-5">
                    <input type="hidden" class="form-control" id="partnerId" name="partnerId" value="<c:out value="${partnerDetails.partnerId}" />" >
                </div>
            </div>
            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">First Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="<c:out value="${partnerDetails.firstName}" />">
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="<c:out value="${partnerDetails.lastName}" />">
                </div>
            </div>
            <div class="form-group">
                <label for="login" class="col-sm-3 control-label">Login</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="login" name="login" value="<c:out value="${partnerDetails.login}"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="password" name="password"  value="<c:out value="${partnerDetails.password}"/>">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="email" name="email" value="<c:out value="${partnerDetails.email}"/>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-5">
                    <input type="hidden" class="form-control" id="strategy" name="strategy" value="<c:out value="${partnerDetails.closedTradesTransactionStrategyNumber}"/>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <button type="submit" class="btn btn-default">Save</button>
                </div>
            </div>
        </form>
    </div>

    <%--<div class="row"></div>--%>

    <div class ="col-sm-6 ">
        <table class="table table-striped col-sm-6 ">
        <tr>
            <th>Partner Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
            <th>Transaction Strategy</th>

        </tr>
        <tr>
            <td><c:out value="${partnerDetails.partnerId}"/></td>
            <td><c:out value="${partnerDetails.firstName}"/></td>
            <td><c:out value="${partnerDetails.lastName}"/></td>
            <td><c:out value="${partnerDetails.login}"/></td>
            <td><c:out value="${partnerDetails.password}"/></td>
            <td><c:out value="${partnerDetails.email}"/></td>
            <td><c:out value="${partnerDetails.closedTradesTransactionStrategyNumber}" /></td>
        </tr>

        </table>
    </div>
    <div class="row"></div>

    <hr>
    <form action="GoToAdminServlet" method="get">
        <button type="submit" class="btn btn-default">back to main</button>
    </form>
</div>
<!-- body bootstrap + jquery-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- koniec body bootstrap + jquery-->
</body>
</html>
