package net.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
//        response.addHeader("name", "java");
//        response.addHeader("xxx","spring");
//        response.setHeader("age","23");
//        response.setStatus(200);

        response.setHeader("Content-Type","text/html;charset=utf-8");

        String data="小滴课堂Java高级工程师成长系统";


        PrintWriter printWriter=response.getWriter();


        printWriter.write(data);


    }
}
