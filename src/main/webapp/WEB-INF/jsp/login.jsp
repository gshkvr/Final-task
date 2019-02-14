<%--@elvariable id="errorLoginPassMessage" type="String"--%>
<%--@elvariable id="wrongAction" type="String"--%>
<%--@elvariable id="nullPage" type="String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
        <script src="webjars/jquery/3.3.1/jquery.js"></script>
        <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center align-items-center" style="height:100vh">
                <div class="col-4">
                    <div class="card">
                        <div class="card-body">
                            <form name="loginForm" method="POST" action="controller">
                                <input type="hidden" name="command" value="login" />
                                <div class="form-group">
                                    <input type="text" class="form-control" name="login" placeholder="login" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="password" value="">
                                    ${errorLoginPassMessage}
                                </div>
                                <button type="submit" class="btn btn-primary">Log In</button>
                                ${wrongAction}
                                ${nullPage}
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>