package com.print;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class NormalJavaClass extends HttpServlet {
    private String fname;
    private String lname;
    private String carBrand;
    private String[] carModel;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        fname = request.getParameter("name");

        HttpSession httpSession = request.getSession();
        ServletContext servletContext = request.getServletContext();

        if (fname != null) {
            httpSession.setAttribute("firstName", fname);

            servletContext.setAttribute("context", fname);
        }

        printWriter.println("class NormaljavaClass: getMethod: name:" + fname + "\tSession Name: "
                + (String) httpSession.getAttribute("firstName"));
        printWriter.println("\tContext:" + (String) servletContext.getAttribute("context"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        fname = request.getParameter("fname");
        lname = request.getParameter("lname");
        carBrand = request.getParameter("cars");
        carModel = request.getParameterValues("model");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("First Name:" + fname + " Last Name:" + lname + "Manufacturer:" + carBrand);

        for (String item : carModel)
            printWriter.println("Model:" + item);

    }
}
