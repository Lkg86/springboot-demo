package net.web.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class FileDownioad  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file=request.getParameter("file");

        String path = request.getServletContext().getRealPath("/file/");

        String filepath=path+file;

        FileInputStream fis =new FileInputStream(filepath);

        request.setCharacterEncoding("utf-8");


        response.setHeader("Content-Disposition","attachment;filename="+file);

        ServletOutputStream out= response.getOutputStream();

        byte[] buf =new byte[1024];

        int lent;

        while ((lent=fis.read(buf))!=-1){
            out.write(buf,0,lent);
        }

        out.close();
    }
}
