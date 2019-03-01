<%--@elvariable id="errorRequest" type="String"--%>
<html>
<head>
    <title>${addRequest}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css"/>
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css"/>
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
                    <h5 class="card-title text-center">${addRequest}</h5>
                    <form action="controller" method="POST" enctype="multipart/form-data" class="form-signin" name="registerForm" >
                        <input type="hidden" name="command" value="add_request"/>
                        <div class="form-label-group">
                            <input type="text" id="request_name" name="request_name" class="form-control" placeholder="${requestName}"/>
                            <label for="request_name">${requestName}</label>
                        </div>

                        <input type="file" name="request_file" id="uploadFile"/>

                        <c:if test="${errorRequest != null}">
                            <div>
                                <h6 class="text-center"><fmt:message key="${errorRequest}" bundle="${mess}"/></h6>
                            </div>
                        </c:if>
                        <button class="btn btn-lg btn btn-dark btn-block" type="submit">${bAddRequest}</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
