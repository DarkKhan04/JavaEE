<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Detka</title>
    <link rel="stylesheet" type = "text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css
">
</head>
<body>
    <div class = "container">
        <div class = "row">
            <div class = "col-9 mx-auto">
                <%
                    for (int i = 0; i < 20; i++) {
                %>
                <div class="card">
                    <img src="https://static.toiimg.com/thumb/resizemode-4,width-1280,height-720,msid-102827471/102827471.jpg" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">Darkhan Amandyk</h5>
                        <p class="card-text">Full stack developer</p>
                        <a href="#" class="btn btn-primary">Like</a>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
</body>
</html>
