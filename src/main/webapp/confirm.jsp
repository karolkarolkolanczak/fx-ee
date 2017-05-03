<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
COFIRMQATION
<hr>
request: <%= request.getAuthType()%> </br>
request Path : <%= request.getContextPath()%> </br>
request path info: <%= request.getPathInfo()%> </br>
request cokies: <%= request.getCookies()%> </br>
request header names: <%= request.getHeaderNames()%> </br>
request gest session id : <%= request.getRequestedSessionId()%> </br>
request Servlet path: <%= request.getServletPath()%> </br>
request LOCale: <%= request.getLocale()%> </br>
request to string : <%= request.toString()%> </br>
<hr>
response header names: <%= response.getHeaderNames()%> </br>
response status: <%= response.getStatus()%> </br>
response get class: <%= response.getClass()%> </br>
response to string: <%= response.toString()%> </br>
<hr>
<%=request.getParameterNames()%> </br>
<%=request.getParameter("firstName")%> </br>
<%=request.getParameter("password")%> </br>


    <%=
    ((User) session.getAttribute("userSessionData")).getEmail()
    %>


</body>
</html>
