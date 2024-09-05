package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String full_name = req.getParameter("full_name");

        User user = new User();
        boolean isRegistered = DBConnection.checkUser(email);
        if(!isRegistered){
            user.setEmail(email);
            user.setPassword(password);
            user.setFull_name(full_name);
            user.setRole_id(2);
            DBConnection.addUser(user);

            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            resp.sendRedirect("/profile");
        }else{
            resp.sendRedirect("/login?already registered");
        }
    }
}
