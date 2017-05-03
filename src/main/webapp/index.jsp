<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.UserDataUtil" %>
<html>
<body>



<h2>ADMINISTRATOR PANEL</h2>

<%--<form action="currencyFeed.jsp">--%>
<form action="AddUserServlet" method="GET">
    Add new Partner: </br>
    First name: <input type="text" name="firstName" value="adam"/></br>
    Last name: <input type="text" name="lastName" value="kowalski"/></br>
    Login: <input type="text" name="login" value="aaa"/></br>
    Password: <input type="text" name="password" value="123"/></br>
    Email: <input type="text" name="email" value="123@wp.pl"/></br>
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
<jsp:include page="usersList.jsp"/>
<hr>

<hr>
<%--<jsp:include page="confirm.jsp"/>--%>
<hr>


</body>
</html>
