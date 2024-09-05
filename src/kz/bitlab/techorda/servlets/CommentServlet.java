package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Comment;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.News;
import kz.bitlab.techorda.db.User;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/add-comment")
public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null){

            Long newsId = Long.parseLong(request.getParameter("id"));
            String commentText = request.getParameter("comment");

            News news = (News) DBConnection.getNewsById(newsId);

            if(news!=null) {

                Comment comment = new Comment();
                comment.setNews(news);
                comment.setUser(user);
                comment.setComment(commentText);

                DBConnection.addComment(comment);

                response.sendRedirect("/news-details?id=" + newsId);

            }else{
                response.sendRedirect("/");
            }
        }else{
            response.sendRedirect("/login");
        }
    }
}
