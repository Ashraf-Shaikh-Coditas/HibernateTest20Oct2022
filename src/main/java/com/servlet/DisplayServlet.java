package com.servlet;

import com.bean.Employee;
import com.dao.EmployeeDaoImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Display")
public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Employee> employeeList = new EmployeeDaoImplementation().getAllEmployees();

        out.println("USER DATA : ");

        out.println("<table border=4 px >" +
                "  <tr>" +
                "    <th>Id</th><th>Employee Name</th><th>Employee Number </th>\n" +
                "  </tr>");


        for (int i = 0 ; i < employeeList.size();i++)
        {
            Employee employee = employeeList.get(i);
            out.println("<tr><td>" + employee.getEmployeeId() + "</td>" +
                    "<td>" + employee.getEmployeeName() + "</td>" +
                    "<td>" + employee.getEmployeeNumber() + "</td>" +
                    "</tr>"
            );



        }
        out.println("</table>");
        out.println("<a href='index.jsp'><input type='button' value ='Back To Home'></a>");
    }



}