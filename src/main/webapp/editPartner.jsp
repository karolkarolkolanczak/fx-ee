<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Utility.UserDataUtil" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Partner" %>
<html>
<body>

<h2>ADMINISTRATOR PANEL</h2><hr>
<%User user=(User)session.getAttribute("userSessionData");%>
Welcome Admin: '<b><%=user.getLogin()%></b>'<br><br><br>

<b>Edit Partner:</b></br></br>

<table border="1">
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

</table></br></br>

<form action="SavePartnerServlet" method="GET">
    <b>Edit Partner:</b> </br></br>
    <input type="hidden" name="partnerId" value="<c:out value="${partnerDetails.partnerId}" />"/>
    First name: <input type="text" name="firstName" value="<c:out value="${partnerDetails.firstName}" />"/></br>
    Last name: <input type="text" name="lastName" value="<c:out value="${partnerDetails.lastName}" />"/></br>
    Login: <input type="text" name="login" value="<c:out value="${partnerDetails.login}"/>"/></br>
    Password: <input type="text" name="password" value="<c:out value="${partnerDetails.password}"/>"/></br>
    Email: <input type="text" name="email" value="<c:out value="${partnerDetails.email}"/>"/></br>
    <input type="hidden" name="strategy" value="<c:out value="${partnerDetails.closedTradesTransactionStrategyNumber}"/>"/></br>

    <%--Joined: <input type="date" name="joinedDate"/></br>--%>

    <input type="submit" value="Save"/>
</form>

<hr>
<form action="LogOutServlet" method="get">
    <input type="submit" value="log out">
</form>

<form action="GoToAdminServlet" method="get">
    <input type="submit" value="back to main">
</form>

</body>
</html>
