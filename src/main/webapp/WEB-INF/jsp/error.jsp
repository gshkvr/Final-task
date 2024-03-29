<%@include file="../jspf/import.jspf" %>
<html>
<head>
    <title>${error}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
</head>
<body>
    <%@include file="../jspf/header.jspf" %>
    <div class="container" style="width:60%">
        <h1 class="my-4" align="center">
            <small><fmt:message key="error.error" bundle="${mess}"/></small>
        </h1>
        <div>
            <h3><fmt:message key="error.text" bundle="${mess}"/></h3>
            <p><fmt:message key="error.sorry" bundle="${mess}"/></p>
        </div>
    </div>
</body>
</html>
