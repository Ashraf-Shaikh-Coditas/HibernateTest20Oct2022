package com.servlet;

import com.bean.Employee;
import com.dao.EmployeeDaoImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int employeeId = Integer.parseInt(req.getParameter("id"));
        String employeeName = req.getParameter("name");
        long number = Long.parseLong(req.getParameter("number"));

        Employee employee = new Employee(employeeId,employeeName,number);

        int i = new EmployeeDaoImplementation().addEmployee(employee);

        if(i>0) {
            out.println("<h2>Employee Added Successfully <h2>");
        } else {
            out.println("<h2>Try Again <h2>");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req,resp);



    }
}
