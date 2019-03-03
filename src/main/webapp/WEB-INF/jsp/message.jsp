<%--@elvariable id="success" type="String"--%>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
</head>
<body>
    <%@include file="../jspf/header.jspf" %>
    <div class="container" style="width:60%">
        <h1 class="my-4" align="center">
            <small><fmt:message key="message.message" bundle="${mess}"/></small>
        </h1>
        <div>
            <c:if test="${success != null}">
                <h3><fmt:message key="message.success" bundle="${mess}"/></h3>
                <p><fmt:message key="${success}" bundle="${mess}"/></p>
            </c:if>
        </div>
    </div>
</body>
</html>
