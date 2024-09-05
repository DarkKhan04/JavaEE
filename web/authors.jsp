<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container">
    <div class = "row mt-3">
        <div class="col-12">
            <%
                ArrayList<Author> authors = (ArrayList<Author>) request.getAttribute("authors");
                if(currentUser!=null && currentUser.getRole_id()==1){
            %>
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addAuthor">
                + Add Author
            </button>

            <div class="modal fade" id="addAuthor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Add Book</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="/add-author" method="post">
                                <div class="row">
                                    <div class="col-12">
                                        <label>FIRST NAME : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="firstName">
                                    </div>
                                </div>

                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>LAST NAME : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="lastName">
                                    </div>
                                </div>

                                <div class="row mt-3" >
                                    <div class="col-12">
                                        <label>INSTAGRAM : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="instagram">
                                    </div>
                                </div>

                                <div class="row mt-3">
                                    <div class="col-12">
                                        <button class="btn btn-success">ADD AUTHOR</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>

            <table class="table table-striped table-hover mt-3">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>FIRSTNAME</th>
                    <th>LAST NAME</th>
                    <th>INSTAGRAM</th>
                    <th style="width: 10%">DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%

                    if(authors != null){
                        for (Author a : authors){

                %>
                <tr>
                    <td><%=a.getId()%></td>
                    <td><%=a.getFirstName()%></td>
                    <td><%=a.getLastName()%></td>
                    <td><%=a.getInstagram()%></td>
                    <td>
                        <a class="btn btn-success btn-sm" href="/">DETAILS</a>
                    </td>
                </tr>

                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
