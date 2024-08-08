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
        <div class="container">
            <div class = "row mt-3">
                <div class="col-12">
                    <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        + Add Book
                    </button>

                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Add Book</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%@include file="addform.jsp"%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <table class="table table-striped table-hover mt-3">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NAME</th>
                                <th>AUTHOR</th>
                                <th>GENRE</th>
                                <th>PRICE</th>
                                <th style="width: 10%">DETAILS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
                                if(books != null){
                                    for (Book b : books){

                            %>
                            <tr>
                                <td><%=b.getId()%></td>
                                <td><%=b.getName()%></td>
                                <td><%=b.getAuthor()%></td>
                                <td><%=b.getGenre()%></td>
                                <td><%=b.getPrice()%></td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="/details?book_id=<%=b.getId()%>">DETAILS</a>
                                </td>
                            </tr>
                            <%}}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
