package net.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener sessionCreated");
        ServletContext servletContext=se.getSession().getServletContext();

        Integer onlineNum=(Integer) servletContext.getAttribute("onlineNum");

        servletContext.setAttribute("onlineNum",++onlineNum);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener sessionDestroyed");
        ServletContext servletContext=se.getSession().getServletContext();

        Integer onlineNum=(Integer) servletContext.getAttribute("onlineNum");

        servletContext.setAttribute("onlineNum",--onlineNum);

    }
}
