package com.tecleon;
import com.tecleon.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Update Student</h1>");
        String controlNum = request.getParameter("controlNum");
        int id = Integer.parseInt(controlNum);

        Student s = StudentDAO.getStudentById(id);

        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr><td></td><td><input type='hidden' name='controlNum' value='" + s.getControlNum() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='studentName' value='" + s.getStudentName() + "'/></td></tr>");
        out.print("<tr><td>Carrer:</td><td><input type='text' name='carrer' value='" + s.getCarrer()+ "'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + s.getEmail() + "'/></td></tr>");
        out.print("<tr><td>Semester:</td><td>");
        out.print("<select name='semester' style='width:150px'>");
        out.print("<option>1</option>");
        out.print("<option>2</option>");
        out.print("<option>3</option>");
        out.print("<option>4</option>");
        out.print("<option>5</option>");
        out.print("<option>6</option>");
        out.print("<option>7</option>");
        out.print("<option>8</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
    }
}
