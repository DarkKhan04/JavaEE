package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("book_id"));
        }catch (Exception e){}

        Book book = DBConnection.getBook(id);


        ArrayList<Author> authors = DBConnection.getAuthors();
        req.setAttribute("authors", authors);

        req.setAttribute("book", book);
        req.getRequestDispatcher("/details.jsp").forward(req, resp);

    }
}
