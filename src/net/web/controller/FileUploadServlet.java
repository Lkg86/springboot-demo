package net.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username= request.getParameter("username");
        System.out.println("username="+username);

        Part part=request.getPart("img");

//        String originalName=part.getName();
//
//        System.out.println("formName="+originalName);

        String header= part.getHeader("content-disposition");

//        System.out.println(header);

        String realFileName=header.substring(header.indexOf("filename=")+10,header.length()-1);

        System.out.println(realFileName);

        InputStream is =part.getInputStream();

        String dir= this.getServletContext().getRealPath("/file");

        File dirFile=new File(dir);

        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

        String uniqueName= UUID.randomUUID()+realFileName;
//        File file =new File(dir,realFileName);
        File file =new File(dir,uniqueName);
        FileOutputStream out =new FileOutputStream(file);

        byte [] buf =new byte[1024];

        int len;

        while ((len=is.read(buf))!=-1){
            out.write(buf,0,len);
        }

        out.close();
        is.close();

        request.getRequestDispatcher("/file/"+uniqueName).forward(request,response);

    }
}
