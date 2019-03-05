<%--@elvariable id="allUsers" type="java.util.List"--%>
<%--@elvariable id="user" type="String"--%>
<%@include file="../jspf/import.jspf" %>
<html>
<head>
    <title>${users}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
</head>
<body>

<%@include file="../jspf/header.jspf" %>

<fmt:message bundle="${mess}" key="users.title" var="title"/>

<div class="container" style="width:60%">
    <h1 class="my-4" align="center">
        <small>${title}</small>
    </h1>
    <table class="table">
        <tbody>
            <c:forEach items="${allUsers}" var="u">
                <tr>
                    <th>${u.id}</th>
                    <td>${u.firstName}</td>
                    <td>${u.lastName}</td>
                    <td>${u.role.value}</td>
                    <td>
                        <c:if test="${u.role.value == 'client'}">
                            <form method="POST" action="${adminUserCommand}${userId}${u.id}">
                                <input type="submit" class="btn btn-success" value="${bMakeAdmin}"/>
                            </form>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${u.login != user}">
                            <form method="POST" action="${deleteUserCommand}${userId}${u.id}">
                                <input type="submit" class="btn btn-danger" value="${bDelete}"/>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>

</div>

</body>
</html>
