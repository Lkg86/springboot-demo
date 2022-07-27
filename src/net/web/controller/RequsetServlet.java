package net.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/request")
public class RequsetServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        //客户端请求信息
        System.out.println("应⽤用上下⽂文路路径getContextPath="+request.getContextPath());
        System.out.println("客户端发出请求时的完整URLgetRequestURL="+request.getRequestURL()) ;
        System.out.println("请求⾏行行中的资源名部分getRequestURI="+request.getRequestURI()) ;
        System.out.println("请求⾏行行中的参数部分getQueryString="+request.getQueryString()) ;
        System.out.println("发出请求的客户机的IP地址getRemoteAddr="+request.getRemoteAddr()) ;
        System.out.println("客户机发请求使⽤用的⽹网络端⼝口号 getRemotePort="+request.getRemotePort()) ;
        //获取请求头
        System.out.println("获取请求头getHeader(Accept)="+request.getHeader("Accept")) ;
        //获取请求参数
        System.out.println("客户端请求参数getParameter="+request.getParameter("userName"));
        String[] sport = request.getParameterValues("sport");
        System.out.println("客户端请求参数列列表,多个值getParameterValues="+sport.toString());
        Map<String,String[]> map = request.getParameterMap();
        System.out.println("客户端请求参数封装成的map类型 getParameterMap="+map.toString());

        request.setAttribute("name","jack");

    }
}
