package net.web.controller;

import net.web.domain.Config;
import net.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

//        Config config= (Config) req.getServletContext().getAttribute("config");
//
//        System.out.println(config.getTopic());
//        System.out.println("DispatchServlet doGet");

//        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
//        req.getRequestDispatcher("request").forward(req,resp);
//            req.setAttribute("name","class.net");
//        User user=new User();
//        user.setHost("https://xdclass.net");
//        user.setId(1);
//        user.setName("老王");
//        req.setAttribute("user",user);
//        req.setAttribute("name","jack");
//        req.getRequestDispatcher("index.jsp").forward(req,response);
//       response.sendRedirect("index.jsp");
//            response.sendRedirect("https://xdclass.net");
    }
}
