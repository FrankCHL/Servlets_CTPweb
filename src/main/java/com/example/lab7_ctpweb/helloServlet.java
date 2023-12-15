package com.example.lab7_ctpweb;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class helloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        HttpSession session = request.getSession();

        String text = (String) session.getAttribute("text");
        text += request.getParameter("name");
        System.out.println(text);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<textarea rows=\"4\" cols=\"50\">" + text + "</textarea>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String text = request.getParameter("name");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);
    }

    public void destroy() {
    }
}