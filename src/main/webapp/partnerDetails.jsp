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

    <b>Partner details:</b></br></br>

    <table border="1">
        <tr>
            <th>Partner Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
            <th>Total Profit / Bonus (for period)</th>

        </tr>
        <tr>
            <td><c:out value="${partnerDetails.partnerId}"/></td>
            <td><c:out value="${partnerDetails.firstName}"/></td>
            <td><c:out value="${partnerDetails.lastName}"/></td>
            <td><c:out value="${partnerDetails.login}"/></td>
            <td><c:out value="${partnerDetails.password}"/></td>
            <td><c:out value="${partnerDetails.email}"/></td>
         </tr>

    </table></br></br>

<hr>

    <b>Transactions list (closed trades):</b> </br></br>

    <table border="1">
    <tr>
        <th>Transaction Id</th>
        <th>Symbol</th>
        <th>Open Date</th>
        <th>Close Date</th>
        <th>Action</th>
        <th>Open Price</th>
        <th>Close Price</th>
        <th>Lots</th>
        <th>Profit</th>

    </tr>
    <tr>
        <td><c:out value="${partnerDetails.partnerId}"/></td>
        <td><c:out value="${partnerDetails.firstName}"/></td>
        <td><c:out value="${partnerDetails.lastName}"/></td>
        <td><c:out value="${partnerDetails.login}"/></td>
        <td><c:out value="${partnerDetails.password}"/></td>
        <td><c:out value="${partnerDetails.email}"/></td>
    </tr>

</table></br>

    <hr>
    <form action="LogOutServlet" method="get">
        <input type="submit" value="log out">
    </form>

    <form action="GoToAdminServlet" method="get">
        <input type="submit" value="back to main">
    </form>

</body>
</html>
