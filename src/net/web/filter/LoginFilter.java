package net.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//@WebFilter(filterName = "loginFilter",urlPatterns = "/user/*",initParams  ={
//        @WebInitParam(name = "encoding",value = "UTF-8"),
//        @WebInitParam(name = "loginPage",value = "/login.jsp"),
//} )
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter init");
        this.filterConfig=filterConfig;
        this.encoding= filterConfig.getInitParameter("encoding");
        this.loginPage=filterConfig.getInitParameter("loginPage");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter");

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;

        if(httpServletRequest.getSession().getAttribute("logunUser")!=null){

            chain.doFilter(request,response);
        }else{
            httpServletRequest.setAttribute("msg","非法访问，请登录");
            httpServletRequest.getRequestDispatcher(loginPage).forward(httpServletRequest,httpServletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }
}
