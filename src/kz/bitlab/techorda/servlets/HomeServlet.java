package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.DBManager;

import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.awt.Color.red;

@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String text = (String) session.getAttribute("username");

        ArrayList<Book> books = DBConnection.getBooks();
        request.setAttribute("books", books);

        ArrayList<Author> authors = DBConnection.getAuthors();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("/books.jsp").forward(request, response);

    }
}
