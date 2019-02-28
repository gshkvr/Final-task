<html>
<head>
    <title>${news}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
</head>
<body>

<%@include file="../jspf/header.jspf" %>

<fmt:message bundle="${mess}" key="news.title" var="title"/>

<div class="container" style="width:60%">
    <h1 class="my-4" align="center">
        <small>${title}</small>
    </h1>

    <c:forEach items="${allNews}" var="news">
        <c:choose>
            <c:when test="${locale == localeRu}">
                <div>
                    <h3>${news.ruTitle == '' ? news.defaultTitle : news.ruTitle}</h3>
                    <small><fmt:formatDate pattern = "dd.MM.yyyy" value = "${news.date}"/></small>
                    <p>${news.ruText == '' ? news.defaultText : news.ruText}</p>
                </div>
            </c:when>
            <c:when test="${locale == localeEn}">
                <div>
                    <h3>${news.enTitle}</h3>
                    <small><fmt:formatDate pattern = "dd.MM.yyyy" value = "${news.date}"/></small>
                    <p>${news.enText}</p>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h3>${news.defaultTitle}</h3>
                    <small><fmt:formatDate pattern = "dd.MM.yyyy" value = "${news.date}"/></small>
                    <p>${news.defaultText}</p>
                </div>
            </c:otherwise>
        </c:choose>
    <hr>
    </c:forEach>

    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>


</div>

</body>
</html>
