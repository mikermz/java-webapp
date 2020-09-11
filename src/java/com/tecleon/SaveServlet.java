package com.tecleon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String studentName = request.getParameter("studentName");
        String controlNum = request.getParameter("controlNum");
        String carrer = request.getParameter("carrer");
        String  email= request.getParameter("email");
        String semester = request.getParameter("semester");

        Student s = new Student();
        s.setStudentName(studentName);
        s.setControlNum(Integer.parseInt(controlNum));
        s.setCarrer(carrer);
        s.setEmail(email);
        s.setSemester(Integer.parseInt(semester));

        int status = StudentDAO.save(s);
        if (status > 0) {
            out.print("<p>Record saved successfully! </p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

}
