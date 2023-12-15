package com.example.lab7_ctpweb;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "secondServlet", value = "/index")
public class secondServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    public void destroy() {
    }
}