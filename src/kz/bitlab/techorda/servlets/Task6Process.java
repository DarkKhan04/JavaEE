package kz.bitlab.techorda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task6-process")
public class Task6Process extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int exam = Integer.parseInt(request.getParameter("exam"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String mainText = name + " got \"";

        if(exam <= 100 && exam >= 90) mainText += "A\"";
        else if(exam < 90 && exam >= 75) mainText += "B\"";
        else if(exam < 75 && exam >= 60) mainText += "C\"";
        else if(exam < 59 && exam >= 50) mainText += "D\"";
        else mainText += "F\"";
        mainText += " for exam!";
        out.print("<h1>"+mainText+"</h1>");
    }
}
