package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.News;
import kz.bitlab.techorda.db.User;

import java.io.IOException;


@WebServlet(value = "/add-news")
public class ToAddNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null){
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setUser(user);
            DBConnection.addNews(news);

            response.sendRedirect("/add-news-page");

        }else{
            response.sendRedirect("/login");
        }
    }
}
