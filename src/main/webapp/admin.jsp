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

    <%--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>--%>
    <%--<script>--%>
        <%--$(document).ready(function() {--%>
            <%--var reloadData = 0; // store timer--%>

            <%--// load data on page load, which sets timeout to reload again--%>
            <%--setInterval( "updateShouts()", 5000 );--%>
        <%--});--%>

        <%--function updateShouts(){--%>
            <%--// Assuming we have #shoutbox--%>
            <%--$('#load_me').load('admin.jsp');--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<jsp:include page="/QuotesData" />
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
    </nav></br>
    <div class="row"></div>

    <div class ="col-lg-offset-0 col-lg-5">
        <form class="form-horizontal" action="AddParnterServlet" method="get">
            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">First Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="Adam">
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="Kowalski">
                </div>
            </div>
            <div class="form-group">
                <label for="login" class="col-sm-3 control-label">Login</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="login" name="login" value="123">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="password" name="password" value="123">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="email" name="email" value="123@wp.pl">
                </div>
            </div>
            <div class="form-group">
                <label for="transactionStrategy" class="col-sm-3 control-label">Transaction Strategy</label>
                <div class="col-sm-5">
                    <select class="form-control" id="transactionStrategy" name="transactionStrategy">
                        <option value="1">Strategy 1</option>
                        <option value="2">Strategy 2</option>
                        <option value="3">Strategy 3</option>
                        <option value="4">Strategy 4</option>
                        <option value="5">Strategy 5</option>
                        <option value="6">Strategy 6</option>
                        <option value="7">Strategy 7</option>
                        <option value="8">Strategy 8</option>
                        <option value="9">Strategy 9</option>
                        <option value="10">Strategy 10</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <button type="submit" class="btn btn-default">Add new Partner</button>
                </div>
            </div>
        </form>
    </div>

    <div class ="col-lg-offset-3 col-lg-2 ">
        <table class="table table-striped col-sm-3 " >
            <tr>
                <th>Symbol</th>
                <th>Bid</th>
                <th>Ask</th>
                <th>Change</th>
                <th></th>
            </tr>
            <c:forEach var="value" items="${listOfQuotes}">
                <tr>
                    <td><c:out value="${value.symbol}" /></td>
                    <c:if test="${value.change >= 0.0001}">
                        <td class="greenColor">
                            <c:out value="${value.bid}" /></td>
                    </c:if>
                    <c:if test="${value.change <= -0.0001}">
                        <td class="redColor"><c:out value="${value.bid}" /></td>
                    </c:if>
                    <c:if test="${value.change >= 0.0001}">
                        <td class="greenColor"><c:out value="${value.ask}" /></td>
                    </c:if>
                    <c:if test="${value.change <= -0.0001}">
                        <td class="redColor"><c:out value="${value.ask}" /></td>
                    </c:if>
                    <c:if test="${value.change >= 0.0001}">
                        <td class="greenColor"><c:out value="${value.change}" /></td>
                    </c:if>
                    <c:if test="${value.change <= -0.0001}">
                        <td class="redColor"><c:out value="${value.change}"/></td>
                    </c:if>
                    <c:if test="${value.change >= 0.0001}">
                        <td>
                            <svg id="icon-up" fill="green" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M4 12l1.41 1.41L11 7.83V20h2V7.83l5.58 5.59L20 12l-8-8-8 8z"/></svg>
                        </td>
                    </c:if>
                    <c:if test="${value.change <= -0.0001}">
                        <td>
                            <svg id="icon-down" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M20 12l-1.41-1.41L13 16.17V4h-2v12.17l-5.58-5.59L4 12l8 8 8-8z"/></svg>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    <h6>*source: <a href="https://www.instaforex.com" target="_blank" >https://www.instaforex.com</a></h6>
    </div>
    <div class="row"></div>

    <hr>

    <h4><b>Table of Partners:</b></h4> </br>
    <div class ="col-sm-6 ">
    <table class="table table-striped col-sm-6 ">
        <tr>
            <th>Partner Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
            <th>Strategy</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach var="value" items="${listOfAllPartners}">
        <tr>
            <td><c:out value="${value.partnerId}" /></td>
            <td><c:out value="${value.firstName}" /></td>
            <td><c:out value="${value.lastName}" /></td>
            <td><c:out value="${value.login}" /></td>
            <td><c:out value="${value.password}" /></td>
            <td><c:out value="${value.email}" /></td>
            <td><c:out value="${value.closedTradesTransactionStrategyNumber}" /></td>
            <td><a href="EditParnterServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> edit </a></td>
            <td><a href="DetailsPartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> details </a></td>
            <td><a href="DeletePartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> <svg id="icon-delete" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zm2.46-7.12l1.41-1.41L12 12.59l2.12-2.12 1.41 1.41L13.41 14l2.12 2.12-1.41 1.41L12 15.41l-2.12 2.12-1.41-1.41L10.59 14l-2.13-2.12zM15.5 4l-1-1h-5l-1 1H5v2h14V4z"/><path d="M0 0h24v24H0z" fill="none"/></svg>
            </a></td>
        </tr>
        </c:forEach>

    </table>
    </div>
</br></br>

</div>

<p hidden id="icon-swap"><svg  fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M16 17.01V10h-2v7.01h-3L15 21l4-3.99h-3zM9 3L5 6.99h3V14h2V6.99h3L9 3z"/><path d="M0 0h24v24H0z" fill="none"/></svg></p>
<p hidden ><svg id="icon-up" fill="green" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M4 12l1.41 1.41L11 7.83V20h2V7.83l5.58 5.59L20 12l-8-8-8 8z"/></svg></p>
<p hidden ><svg id="icon-down" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M20 12l-1.41-1.41L13 16.17V4h-2v12.17l-5.58-5.59L4 12l8 8 8-8z"/></svg></p>
<p hidden ><svg id="icon-delete" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zm2.46-7.12l1.41-1.41L12 12.59l2.12-2.12 1.41 1.41L13.41 14l2.12 2.12-1.41 1.41L12 15.41l-2.12 2.12-1.41-1.41L10.59 14l-2.13-2.12zM15.5 4l-1-1h-5l-1 1H5v2h14V4z"/><path d="M0 0h24v24H0z" fill="none"/></svg></p>

<!-- body bootstrap + jquery-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- koniec body bootstrap + jquery-->
</body>
</html>


<%--<%--%>
<%--List<Partner> listOfPartners = ((List<Partner>) session.getAttribute("listOfPartners"));--%>
<%--%>--%>

<%--&lt;%&ndash;LIST OF PARTNERS:</br></br>&ndash;%&gt;--%>

<%--<table border="1">--%>
<%--<tr>--%>
<%--<th>First name</th>--%>
<%--<th>Last name</th>--%>
<%--&lt;%&ndash;<th>Login</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;<th>Password</th>&ndash;%&gt;--%>
<%--<th>Email</th>--%>
<%--<th></th>--%>
<%--<th></th>--%>
<%--</tr>--%>
<%--<% for(int i = 0; i < listOfPartners.size(); i++) { %>--%>
<%--<tr>--%>
<%--&lt;%&ndash;<td><%=listOfPartners.get(i).getFirstName()%></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><%=listOfPartners.get(i).getLastName()%></td>&ndash;%&gt;--%>
<%--<td><%=listOfPartners.get(i).getLogin()%></td>--%>
<%--<td><%=listOfPartners.get(i).getPassword()%></td>--%>
<%--&lt;%&ndash;<td><%=listOfPartners.get(i).getEmail()%></td>&ndash;%&gt;--%>
<%--<td>view details</td>--%>
<%--<td>delete</td>--%>
<%--</tr>--%>
<%--<% } %>--%>

<%--</table>--%>