<%--@elvariable id="errorLogin" type="String"--%>
<%@include file="../jspf/import.jspf" %>
<html>
    <head>
        <title>${login}</title>
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
                            <h5 class="card-title text-center">${login}</h5>
                            <form class="form-signin" name="loginForm" method="POST" action="controller">
                                <input type="hidden" name="command" value="login"/>
                                <div class="form-label-group">
                                    <input type="text" id="login" name="login" class="form-control" placeholder="${login}">
                                    <label for="login">${login}</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="password" id="password" name="password" class="form-control" placeholder="${password}">
                                    <label for="password">${password}</label>
                                </div>
                                <c:if test="${errorLogin != null}">
                                    <div>
                                        <h6 class="text-center"><fmt:message key="${errorLogin}" bundle="${mess}"/></h6>
                                    </div>
                                </c:if>
                                <button class="btn btn-lg btn btn-dark btn-block" type="submit">${bLogin}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>