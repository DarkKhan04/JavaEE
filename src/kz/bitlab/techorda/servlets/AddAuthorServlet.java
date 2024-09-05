package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;


@WebServlet(value = "/add-author")
public class AddAuthorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");

        if (user != null && user.getRole_id()==1) {

            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String instagram = request.getParameter("instagram");

            Author author = new Author();
            author.setFirstName(firstname);
            author.setLastName(lastname);
            author.setInstagram(instagram);

            DBConnection.addAuthor(author);


            response.sendRedirect("/authors");
        }else{
            response.sendRedirect("/login");
        }
    }
}
