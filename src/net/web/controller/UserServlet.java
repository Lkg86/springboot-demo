package net.web.controller;
import net.web.domain.User;
import net.web.servise.UserService;
import net.web.servise.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/userServlet")
@WebServlet(name="userServlet",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method=req.getParameter("method");
        if(method.equals("findById")){
            String idStr=req.getParameter("id");
            int userId=Integer.parseInt(idStr);
            User user= userService.findById(userId);
            System.out.println(user.toString());

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String userName=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        if (userName.equals("xdclass")&&pwd.equals("123")){
            resp.getWriter().write("登录成功");

        }else {
            resp.getWriter().write("账号密码错误");
        }


    }
}
