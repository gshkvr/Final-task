<%--@elvariable id="allNews" type="java.util.List"--%>
<%--@elvariable id="role" type="String"--%>
<%@include file="../jspf/import.jspf" %>
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
                    <c:if test="${role == 'admin'}">
                        <form method="POST" action="${editNewsPageCommand}${newsId}${news.id}">
                            <input type="submit" class="btn btn-secondary btn-sm" value="${bEditNews}"/>
                        </form>
                    </c:if>
                    ${news.ruText == '' ? news.defaultText : news.ruText}
                </div>
            </c:when>
            <c:when test="${locale == localeEn}">
                <div>
                    <h3>${news.enTitle}</h3>
                    <small><fmt:formatDate pattern = "dd.MM.yyyy" value = "${news.date}"/></small>
                    <c:if test="${role == 'admin'}">
                        <form method="POST" action="${editNewsPageCommand}${newsId}${news.id}">
                            <input type="submit" class="btn btn-secondary btn-sm" value="${bEditNews}"/>
                        </form>
                    </c:if>
                    ${news.enText == '' ? news.defaultText : news.enText}
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h3>${news.defaultTitle}</h3>
                    <small><fmt:formatDate pattern = "dd.MM.yyyy" value = "${news.date}"/></small>
                    ${news.defaultText}
                </div>
            </c:otherwise>
        </c:choose>
    <hr>
    </c:forEach>

</div>

</body>
</html>
