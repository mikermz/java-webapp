package com.tecleon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            UserDAO us = new UserDAO();
            ResultSet resultado = us.query("SELECT userName, userPassword from user where userName = '" + name + "' and userPassword = '" + password + "'");
            resultado.last();
            if (resultado.getRow() > 0) {
                out.print("You are successfully logged in!");
                out.print("<br>Welcome, " + name);
                HttpSession session = request.getSession();
                session.setAttribute("name", name);

            } else {
                out.print("sorry, username or password error!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.close();
    }

}
