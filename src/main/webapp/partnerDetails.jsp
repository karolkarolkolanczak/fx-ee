<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <th>Transaction Strategy</th>
            <th>Total Profit / Bonus (for period)</th>
        </tr>
        <tr>
            <td><c:out value="${partnerDetails.partnerId}"/></td>
            <td><c:out value="${partnerDetails.firstName}"/></td>
            <td><c:out value="${partnerDetails.lastName}"/></td>
            <td><c:out value="${partnerDetails.login}"/></td>
            <td><c:out value="${partnerDetails.password}"/></td>
            <td><c:out value="${partnerDetails.email}"/></td>
            <td><c:out value="${partnerDetails.closedTradesTransactionStrategyNumber}" /></td>
            <td></td>
         </tr>

    </table></br></br>

<hr>
    <b>Transactions list (closed trades):</b> </br></br>

<form action="DetailsPartnerFilterServlet" method="GET">
    <input type="hidden" name="parameterPartnerId" value="<c:out value="${partnerDetails.partnerId}" />"/>
    Trades from: <input type="date" name="closedTradesFrom" value="2017-01-01"/></br>
    Trades To: <input type="date" name="closedTradesTo" value="2017-02-01"/></br>
    <input type="submit" value="Search"/>
</form></br>

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
        <c:forEach var="value" items="${closedTradesTransactionslist}">
            <tr>
                <td><c:out value="${value.transactionId}" /></td>
                <td><c:out value="${value.symbol}" /></td>
                <%--<fmt:formatDate type="date" value="${value.openDate}" pattern="yyyy-MM-dd" />--%>
                <td><c:out value="${value.openDate}" /></td>
                <td><c:out value="${value.closeDate}" /></td>
                <td><c:out value="${value.action}" /></td>
                <td><c:out value="${value.openPrice}" /></td>
                <td><c:out value="${value.closePrice}" /></td>
                <td><c:out value="${value.lots}" /></td>
                <td><c:out value="${value.profit}" /></td>
              <%--<td><a href="DeletePartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> delete </a></td>--%>
            </tr>
        </c:forEach>
    </table></br>

<h6>*source: <a href="https://www.instaforex.com" target="_blank">http://www.myfxbook.com</a></h6>


    <hr>
    <form action="LogOutServlet" method="get">
        <input type="submit" value="log out">
    </form>

    <form action="GoToAdminServlet" method="get">
        <input type="submit" value="back to main">
    </form>

</body>
</html>
