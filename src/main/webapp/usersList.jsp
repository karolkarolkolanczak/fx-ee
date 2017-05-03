<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
USERS LIST </br>

<c:forEach var="value" items ="${UserDataUtil.getListOfUsers()}" >
    ${value.firstName}</br>
</c:forEach>