<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Books</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class = "row">
        <div class = "col-12 mx-auto">
            <h1>HELLO <%=currentUser.getFull_name()%></h1>
        </div>
    </div>
</div>
</body>
</html>