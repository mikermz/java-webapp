package com.tecleon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='profile.html'>Add New Student</a>");
        out.println("<h1>Students List</h1>");

        List<Student> list = StudentDAO.getAllStudents();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>ControlNumber</th><th>Name</th><th>Carrer</th><th>Email</th><th>Semester</th><th>Edit</th><th>Delete</th></tr>");
        for (Student e : list) {
            out.print("<tr><td>" + e.getControlNum() + "</td><td>" + e.getStudentName() + "</td><td>" + e.getCarrer() + "</td><td>" + e.getEmail() + "</td><td>" + e.getSemester() + "</td><td><a href='EditServlet?controlNum=" + e.getControlNum() + "'>edit</a></td>  <td><a href='DeleteServlet?controlNum=" + e.getControlNum() + "'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
