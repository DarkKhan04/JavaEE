package kz.bitlab.techorda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task6")
public class Task6Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<form action = '/task6-process' method = 'get'>");
        out.print("<input type = 'text' name = 'name'> FULL NAME<br><br>");
        out.print("<input type = 'number' name = 'exam'> POINTS<br><br>");
        out.print("<button>SUBMIT EXAM</button>");

        out.print("</form>");
    }
}
