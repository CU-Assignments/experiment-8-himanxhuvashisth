
package com.example.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

            String query = (id != null && !id.isEmpty()) ?
                "SELECT * FROM employees WHERE id=?" :
                "SELECT * FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            if (id != null && !id.isEmpty()) {
                ps.setInt(1, Integer.parseInt(id));
            }

            ResultSet rs = ps.executeQuery();
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Position</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" +
                            rs.getString("name") + "</td><td>" +
                            rs.getString("position") + "</td></tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
