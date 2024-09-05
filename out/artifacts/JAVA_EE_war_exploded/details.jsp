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
<div class = "container mt-3">
    <%
        Book book = (Book) request.getAttribute("book");
        if(book!=null){
    %>
    <div class="row">
        <div class="col-6 mx-auto">
            <div class="row mt-2">
                <div class="col-12">
                    <label>NAME : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" readonly value="<%=book.getName()%>">
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12">
                    <label>AUTHOR : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" readonly value="<%=book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()%>">
                </div>
            </div>

            <div class="row mt-3" >
                <div class="col-12">
                    <label>GENRE : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12" >
                    <input type="text" class="form-control" readonly value="<%=book.getGenre()%>">
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12">
                    <label>PRICE : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="number" class="form-control" readonly value="<%=book.getPrice()%>">
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12">
                    <label>DESCRIPTION : </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <textarea class="form-control" readonly rows="8"><%=book.getDescription()%></textarea>
                </div>
            </div>
            <%
                if(currentUser!=null){
                    if(currentUser.getRole_id()==1){
            %>
            <div class="row mt-3 mb-2">
                <div class="col-12">
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editBook">
                        Edit Book
                    </button>
                    <button type="button" class="btn btn-danger btn-sm ms-1" data-bs-toggle="modal" data-bs-target="#deleteBook">
                        Delete Book
                    </button>
                </div>
            </div>
            <%}%>
            <form action="/delete-book" method="post">
                <input type="hidden" value="<%=book.getId()%>" name="book_id">
                <div class="modal fade" id="deleteBook" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5">Confirm Delete</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h5 class="text-center">Are you sure?</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                                <button class="btn btn-danger" data-bs-dismiss="modal">YES</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <div class="modal fade" id="editBook" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Edit Book</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form action="save-book" method="post">
                                <input type="hidden" name="book_id" value="<%=book.getId()%>">
                                <div class="row">
                                    <div class="col-12">
                                        <label>NAME : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="text" class="form-control" name="book_name" value="<%=book.getName()%>">
                                    </div>
                                </div>

                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>AUTHOR : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <select class="form-select" name="book_author">
                                            <%
                                                ArrayList<Author> authors = (ArrayList<Author>) request.getAttribute("authors");
                                                if(authors!=null) {
                                                    for(Author author : authors){
                                            %>
                                            <option <%=(author.getId()==book.getAuthor().getId()?"selected":"")%> value="<%=author.getId()%>"><%=author.getFirstName() + " " + author.getLastName()%></option>
                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mt-3" >
                                    <div class="col-12">
                                        <label>GENRE : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12" >
                                        <select class="form-select" name="book_genre">
                                            <option <%=(book.getGenre().equalsIgnoreCase("FANTASY")?"selected":"")%> >FANTASY</option>
                                            <option <%=(book.getGenre().equalsIgnoreCase("HORROR")?"selected":"")%> >HORROR</option>
                                            <option <%=(book.getGenre().equalsIgnoreCase("DRAMA")?"selected":"")%> >DRAMA</option>
                                            <option <%=(book.getGenre().equalsIgnoreCase("ROMAN")?"selected":"")%> >ROMAN</option>
                                            <option <%=(book.getGenre().equalsIgnoreCase("BIOGRAPHY")?"selected":"")%> >BIOGRAPHY</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>PRICE : </label>
                                    </div>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-12">
                                        <input type="number" class="form-control" name="book_price" value="<%=book.getPrice()%>">
                                    </div>
                                </div>

                                <div class="row mt-3">
                                    <div class="col-12">
                                        <label>DESCRIPTION : </label>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <textarea class="form-control" name="description"><%=book.getDescription()%></textarea>
                                    </div>
                                </div>
                                <button class="btn btn-primary mt-2">EDIT</button>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>


        </div>
    </div>
    <%}else{%>
    <h3 class="text-center">Book Not Found</h3>
    <%}%>
</div>
</body>
</html>
