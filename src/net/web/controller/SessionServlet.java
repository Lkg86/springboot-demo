package net.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session_servlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession= request.getSession();

        System.out.println("sessionid="+httpSession.getId());

        System.out.println("creationTime="+httpSession.getCreationTime());

        System.out.println("isNew="+httpSession.isNew());

        httpSession.setAttribute("name","小滴课堂 xdclass.net");
    }
}
