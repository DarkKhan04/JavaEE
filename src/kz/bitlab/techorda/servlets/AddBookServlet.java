package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;


@WebServlet(value = "/add-book")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String genre = request.getParameter("book_genre");
        String price = request.getParameter("book_price");
        String description = request.getParameter("description");

        double bookPrice = Double.parseDouble(price);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(bookPrice);
        book.setGenre(genre);
        book.setDescription(description);

        DBManager.addBook(book);

        response.sendRedirect("/");
    }
}
