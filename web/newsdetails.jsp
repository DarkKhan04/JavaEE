<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.News" %>
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
                        News news = (News) request.getAttribute("news");
                        if(news!=null){
                    %>
                    <div class="p-5 mb-3" style="background-color: #dee1df;">
                        <h3><%=news.getTitle()%></h3>
                        <p><%=news.getContent()%></p>
                        <p>
                            Posted by <strong><%=news.getUser().getFull_name()%></strong>
                            at <strong><%=news.getPostDate()%></strong>
                        </p>
                        <%
                            if(currentUser!=null && currentUser.getId() == news.getUser().getId()){
                        %>
                        <div>
                            <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editNews">
                                Edit
                            </button>


                            <div class="modal fade" id="editNews" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/save-news" method="post">
                                            <input type="hidden" name="id" value="<%=news.getId()%>">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-12">
                                                        <label>
                                                            TITLE :
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="row mt-2">
                                                    <div class="col-12">
                                                        <input type="text" class="form-control" name="title" required placeholder="<%=news.getTitle()%>" value="<%=news.getTitle()%>">
                                                    </div>
                                                </div>
                                                <div class="row mt-3">
                                                    <div class="col-12">
                                                        <label>
                                                            CONTENT
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="row mt-2">
                                                    <div class="col-12">
                                                        <textarea class="form-control" name="content" rows="10" placeholder="<%=news.getContent()%>" required><%=news.getContent()%></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                <button type="submit" class="btn btn-success">Update</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <%
                        if(currentUser!=null){
                    %>
                    <div>
                        <form action="/add-comment" method="post">
                            <input type="hidden" name="id" value="<%=news.getId()%>">
                            <div class="row">
                                <div class="col-12">
                                    <textarea class="form-control" name="comment"></textarea>
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-12">
                                    <button class="btn btn-success btn-sm">Add Comment</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <%}%>
                    <div class="row mt-3">
                        <div class="col-12">
                            <div class="list-group">
                                <%
                                    ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                                    System.out.println(comments);
                                    if(comments!=null){
                                        for(Comment c : comments){
                                %>
                                            <a href="JavaScript:void(0)" class="list-group-item list-group-item-action mt-1">
                                                <div class="d-flex w-100 justify-content-between">
                                                    <h5 class="mb-1"><%=c.getUser().getFull_name()%></h5>
                                                    <small class="text-body-secondary"><%=c.getPostDate()%></small>
                                                </div>
                                                <p class="mb-1"><%=c.getComment()%></p>
                                            </a>
                                <%
                                        }
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>