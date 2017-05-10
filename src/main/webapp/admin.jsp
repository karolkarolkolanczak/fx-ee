<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.UserDataUtil" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Partner" %>
<html>
<body>


<h2>ADMINISTRATOR PANEL</h2>

<%--<form action="currencyFeed.jsp">--%>
<form action="AddParnterServlet" method="GET">
    Add new Partner: </br></br>
    First name: <input type="text" name="firstName" value="adam"/></br>
    Last name: <input type="text" name="lastName" value="kowalski"/></br>
    <%--Login: <input type="text" name="login" value="aaa"/></br>--%>
    <%--Password: <input type="text" name="password" value="123"/></br>--%>
    Email: <input type="text" name="email" value="123@wp.pl"/></br></br>
    <%--Joined: <input type="date" name="joinedDate"/></br>--%>

    <input type="submit" value="Add"/>

</form>
<hr>
<form action="LogOutServlet" method="get">
    <input type="submit" value="log out">
</form>
<hr>
<jsp:include page="currencyFeed.jsp"/>

<hr>
<hr>

<%--<%--%>
    <%--List<Partner> listOfPartners = ((List<Partner>) session.getAttribute("listOfPartners"));--%>
<%--%>--%>

<%--LIST OF PARTNERS:</br></br>--%>

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
        <%--<td><%=listOfPartners.get(i).getFirstName()%></td>--%>
        <%--<td><%=listOfPartners.get(i).getLastName()%></td>--%>
        <%--&lt;%&ndash;<td><%=listOfPartners.get(i).getLogin()%></td>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<td><%=listOfPartners.get(i).getPassword()%></td>&ndash;%&gt;--%>
        <%--<td><%=listOfPartners.get(i).getEmail()%></td>--%>
        <%--<td>view details</td>--%>
        <%--<td>delete</td>--%>
    <%--</tr>--%>
    <%--<% } %>--%>

<%--</table>--%>

<hr>
    <%--<jsp:include page="usersList.jsp"/>--%>
<hr>

    LIST OF PARTNERS:</br></br>

    <table border="1">
    <tr>
    <th>First name</th>
    <th>Last name</th>
    <%--<th>Login</th>--%>
    <%--<th>Password</th>--%>
    <th>Email</th>
    <th></th>
    <th></th>
    </tr>

        <c:forEach var="partner" items="${listOfPartners}">
        <tr>
            <td><c:out value="${partner.firstName}" /></td>
            <td><c:out value="${partner.lastName}" /></td>
            <td><c:out value="${partner.email}" /></td>
            <td>view details</td>
            <td>delete</td>
        </tr>
        </c:forEach>

    </table>
</br></br>
<form action="LinkServlet" method="get">
    <input type="submit" value="link"/>
</form>

<a href="LinkServlet?param1='ala ma kota 1 '">mylink 1 </a><br>
<a href="LinkServlet?param1='ala ma kota 2 '">mylink 2 </a><br>
<a href="LinkServlet?param1='ala ma kota 3'">mylink 3 </a><br>
<a href="LinkServlet?param1='ala ma kota 4'">mylink 4 </a><br>



</body>
</html>
