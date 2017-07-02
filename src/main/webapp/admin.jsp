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
<%--<head>--%>
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
<%--</head>--%>
<body>

<jsp:include page="/QuotesData" />

<h2>ADMINISTRATOR PANEL</h2><hr>
<%User user=(User)session.getAttribute("userSessionData");%>
Welcome Admin: '<b><%=user.getLogin()%></b>'<br><br><br>

<%--<form action="currencyFeed.jsp">--%>
<form action="AddParnterServlet" method="GET">
    Add new Partner: </br></br>
    First Name: <input type="text" name="firstName" value="adam"/></br>
    Last Name: <input type="text" name="lastName" value="kowalski"/></br>
    Login: <input type="text" name="login" value="aaa"/></br>
    Password: <input type="text" name="password" value="aaa"/></br>
    Email: <input type="text" name="email" value="123@wp.pl"/></br>
    Transaction Strategy:
    <select name="transactionStrategy" onchange="">
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
    </br></br>
    <%--Joined: <input type="date" name="joinedDate"/></br>--%>

    <input type="submit" value="Add"/>

</form>
<hr>
<form action="LogOutServlet" method="get">
    <input type="submit" value="log out">
</form>

<hr>

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

    LIST OF PARTNERS:</br></br>

    <table border="1">
        <tr>
            <th>Partner Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
            <th>Transaction Strategy</th>
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
            <td><a href="DetailsPartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> view details </a></td>
            <td><a href="DeletePartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> delete </a></td>
        </tr>
        </c:forEach>

    </table>
</br></br>


<div id="load_me">
    <%--<jsp:include page="currencyFeed.jsp"/>--%>
        <jsp:include page="/QuotesData"/>
</div>
<%--<jsp:include page="currencyFeed.jsp"/>--%>

<%--<jsp:include page="currencyFeed.jsp"/>--%>

<b>CURRENCY FEED</b>

<table border="1">
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




<a href="LinkServlet?param1='ala ma kota 1 '">mylink 1 </a><br>
<a href="LinkServlet?param1='ala ma kota 2 '">mylink 2 </a><br>
<a href="LinkServlet?param1='ala ma kota 3'">mylink 3 </a><br>
<a href="LinkServlet?param1='ala ma kota 4'">mylink 4 </a><br>

<form action="LinkServlet" method="get">
    <input type="submit" value="link"/>
</form>

<hr>



<p hidden id="icon-swap"><svg  fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M16 17.01V10h-2v7.01h-3L15 21l4-3.99h-3zM9 3L5 6.99h3V14h2V6.99h3L9 3z"/><path d="M0 0h24v24H0z" fill="none"/></svg></p>
<svg id="icon-up" fill="green" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M4 12l1.41 1.41L11 7.83V20h2V7.83l5.58 5.59L20 12l-8-8-8 8z"/></svg>
<svg id="icon-down" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M20 12l-1.41-1.41L13 16.17V4h-2v12.17l-5.58-5.59L4 12l8 8 8-8z"/></svg>
<svg id="icon-delete" fill="red" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M0 0h24v24H0V0z" fill="none"/><path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zm2.46-7.12l1.41-1.41L12 12.59l2.12-2.12 1.41 1.41L13.41 14l2.12 2.12-1.41 1.41L12 15.41l-2.12 2.12-1.41-1.41L10.59 14l-2.13-2.12zM15.5 4l-1-1h-5l-1 1H5v2h14V4z"/><path d="M0 0h24v24H0z" fill="none"/></svg>
<link rel="stylesheet" type="text/css" href="css/style.css">
</body>
</html>
