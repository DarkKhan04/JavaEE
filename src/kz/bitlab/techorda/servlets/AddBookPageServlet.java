package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/add-book-page")
public class AddBookPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");

        if (user != null) {
            if(user.getRole_id()==1) {
                ArrayList<Author> authors = DBConnection.getAuthors();
                req.setAttribute("authors", authors);
                req.getRequestDispatcher("/addbook.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/403.jsp").forward(req, resp);
            }
        }else{
            resp.sendRedirect("/login");
        }
    }
}
