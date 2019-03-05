<%--@elvariable id="missingPersons" type="java.util.List"--%>
<%--@elvariable id="user" type="String"--%>
<%@include file="../jspf/import.jspf" %>
<html>
<head>
    <title>${missing}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
</head>
<body>

<%@include file="../jspf/header.jspf" %>
<fmt:message bundle="${mess}" key="missing.title" var="title"/>
<div class="container" style="width:60%">
    <c:choose>
        <c:when test="${missingPersons.size() == 0}">
            <h1 class="my-4">${title}
                <small>${noPersons}</small>
            </h1>
        </c:when>
        <c:otherwise>
            <h1 class="my-4" align="center">
                    ${title}
            </h1>
            <div class="row">
                <c:forEach items="${missingPersons}" var="person">
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <div class="card h-auto">
                            <img class="card-img-top" src="${pageContext.request.contextPath}${person.fileLink}" alt="">
                            <div class="card-body">
                                <h4 class="card-title">${person.fullName}</h4>
                                <p class="card-text">${requestSex}: ${person.sex}</p>
                                <p class="card-text">${requestBirthDate}: <fmt:formatDate pattern = "dd.MM.yyyy" value = "${person.birthDate}"/></p>
                                <p class="card-text">${requestNationality}: ${fn:toUpperCase(person.nationality)}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
    <hr>
</div>
</body>
</html>

