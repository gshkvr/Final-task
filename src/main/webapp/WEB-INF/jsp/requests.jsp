<%--@elvariable id="errorRegistration" type="String"--%>
<%--@elvariable id="allRequests" type="java.util.List"--%>
<html>
<head>
    <title>${register}</title>
    <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.css">
    <link rel="stylesheet" href="webjars/font-awesome/5.7.2/css/all.css">
    <script src="webjars/jquery/3.3.1/jquery.js"></script>
    <script src="webjars/bootstrap/4.2.1/js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
<%@include file="../jspf/header.jspf" %>
<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4">Page Heading
        <small>Secondary Text</small>
    </h1>

    <div class="row">
        <div class="col-lg-4 col-sm-6 mb-4">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}/images/persons/missing.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Project One</a>
                    </h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
                </div>
            </div>
        </div>
        <c:forEach items="${allRequests}" var="req">
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="${pageContext.request.contextPath}${req.fileLink}" alt=""></a>
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">${req.name}</a>
                        </h4>
                        <p class="card-text">${req.fileLink}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- /.row -->

    <!-- Pagination -->
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
