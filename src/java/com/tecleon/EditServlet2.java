package com.tecleon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String controlNum = request.getParameter("controlNum");
        int id = Integer.parseInt(controlNum);
        String studentName = request.getParameter("studentName");
        String carrer = request.getParameter("carrer");
        String email = request.getParameter("email");
        String semester= request.getParameter("semester");

        Student e = new Student();
        e.setControlNum(id);
        e.setStudentName(studentName);
        e.setCarrer(carrer);
        e.setEmail(email);
        e.setSemester(Integer.parseInt(semester));

        int status = StudentDAO.update(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}
