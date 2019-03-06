<%--@elvariable id="errorAddNews" type="String"--%>
<%@include file="../jspf/import.jspf" %>
<%@ taglib prefix="md" uri="dateTag" %>
<html>
<head>
    <title>${addNews}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
<%@include file="../jspf/header.jspf" %>
<div class="container">
    <div class="row justify-content-center align-items-center" style="height:50vh">
        <div>
            <div class="card card-signin flex-row my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">${addNews}</h5>
                    <form class="form-signin" name="registerForm" method="POST" action="controller">
                        <input type="hidden" name="command" value="add_news"/>
                        <div class="form-row justify-content-center">
                            <div class="col-2">
                                ${defaultLang}:
                            </div>
                            <div class="col-3">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="default_lang" id="ru" value="ru_text" checked>
                                    <label class="form-check-label" for="ru">${ruLang}</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="default_lang" id="en" value="en_text">
                                    <label class="form-check-label" for="en">${enLang}</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-row justify-content-center">
                            <label for="date" class="col-2 col-form-label">${date}</label>
                            <div class="col-3">
                                <input class="form-control" type="date" value="<md:date/>" id="date" name="date" required>
                            </div>
                        </div>
                        <hr>
                        <div class="form-label-group">
                            <input type="text" id="ru_title" name="ru_title" class="form-control" placeholder="${ruTitle}" required>
                            <label for="ru_title">${ruTitle}</label>
                        </div>
                        <div class="form-label-group">
                            <p>${ruText}:</p>
                            <textarea id="ru_text" name="ru_text" class="form-control" rows="5" cols="100" title="${ruText}" required></textarea>
                        </div>
                        <hr>
                        <div class="form-label-group">
                            <input type="text" id="en_title" name="en_title" class="form-control" placeholder="${enTitle}" required>
                            <label for="en_title">${enTitle}</label>
                        </div>
                        <div class="form-label-group">
                            <p>${enText}:</p>
                            <textarea id="en_text" name="en_text" class="form-control" rows="5" cols="100" title="${enText}" required></textarea>
                        </div>

                        <c:if test="${errorAddNews != null}">
                            <div>
                                <h6 class="text-center"><fmt:message key="${errorAddNews}" bundle="${mess}"/></h6>
                            </div>
                        </c:if>
                        <button class="btn btn-lg btn btn-dark btn-block" type="submit">${bAddNews}</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
