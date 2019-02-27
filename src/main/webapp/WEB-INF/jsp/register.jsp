<html>
    <head>
        <title>${register}</title>
        <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
        <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
        <script src="webjars/jquery/3.3.1/jquery.js"></script>
        <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
        <style><%@include file='../../css/register.css' %></style>
    </head>
    <body>
        <%@include file="../jspf/header.jspf" %>
        <div class="container">
            <div class="row justify-content-center align-items-center" style="height:50vh">
                <div>
                    <div class="card card-signin flex-row my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">${register}</h5>
                            <form class="form-signin">
                                <div class="form-label-group">
                                    <input type="text" id="input_login" class="form-control" placeholder="${login}" required>
                                    <label for="input_login">${login}</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="email" id="input_email" class="form-control" placeholder="${email}" required>
                                    <label for="input_email">${email}</label>
                                </div>
                                <hr>
                                <div class="form-label-group">
                                    <input type="password" id="input_password" class="form-control" placeholder="${password}" required>
                                    <label for="input_password">${password}</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="password" id="input_confirm_password" class="form-control" placeholder="${confirmPassword}" required>
                                    <label for="input_confirm_password">${confirmPassword}</label>
                                </div>
                                <c:if test="${errorRegistration != null}">
                                    <div>
                                        <h6 class="text-center"><fmt:message key="${errorRegistration}" bundle="${mess}"/></h6>
                                    </div>
                                </c:if>
                                <button class="btn btn-lg btn btn-dark btn-block" type="submit">${bRegister}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
