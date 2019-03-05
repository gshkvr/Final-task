<%--@elvariable id="errorRegistration" type="String"--%>
<%--@elvariable id="allRequests" type="java.util.List"--%>
<%@include file="../jspf/import.jspf" %>
<html>
<head>
    <title>${requests}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
<%@include file="../jspf/header.jspf" %>
<div class="container" style="width:60%">
    <c:choose>
        <c:when test="${allRequests.size() == 0}">
            <h1 class="my-4">${requests}
                <small>${noRequests}</small>
            </h1>
        </c:when>
        <c:otherwise>
            <h1 class="my-4">${requests}</h1>
            <div class="row">
                <c:forEach items="${allRequests}" var="req">
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <div class="card h-auto">
                            <img class="card-img-top" src="${pageContext.request.contextPath}${req.fileLink}" alt="">
                            <div class="card-body">
                                <h4 class="card-title">${req.fullName}</h4>
                                <p class="card-text">${requestSex}: ${req.sex}</p>
                                <p class="card-text">${requestBirthDate}: <fmt:formatDate pattern = "dd.MM.yyyy" value = "${req.birthDate}"/></p>
                                <p class="card-text">${requestNationality}: ${fn:toUpperCase(req.nationality)}</p>
                                <div class="form-group form-inline">
                                    <form method="POST" action="${declineRequestCommand}${requestId}${req.id}">
                                        <input type="submit" class="btn btn-danger" value="${bDecline}"/>
                                    </form>
                                    <form method="POST" action="${acceptRequestCommand}${requestId}${req.id}">
                                        <input type="submit" class="btn btn-success" value="${bAccept}"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
