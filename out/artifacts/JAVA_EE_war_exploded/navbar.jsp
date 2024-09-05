<%@ page import="kz.bitlab.techorda.db.User" %>
<%@ page import="kz.bitlab.techorda.db.Comment" %>
<%
    User currentUser = (User) session.getAttribute("currentUser");
%>

<div class="container">
    <nav class="navbar navbar-expand-lg bg-success navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Book Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/">Home</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/authors">Authors</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/news">All News</a>
                    </li>
                    <%
                        if(currentUser!=null){
                            if(currentUser.getRole_id()==1){
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="/add-book-page">Add Book</a>
                        </li>
                    <%}%>
                        <li class="nav-item">
                            <a class="nav-link" href="/add-news-page">Add News</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%=currentUser.getFull_name()%>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/profile">Profile</a></li>
                                <li><a class="dropdown-item" href="/">Settings</a></li>
                                <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#deleteUser">Delete User</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/logout">Log out</a></li>
                            </ul>
                        </li>
                    <form action="/delete-user" method="post">
                        <div class="modal fade" id="deleteUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                        <button type="submit" class="btn btn-danger">YES</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%
                        }else{
                    %>
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register">Register</a>
                        </li>
                    <%}%>
                </ul>
            </div>
        </div>
    </nav>
</div>
