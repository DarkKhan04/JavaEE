package kz.bitlab.techorda.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/todo-task5")
public class Task5Process extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        String mainText = "Hello ";
        if(age >= 18) mainText += "Dear ";
        else mainText += "Dude ";
        if(gender.equals("m")) mainText += "Mister ";
        else mainText += "Miss ";
        mainText += name;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>"+mainText+"</h1>");
    }
}
